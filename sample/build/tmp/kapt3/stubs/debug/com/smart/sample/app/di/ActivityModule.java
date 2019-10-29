package com.smart.sample.app.di;

import com.smart.sample.app.trend.TrendActivity;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'\u00a8\u0006\u0005"}, d2 = {"Lcom/smart/sample/app/di/ActivityModule;", "", "()V", "bindMainActivity", "Lcom/smart/sample/app/trend/TrendActivity;", "sample_debug"})
@dagger.Module(includes = {dagger.android.AndroidInjectionModule.class})
public abstract class ActivityModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.smart.sample.app.trend.TrendActivity bindMainActivity();
    
    public ActivityModule() {
        super();
    }
}