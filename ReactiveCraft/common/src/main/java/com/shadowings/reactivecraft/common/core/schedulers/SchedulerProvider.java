package com.shadowings.reactivecraft.common.core.schedulers;

import io.reactivex.Scheduler;

public class SchedulerProvider {
    private static Scheduler workerScheduler;

    public static Scheduler getWorkerScheduler() {
        return workerScheduler;
    }

    public static void setWorkerScheduler(Scheduler workerScheduler) {
        SchedulerProvider.workerScheduler = workerScheduler;
    }
}
