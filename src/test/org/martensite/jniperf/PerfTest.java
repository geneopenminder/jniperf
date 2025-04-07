package org.martensite.jniperf;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.concurrent.ThreadLocalRandom;

import static org.martensite.jniperf.CommonPerfEvents.*;

public class PerfTest extends TestCase {

    public PerfTest(String testName ) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PerfTest.class);
    }

    public void testPerfTypeHardwareForeign() {
        ForeignPerfEventApi api = new ForeignPerfEventApi();
        int fd = api.perfEventOpen(PERF_TYPE_HARDWARE, PERF_COUNT_HW_INSTRUCTIONS, PID_CURRENT, CPU_ANY, PERF_FLAGS_DEFAULT);
        Assert.assertTrue(fd > 0);
        long counter1 = api.getCounterValue(fd);
        ThreadLocalRandom.current().nextLong();
        long counter2 = api.getCounterValue(fd);
        Assert.assertNotSame(counter1, counter2);
        api.closePerfEvent(fd);
    }

    public void testPerfTypeRawForeign() {
        ForeignPerfEventApi api = new ForeignPerfEventApi();
        int fd = api.perfEventOpen(PERF_TYPE_RAW, x86IntelRawEvents.L1D_ALL_REF_ANY, PID_CURRENT, CPU_ANY, PERF_FLAGS_DEFAULT);
        Assert.assertTrue(fd > 0);
        long counter1 = api.getCounterValue(fd);
        ThreadLocalRandom.current().nextLong();
        long counter2 = api.getCounterValue(fd);
        Assert.assertNotSame(counter1, counter2);
        api.closePerfEvent(fd);
    }

    /*
    public void testPerfTypeHardware() {
        File projectDir = new File("target/native/jniperf.so");
        JniPerfEventApi api = JniPerfEventApi.create(projectDir.getAbsolutePath());
        int fd = api.perfEventOpen(CommonPerfEvents.PERF_TYPE_HARDWARE, CommonPerfEvents.PERF_COUNT_HW_CPU_CYCLES, CommonPerfEvents.PID_CURRENT, CommonPerfEvents.CPU_ANY, CommonPerfEvents.PERF_FLAGS_DEFAULT);
        Assert.assertTrue(fd > 0);
        long counter1 = api.getCounterValue(fd);
        ThreadLocalRandom.current().nextLong();
        long counter2 = api.getCounterValue(fd);
        Assert.assertNotSame(counter1, counter2);
        api.closePerfEvent(fd);
    }

    public void testPerfTypeRaw() {
        File projectDir = new File("target/native/jniperf.so");
        JniPerfEventApi api = JniPerfEventApi.create(projectDir.getAbsolutePath());
        int fd = api.perfEventOpenRaw(x86IntelRawEvents.L1D_ALL_REF_ANY, CommonPerfEvents.PID_CURRENT, CommonPerfEvents.CPU_ANY, CommonPerfEvents.PERF_FLAGS_DEFAULT);
        Assert.assertTrue(fd > 0);
        long counter1 = api.getCounterValue(fd);
        ThreadLocalRandom.current().nextLong();
        long counter2 = api.getCounterValue(fd);
        Assert.assertNotSame(counter1, counter2);
        api.closePerfEvent(fd);
    }
     */

}
