**Simple Java API for perf_event_open syscall**

Uses JNI or Foreign API

Java 21+ example:

    

	ForeignPerfEventApi api = new ForeignPerfEventApi();
	int fd = api.perfEventOpen(PERF_TYPE_HARDWARE, PERF_COUNT_HW_INSTRUCTIONS, PID_CURRENT, CPU_ANY, PERF_FLAGS_DEFAULT);
 
	long counter1 = api.getCounterValue(fd);
    		.....
	long counter2 = api.getCounterValue(fd);
	api.closePerfEvent(fd);

**Also you could use raw events. For example x86**
        
    ForeignPerfEventApi api = new ForeignPerfEventApi();
    int fd = api.perfEventOpen(PERF_TYPE_RAW, x86IntelRawEvents.L1D_ALL_REF_ANY, PID_CURRENT, CPU_ANY, PERF_FLAGS_DEFAULT);
      
    long counter1 = api.getCounterValue(fd);
    ...
    long counter2 = api.getCounterValue(fd);
    api.closePerfEvent(fd);
