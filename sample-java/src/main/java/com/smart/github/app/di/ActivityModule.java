package com.smart.github.app.di;

import com.smart.github.app.trend.TrendActivity;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract TrendActivity bindMainActivity();
}
