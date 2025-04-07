package org.martensite.jniperf;

public class x86IntelRawEvents {

    /**
     * Intel® 64 and IA32 Architectures Performance Monitoring Events
     */

    /**
     * MEM_LOAD_RETIRED.L1_HIT
     * EventSel=D1H, UMask=01H, Precise 39
     * Counts retired load instructions with at least one uop that hit in
     * the L1 data cache. This event includes all SW prefetches and lock
     * instructions regardless of the data source.
     */
    public static final int MEM_LOAD_RETIRED_L1_HIT = 0x01d1;

    /**
     * MEM_LOAD_RETIRED.L1_MISS
     * EventSel=D1H, UMask=08H, Precise
     * Counts retired load instru
     */
    public static final int MEM_LOAD_RETIRED_L1_MISS = 0x08d1;

    /**
     * MEM_LOAD_RETIRED.L2_HIT
     * EventSel=D1H, UMask=02H, Precise
     * Retired load instructions with L2 cache hits as data sources.
     */
    public static final int MEM_LOAD_RETIRED_L2_HIT = 0x02d1;

    /**
     * MEM_LOAD_RETIRED.L2_MISS
     * EventSel=D1H, UMask=10H, Precise
     * Retired load instructions missed L2 cache as data sources.
     */
    public static final int MEM_LOAD_RETIRED_L2_MISS = 0x10d1;

    /**
     * MEM_LOAD_RETIRED.L3_HIT
     * EventSel=D1H, UMask=04H, Precise
     * Counts retired load instructions with at least one uop that hit in the L3 cache.
     */
    public static final int MEM_LOAD_RETIRED_L3_HIT = 0x04d1;

    /**
     * MEM_LOAD_RETIRED.L3_MISS
     * EventSel=D1H, UMask=20H, Precise
     * Counts retired load instructions with at least one uop that missed in the L3 cache.
     */
    public static final int MEM_LOAD_RETIRED_L3_MISS = 0x20d1;

    /**
     * L2_LINES_IN.ALL
     * EventSel=F1H, UMask=07H
     * This event counts the number of L2 cache lines brought into the L2 cache.
     */
    public static final int L2_LINES_IN_ALL = 0x07f1;

    /**
     * L2_LINES_IN.SELF.DEMAND
     * EventSel=24H, UMask=40H
     * 2 cache misses.
     */
    public static final int L2_LINES_IN_SELF_DEMAND = 0x4024;

    /**
     * L2_REQUESTS.MISS
     * EventSel=2EH, UMask=41H, Architectural
     * Counts the number of L2 cache misses.
     */
    public static final int L2_REQUESTS_MISS = 0x412e;

    /**
     * L2_REQUESTS.REFERENCE
     * EventSel=2EH, UMask=4FH, Architectural
     * Counts the total number of L2 cache references.
     */
    public static final int L2_REQUESTS_REFERENCE = 0x4f2e;

    /**
     * L2_RQSTS.DEMAND_DATA_RD_MISS
     * EventSel=24H, UMask=21H
     * Demand data read requests that missed L2, no rejects.
     */
    public static final int L2_RQSTS_DEMAND_DATA_RD_MISS = 0x2124;

    /**
     * L2_RQSTS.RFO_MISS
     * EventSel=24H, UMask=22H
     * Counts the number of store RFO requests that miss the L2  cache.
     */
    public static final int L2_RQSTS_RFO_MISS = 0x2224;

    /**
     * L2_RQSTS.CODE_RD_MISS
     * EventSel=24H, UMask=24H
     * Number of instruction fetches that missed the L2 cache.
     */
    public static final int L2_RQSTS_CODE_RD_MISS = 0x2424;

    /**
     * L2_RQSTS.ALL_DEMAND_MISS
     * EventSel=24H, UMask=27H
     * Demand requests that miss L2 cache.
     */
    public static final int L2_RQSTS_ALL_DEMAND_MISS = 0x2724;

    /**
     * L2_RQSTS.L2_PF_MISS
     * EventSel=24H, UMask=30H
     * Counts all L2 HW prefetcher requests that missed L2.
     */
    public static final int L2_RQSTS_L2_PF_MISS = 0x3024;

    /**
     * L2_RQSTS.MISS
     * EventSel=24H, UMask=3FH
     * All requests that missed L2.

     * Counts read requests of any type with true-miss in the L2 cache.
     * True-miss excludes L2 misses that were merged with ongoing L2 misses.
     */
    public static final int L2_RQSTS_MISS = 0x3f24;

