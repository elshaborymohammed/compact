package com.compact.di.module;

import com.compact.executor.MainThread;
import com.compact.executor.RxCompactSchedulers;
import com.compact.executor.WorkerThread;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;

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

    @Provides
    @Singleton
    RxCompactSchedulers providesSchedulerCompose(WorkerThread workerThread, MainThread mainThread) {
        return new RxCompactSchedulers(workerThread, mainThread);
    }

    Scheduler testScheduler() {
//        return Schedulers.trampoline();
        return new Scheduler() {

            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(runnable -> runnable.run(), false);
            }

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
                return super.scheduleDirect(run, 0, unit);
            }
        };
    }
}