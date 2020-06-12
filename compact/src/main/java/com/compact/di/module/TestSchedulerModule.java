package com.compact.di.module;

import com.compact.executor.MainThread;
import com.compact.executor.RxCompactSchedulers;
import com.compact.executor.WorkerThread;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class TestSchedulerModule {
    @Provides
    @Singleton
    MainThread providesMainThread() {
        return this::testScheduler;
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler() {
        return this::testScheduler;
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
                return new ExecutorScheduler.ExecutorWorker(Runnable::run, false, false);
            }

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
                return super.scheduleDirect(run, 0, unit);
            }
        };
    }
}