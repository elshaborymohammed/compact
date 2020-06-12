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
public class NetworkModule {

    @Provides
    @IntoSet
    Protocol providesProtocolHTTP1() {
        return Protocol.HTTP_1_1;
    }

    @Provides
    @IntoSet
    Protocol providesProtocolHTTP2() {
        return Protocol.HTTP_2;
    }

    @Provides
    @IntoSet
    Interceptor providesBodyInterceptors() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(Set<Protocol> protocols, Set<Interceptor> interceptors, Cache cache, Authenticator authenticator) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .protocols(new ArrayList<>(protocols))
                .cache(cache)
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        builder.interceptors().addAll(interceptors);
        if (Authenticator.NONE != authenticator)
            builder.authenticator(authenticator);
        return builder;
    }
}