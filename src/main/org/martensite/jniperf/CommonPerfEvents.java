package org.martensite.jniperf;

public class CommonPerfEvents {

    /**
     * System Calls Manual * perf_event_open(2)
     * https://man7.org/linux/man-pages/man2/perf_event_open.2.html
     */

    /**
     * type
     * This field specifies the overall event type.
     * It has one of the following values:

     * PERF_TYPE_HARDWARE
     * This indicates one of the "generalized" hardware
     * events provided by the kernel.  See the config field definition for more details.

     * PERF_TYPE_SOFTWARE
     * This indicates one of the software-defined events
     * provided by the kernel (even if no hardware support is available).

     * PERF_TYPE_TRACEPOINT
     * This indicates a tracepoint provided by the kernel tracepoint infrastructure.

     * PERF_TYPE_HW_CACHE
     * This indicates a hardware cache event.  This has a special encoding,
     * described in the config field definition.

     * PERF_TYPE_RAW
     * This indicates a "raw" implementation-specific event in the config field.
     */

    public static final int PERF_TYPE_HARDWARE = 0;
    public static final int PERF_TYPE_HW_CACHE = 3;
    public static final int PERF_TYPE_RAW = 4;

    /**
     * If type is PERF_TYPE_HARDWARE, we are measuring one of the
     * generalized hardware CPU events.  Not all of these are
     * available on all platforms.  Set config to one of the following:

     * PERF_COUNT_HW_CPU_CYCLES
     * Total cycles.  Be wary of what happens during
     * CPU frequency scaling.

     * PERF_COUNT_HW_INSTRUCTIONS
     * Retired instructions.  Be careful, these can be
     * affected by various issues, most notably hardware interrupt counts.

     * PERF_COUNT_HW_CACHE_REFERENCES
     * Cache accesses. Usually this indicates Last Level Cache accesses but this may vary
     * depending on your CPU.  This may include prefetches and coherency messages;
     * again this depends on the design of your CPU.

     * PERF_COUNT_HW_CACHE_MISSES
     * Cache misses.  Usually this indicates Last Level Cache misses; this is intended
     * to be used in conjunction with the PERF_COUNT_HW_CACHE_REFERENCES event to
     * calculate cache miss rates.

     * PERF_COUNT_HW_BRANCH_INSTRUCTIONS
     * Retired branch instructions.  Prior to Linux
     * 2.6.35, this used the wrong event on AMD processors.

     * PERF_COUNT_HW_BRANCH_MISSES
     * Mispredicted branch instructions.

     * PERF_COUNT_HW_BUS_CYCLES
     * Bus cycles, which can be different from total cycles.

     * PERF_COUNT_HW_STALLED_CYCLES_FRONTEND (since Linux 3.0)
     * Stalled cycles during issue.

     * PERF_COUNT_HW_STALLED_CYCLES_BACKEND (since Linux 3.0)
     * Stalled cycles during retirement.

     * PERF_COUNT_HW_REF_CPU_CYCLES (since Linux 3.3)
     * Total cycles; not affected by CPU frequency
     * scaling.
     */

    /**
     * Common hardware events, generalized by the kernel:
     */

    public static final int PERF_COUNT_HW_CPU_CYCLES = 0;
    public static final int PERF_COUNT_HW_INSTRUCTIONS = 1;
    public static final int PERF_COUNT_HW_CACHE_REFERENCES = 2;
    public static final int PERF_COUNT_HW_CACHE_MISSES = 3;
    public static final int PERF_COUNT_HW_BRANCH_INSTRUCTIONS = 4;
    public static final int PERF_COUNT_HW_BRANCH_MISSES = 5;
    public static final int PERF_COUNT_HW_BUS_CYCLES = 6;
    public static final int PERF_COUNT_HW_STALLED_CYCLES_FRONTEND	= 7;
    public static final int PERF_COUNT_HW_STALLED_CYCLES_BACKEND = 8;
    public static final int PERF_COUNT_HW_REF_CPU_CYCLES = 9;

    /**
     * If type is PERF_TYPE_HW_CACHE, then we are measuring a
     * hardware CPU cache event.  To calculate the appropriate
     * config value, use the following equation:

     * config = (perf_hw_cache_id) |
     * (perf_hw_cache_op_id << 8) |
     * (perf_hw_cache_op_result_id << 16);

     * where perf_hw_cache_id is one of:

     * PERF_COUNT_HW_CACHE_L1D
     * for measuring Level 1 Data Cache

     * PERF_COUNT_HW_CACHE_L1I
     * for measuring Level 1 Instruction Cache

     * PERF_COUNT_HW_CACHE_LL
     * for measuring Last-Level Cache

     * PERF_COUNT_HW_CACHE_DTLB
     * for measuring the Data TLB

     * PERF_COUNT_HW_CACHE_ITLB
     * for measuring the Instruction TLB

     * PERF_COUNT_HW_CACHE_BPU
     * for measuring the branch prediction unit

     * PERF_COUNT_HW_CACHE_NODE (since Linux 3.1)
     * for measuring local memory accesses

     * and perf_hw_cache_op_id is one of:

     * PERF_COUNT_HW_CACHE_OP_READ
     * for read accesses

     * PERF_COUNT_HW_CACHE_OP_WRITE
     * for write accesses

     * PERF_COUNT_HW_CACHE_OP_PREFETCH
     * for prefetch accesses

     * and perf_hw_cache_op_result_id is one of:

     * PERF_COUNT_HW_CACHE_RESULT_ACCESS
     * to measure accesses

     * PERF_COUNT_HW_CACHE_RESULT_MISS
     * to measure misses
     */

