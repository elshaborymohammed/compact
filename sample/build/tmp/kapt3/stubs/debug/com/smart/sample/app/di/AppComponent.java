package com.smart.sample.app.di;

import android.app.Application;
import com.compact.di.module.AuthenticatorModule;
import com.compact.di.module.NetworkModule;
import com.smart.sample.app.App;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/smart/sample/app/di/AppComponent;", "", "inject", "", "app", "Lcom/smart/sample/app/App;", "Builder", "sample_debug"})
@dagger.Component(modules = {com.compact.di.module.NetworkModule.class, com.smart.sample.app.di.AppModule.class, com.smart.sample.app.di.ActivityModule.class, com.smart.sample.app.di.ViewModelModule.class, com.compact.di.module.AuthenticatorModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.smart.sample.app.App app);
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/smart/sample/app/di/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/smart/sample/app/di/AppComponent;", "sample_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract com.smart.sample.app.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.smart.sample.app.di.AppComponent build();
    }
}