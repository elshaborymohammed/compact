package com.smart.compact.module;

import android.arch.lifecycle.ViewModelProvider;

import com.smart.compact.AppCompactViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * Created by lshabory on 3/23/18.
 */

@Module(includes = {
        AndroidInjectionModule.class,
        ContextModule.class,
        RequestModule.class,
        PreferenceModule.class,
        SchedulerModule.class,
})
public abstract class AppCompactModule {

    @Binds
    abstract ViewModelProvider.Factory bind(AppCompactViewModelFactory factory);
}