    public static final int PERF_COUNT_HW_CACHE_L1D = 0;
    public static final int PERF_COUNT_HW_CACHE_L1I = 1;
    public static final int PERF_COUNT_HW_CACHE_LL = 2;
    public static final int PERF_COUNT_HW_CACHE_DTLB = 3;
    public static final int PERF_COUNT_HW_CACHE_ITLB = 4;
    public static final int PERF_COUNT_HW_CACHE_BPU = 5;
    public static final int PERF_COUNT_HW_CACHE_NODE = 6;

    public static final int PERF_COUNT_HW_CACHE_OP_READ = 0;
    public static final int PERF_COUNT_HW_CACHE_OP_WRITE = 1;
    public static final int PERF_COUNT_HW_CACHE_OP_PREFETCH = 2;

    public static final int PERF_COUNT_HW_CACHE_RESULT_ACCESS = 0;
    public static final int PERF_COUNT_HW_CACHE_RESULT_MISS = 1;

    //config = (perf_hw_cache_id) | (perf_hw_cache_op_id << 8) | (perf_hw_cache_op_result_id << 16);

    //perf stat -e L1-dcache-loads,L1-dcache-load-miss
    public static final int PERF_COUNT_CACHE_L1D_READ_ACCESS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_READ << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_L1D_READ_MISS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_READ << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);

    //perf stat -e L1-dcache-stores,L1-dcache-store-misses
    //PERF_COUNT_CACHE_L1D_WRITE_MISS show same val as _ACCESS ?
    public static final int PERF_COUNT_CACHE_L1D_WRITE_ACCESS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_WRITE << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_L1D_WRITE_MISS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_WRITE << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);

    public static final int PERF_COUNT_CACHE_L1D_PREFETCH_ACCESS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_PREFETCH << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_L1D_PREFETCH_MISS = PERF_COUNT_HW_CACHE_L1D | (PERF_COUNT_HW_CACHE_OP_PREFETCH << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);

    //perf stat -e LLC-loads,LLC-load-misses
    public static final int PERF_COUNT_CACHE_LL_READ_ACCESS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_READ << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_LL_READ_MISS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_READ << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);
    public static final int PERF_COUNT_CACHE_LL_WRITE_ACCESS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_WRITE << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_LL_WRITE_MISS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_WRITE << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);
    public static final int PERF_COUNT_CACHE_LL_PREFETCH_ACCESS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_PREFETCH << 8) | (PERF_COUNT_HW_CACHE_RESULT_ACCESS << 16);
    public static final int PERF_COUNT_CACHE_LL_PREFETCH_MISS = PERF_COUNT_HW_CACHE_LL | (PERF_COUNT_HW_CACHE_OP_PREFETCH << 8) | (PERF_COUNT_HW_CACHE_RESULT_MISS << 16);

    /**
     * particular cpu performance monitoring event index
     * current version supports only x86 Intel CPU family
     */

    public static final int PERF_COUNT_RAW_MEM_ALL_LOADS = 0;
    public static final int PERF_COUNT_RAW_MEM_ALL_STORES = 1;
    public static final int PERF_COUNT_RAW_L1D_LOAD_MISSES = 2;
    public static final int PERF_COUNT_RAW_L1D_LOAD_HITS = 3;
    public static final int PERF_COUNT_RAW_L2_REFERENCES = 4;
    public static final int PERF_COUNT_RAW_L2_MISSES = 5;
    public static final int PERF_COUNT_RAW_L2_LOADS = 6;
    public static final int PERF_COUNT_RAW_L2_LOAD_MISSES = 7;
    public static final int PERF_COUNT_RAW_L2_LOAD_HITS = 8;
    public static final int PERF_COUNT_RAW_LLC_REFERENCES = 9;
    public static final int PERF_COUNT_RAW_LLC_MISSES = 10;

    /**
     * The pid and cpu arguments allow specifying which process and CPU
     * to monitor:

     * pid == 0 and cpu == -1
     * This measures the calling process/thread on any CPU.

     * pid == 0 and cpu >= 0
     * This measures the calling process/thread only when running on the specified CPU.

     * pid > 0 and cpu == -1
     * This measures the specified process/thread on any CPU.

     * pid > 0 and cpu >= 0
     * This measures the specified process/thread only when running on the specified CPU.

     * pid == -1 and cpu >= 0
     * This measures all processes/threads on the specified CPU.
     * This requires CAP_PERFMON (since Linux 5.8) or
     * CAP_SYS_ADMIN capability or a /proc/sys/kernel/perf_event_paranoid value of less than 1.

     * pid == -1 and cpu == -1
     * This setting is invalid and will return an error.
     */

    public static final int PID_CURRENT = 0;
    public static final int CPU_ANY = -1;

    public static final int PERF_FLAGS_DEFAULT = 0;

}
