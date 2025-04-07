package org.martensite.jniperf;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class ForeignPerfEventApi {

    /**
     * API provides jni proxy for linux perf_event_open()
     * with all abilities as defined in the base method
     * Before measuring set cpu affinity and perf_event_paranoid
     * sudo sysctl kernel.perf_event_paranoid=-1
     * taskset -c 0 <your program> -- set affinity for cpu 0
     * For getting current system events list look at the /sys/devices/cpu_core/events/
     * ls /sys/devices/cpu_core/events/
     * Definitions of hardware events could be found at perf tool source code
     * https://github.com/torvalds/linux/tree/master/tools/perf
     * Just run 'perf list' and grep for the particular counter
     */

    private static final int __NR_perf_event_open = 298;

    private static final FunctionDescriptor SYSCALL_DESCRIPTOR = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG);

    private static final FunctionDescriptor READ_DESCRIPTOR = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT);
    private static final FunctionDescriptor CLOSE_DESCRIPTOR = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT);


    private final MethodHandle syscall;
    private final MethodHandle readFD;
    private final MethodHandle closeFD;

    public ForeignPerfEventApi() {
        if (!System.getProperty("os.name").toLowerCase().contains("linux")) {
            throw new RuntimeException("Only Linux OS supported.");
        }

        Linker linker = Linker.nativeLinker();
        SymbolLookup libc = SymbolLookup.libraryLookup("libc.so.6", Arena.ofConfined());

        this.syscall = linker.downcallHandle(libc.find("syscall").orElseThrow(), SYSCALL_DESCRIPTOR);
        this.readFD = linker.downcallHandle(libc.find("read").orElseThrow(), READ_DESCRIPTOR);
        this.closeFD = linker.downcallHandle(libc.find("close").orElseThrow(), CLOSE_DESCRIPTOR);
    }

    public int perfEventOpen(int eventType, int eventId, int pid, int cpu, long flags) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment perf_attr = arena.allocate(136);
            perf_attr.fill((byte)0);
            perf_attr.set(ValueLayout.JAVA_INT, 0, eventType); //type
            perf_attr.set(ValueLayout.JAVA_INT, 8, eventId); //config

            return (int)this.syscall.invoke(__NR_perf_event_open, perf_attr, pid, cpu, -1, flags);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int closePerfEvent(int fd) {
        try {
            return (int)closeFD.invoke(fd);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public long getCounterValue(int fd) {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment fdSegment = arena.allocate(4);
            fdSegment.set(ValueLayout.JAVA_INT, 0, fd);
            MemorySegment value = arena.allocate(8);
            int resultCode = (int)readFD.invoke(fd, value, 8);
            if (resultCode != -1) {
                return value.get(ValueLayout.JAVA_INT, 0);
            } else {
                return -1;
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
