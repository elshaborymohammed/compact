package com.compact.di.module;

import com.compact.executor.AppExecutors;
import com.compact.executor.MainThread;
import com.compact.executor.WorkerThread;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class TestSchedulerModule {
    @Provides
    @Singleton
    MainThread providesMainThread() {
        return () -> testScheduler();
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler() {
        return () -> testScheduler();
    }

    Scheduler testScheduler() {
//        return Schedulers.trampoline();
        return new Scheduler() {

            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(runnable -> runnable.run());
            }

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
                return super.scheduleDirect(run, 0, unit);
            }
        };
    }
}