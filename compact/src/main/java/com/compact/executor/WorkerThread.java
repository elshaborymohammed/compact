package com.compact.executor;

import io.reactivex.rxjava3.core.Scheduler;

public interface WorkerThread {
    Scheduler getScheduler();
}