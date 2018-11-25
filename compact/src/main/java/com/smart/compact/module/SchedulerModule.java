package com.smart.compact.module;

import com.smart.compact.qualifier.IOScheduler;
import com.smart.compact.qualifier.SingleScheduler;
import com.smart.compact.qualifier.UIScheduler;
import com.smart.compact.qualifier.WorkerScheduler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class SchedulerModule {
    @Provides
    @Singleton
    @IOScheduler
    Scheduler providesNetworkScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @WorkerScheduler
    Scheduler providesNewThreadScheduler() {
        return Schedulers.newThread();
    }

    @Provides
    @Singleton
    @SingleScheduler
    Scheduler providesSingleScheduler() {
        return Schedulers.single();
    }

    @Provides
    @Singleton
    @UIScheduler
    Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}