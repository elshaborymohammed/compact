package com.compact.executor;

import io.reactivex.Scheduler;

public interface WorkerThread {
    Scheduler getScheduler();
}