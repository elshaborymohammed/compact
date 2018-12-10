package com.smart.compact.di.module;

import com.smart.compact.executor.AppExecutors;
import com.smart.compact.executor.MainThread;
import com.smart.compact.executor.WorkerThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class SchedulerModule {
    @Provides
    @Singleton
    Executor providesExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    MainThread providesMainThread(AppExecutors executors) {
        return () -> Schedulers.from(executors.mainThread());
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler(Executor executor) {
        return () -> Schedulers.from(executor);
    }
}