package com.compact.executor;

import io.reactivex.Scheduler;

public interface MainThread {
    Scheduler getScheduler();
}