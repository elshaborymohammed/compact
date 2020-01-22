package com.compact.di.module;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by lshabory on 3/8/18.
 */

@Module
public class TestNetworkModule {

    @Provides
    @IntoSet
    Interceptor providesBodyInterceptors() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(Set<Interceptor> interceptors, Authenticator authenticator) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        builder.interceptors().addAll(interceptors);
        if (Authenticator.NONE != authenticator)
            builder.authenticator(authenticator);
        return builder;
    }
}