    /**
     * L2_RQSTS.DEMAND_DATA_RD_HIT
     * EventSel=24H, UMask=41H
     * Demand data read requests that hit L2 cache.
     */
    public static final int L2_RQSTS_DEMAND_DATA_RD_HIT = 0x4124;

    /**
     * L2_RQSTS.RFO_HIT
     * EventSel=24H, UMask=42H
     * Counts the number of store RFO requests that hit the L2 cache.
     */
    public static final int L2_RQSTS_RFO_HIT = 0x4224;

    /**
     * L2_RQSTS.L2_PF_HIT
     * EventSel=24H, UMask=50H
     * Counts all L2 HW prefetcher requests that hit L2.
     */
    public static final int L2_RQSTS_L2_PF_HIT = 0x5024;

    /**
     * L2_RQSTS.ALL_DEMAND_DATA_RD
     * EventSel=24H, UMask=E1H
     * Counts any demand and L1 HW prefetch data load requests to L2.
     */
    public static final int L2_RQSTS_ALL_DEMAND_DATA_RD = 0xe124;


    /**
     * L2_RQSTS.ALL_RFO
     * EventSel=24H, UMask=E2H
     * Counts all L2 store RFO requests.
     */
    public static final int L2_RQSTS_ALL_RFO = 0xe224;

    /**
     * L2_RQSTS.ALL_CODE_RD
     * EventSel=24H, UMask=E4H
     * Counts all L2 code requests.
     */
    public static final int L2_RQSTS_ALL_CODE_RD = 0xe424;

    /**
     * L2_RQSTS.ALL_DEMAND_REFERENCES
     * EventSel=24H, UMask=E7H
     * Demand requests to L2 cache.
     */
    public static final int L2_RQSTS_ALL_DEMAND_REFERENCES = 0xe724;

    /**
     * L2_RQSTS.ALL_PF
     * EventSel=24H, UMask=F8H
     * Counts all L2 HW prefetcher requests.
     */
    public static final int L2_RQSTS_ALL_PF = 0xf824;

    /**
     * L2_RQSTS.REFERENCES
     * EventSel=24H, UMask=FFH
     * All requests to L2 cache.
     * Counts all requests that were hit or true misses in L2 cache.
     * True-miss excludes misses that were merged with ongoing L2 misses.
     */
    public static final int L2_RQSTS_REFERENCES = 0xff24;

    /**
     * L2_DEMAND_RQSTS.WB_HIT
     * EventSel=27H, UMask=50H
     * Not rejected writebacks that hit L2 cache.
     */
    public static final int L2_RQSTS_WB_HIT = 0x5027;

    /**
     * L1D_CACHE_LD.MESI
     * EventSel=40H, UMask=0FH
     * L1 data cache reads.
     */
    public static final int L1D_CACHE_LD_MESI = 0x0f40;

    /**
     * L1D_ALL_REF.ANY
     * EventSel=43H, UMask=01H
     * All references to the L1 data cache.
     */
    public static final int L1D_ALL_REF_ANY = 0x0143;

    /**
     * L1D_ALL_REF.CACHEABLE
     * EventSel=43H, UMask=02H
     * L1 data cacheable reads and writes.
     */
    public static final int L1D_ALL_REF_CACHEABLE = 0x0243;

    /**
     * L1D_WB_L2.MESI
     * EventSel=28H, UMask=0FH
     * All L1 writebacks to L2.
     */
    public static final int L1D_WB_L2_MESI = 0x0f28;

    /**
     * L1D_CACHE_LD.I_STATE
     * EventSel=40H, UMask=01H
     * L1 data cache read in I state (misses).
     */
    public static final int L1D_CACHE_LD_I_STATE = 0x0140;

    /**
     * MEM_UOPS_RETIRED.ALL_LOADS
     * EventSel=D0H, UMask=81H, Precise
     * All retired load uops.
     */
    public static final int MEM_UOPS_RETIRED_ALL_LOADS = 0x81d0;

/**
 * MEM_UOPS_RETIRED.ALL_STORES
 * EventSel=D0H, UMask=82H, Precise
 * All retired store uops.
 */
    public static final int MEM_UOPS_RETIRED_ALL_STORES = 0x82d0;

/**
 * LONGEST_LAT_CACHE.MISS
 * EventSel=2EH, UMask=41H, Architectural
 * Core-originated cacheable demand requests missed LLC.
 */
    public static final int LONGEST_LAT_CACHE_MISS = 0x412e;

/**
 * LONGEST_LAT_CACHE.REFERENCE
 * EventSel=2EH, UMask=4FH, Architectural
 * Core-originated cacheable demand requests that refer to LLC.
 */
    public static final int LONGEST_LAT_CACHE_REFERENCE = 0x4f2e;

}
