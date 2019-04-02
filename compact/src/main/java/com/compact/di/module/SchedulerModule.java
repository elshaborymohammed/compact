package com.compact.di.module;

import com.compact.executor.AppExecutors;
import com.compact.executor.MainThread;
import com.compact.executor.WorkerThread;

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
    MainThread providesMainThread(AppExecutors executors) {
        return () -> Schedulers.from(executors.mainThread());
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler(AppExecutors executors) {
        return () -> Schedulers.from(executors.networkIO());
    }
}