#include <jni.h>
#include <sys/syscall.h>
#include <linux/unistd.h>
#include <linux/perf_event.h>
#include <stdint.h>
#include <stdlib.h>
#include <sys/ioctl.h>
#include <fcntl.h>
#include <string.h>

int perf_event_open(struct perf_event_attr * hw, pid_t pid, int cpu, int grp, unsigned long flags)
{
    return syscall(__NR_perf_event_open, hw, pid, cpu, grp, flags);
}

JNIEXPORT jint JNICALL
Java_org_martensite_jniperf_PerfEventApi_perfEventOpen(JNIEnv *, jobject, jint type, jint event, jint pid, jint cpu, jlong flags)
{
    struct perf_event_attr pe;
    int fd;

    memset(&pe, 0, sizeof(struct perf_event_attr));
    pe.type = (unsigned long) type;
    pe.size = sizeof(struct perf_event_attr);
    pe.config = 0x0000ffffffff & event;
    pe.disabled = 0;
    pe.exclude_kernel = 0;

    fd = perf_event_open(&pe, pid, cpu, -1, flags);

    if (fd < 0) {
      return -1;
    }
    return fd;
}

JNIEXPORT void JNICALL
Java_org_martensite_jniperf_PerfEventApi_closePerfEvent(JNIEnv *, jobject, jint fd)
{
    close(fd);
}

JNIEXPORT jlong JNICALL
Java_org_martensite_jniperf_PerfEventApi_getCounterValue(JNIEnv *, jobject, jint fd)
{
    long long count;
    read(fd, &count, sizeof(long long));
    return count;
}