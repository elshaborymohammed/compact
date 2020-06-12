package com.compact.di.module;

import com.compact.executor.MainExecutor;
import com.compact.executor.MainThread;
import com.compact.executor.RxCompactSchedulers;
import com.compact.executor.WorkerExecutor;
import com.compact.executor.WorkerThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class SchedulerModule {
    @Provides
    @Singleton
    MainThread providesMainThread(MainExecutor executor) {
        return () -> Schedulers.from(executor);
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler(WorkerExecutor executor) {
        return () -> Schedulers.from(executor);
    }

    @Provides
    @Singleton
    RxCompactSchedulers providesSchedulerCompose(WorkerThread workerThread, MainThread mainThread) {
        return new RxCompactSchedulers(workerThread, mainThread);
    }
}