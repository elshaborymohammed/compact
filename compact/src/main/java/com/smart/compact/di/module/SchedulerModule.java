package com.smart.compact.di.module;

import com.smart.compact.executor.MainThread;
import com.smart.compact.executor.WorkerExecutor;
import com.smart.compact.executor.WorkerThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class SchedulerModule {
    @Provides
    @Singleton
    MainThread providesMainThread() {
        return () -> AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    WorkerThread providesNetworkScheduler(WorkerExecutor executor) {
        return () -> Schedulers.from(executor);
    }
}