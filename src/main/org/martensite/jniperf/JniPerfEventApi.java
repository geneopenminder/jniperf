package org.martensite.jniperf;

public class JniPerfEventApi {

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

    public static JniPerfEventApi create(String libraryPath) {
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            System.load(libraryPath);
            return new JniPerfEventApi();
        } else {
            throw new RuntimeException("OS not supported.");
        }
    }

    public native int perfEventOpen(int eventType, int eventId, int pid, int cpu, long flags);

    public native void closePerfEvent(int fd);

    public native long getCounterValue(int fd);

}
