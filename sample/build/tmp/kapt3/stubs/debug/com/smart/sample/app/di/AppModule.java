package com.smart.sample.app.di;

import com.compact.di.module.GsonModule;
import com.compact.di.module.RequestModule;
import com.compact.di.module.SchedulerModule;
import com.compact.di.qualifier.DatePattern;
import com.compact.di.qualifier.Endpoint;
import com.compact.requester.adapter.RxCompactCallAdapterFactory;
import com.google.gson.Gson;
import com.smart.sample.data.module.ProtocolModule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001\u00a2\u0006\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/smart/sample/app/di/AppModule;", "", "()V", "providesCompactCallAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "providesDatePattern", "", "providesEndpoint", "providesGsonConverterFactory", "Lretrofit2/Converter$Factory;", "gson", "Lcom/google/gson/Gson;", "providesGsonConverterFactory$sample_debug", "sample_debug"})
@dagger.Module(includes = {com.compact.di.module.GsonModule.class, com.compact.di.module.RequestModule.class, com.compact.di.module.SchedulerModule.class, com.smart.sample.data.module.ProtocolModule.class})
public final class AppModule {
    
    @org.jetbrains.annotations.NotNull()
    @com.compact.di.qualifier.DatePattern()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final java.lang.String providesDatePattern() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.compact.di.qualifier.Endpoint()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final java.lang.String providesEndpoint() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.multibindings.IntoSet()
    @dagger.Provides()
    public final retrofit2.Converter.Factory providesGsonConverterFactory$sample_debug(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.multibindings.IntoSet()
    @dagger.Provides()
    public final retrofit2.CallAdapter.Factory providesCompactCallAdapterFactory() {
        return null;
    }
    
    public AppModule() {
        super();
    }
}