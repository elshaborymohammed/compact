package com.compact.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lshabory on 3/8/18.
 */

@Module(includes = {RequestBuilderModule.class})
public class RequestModule {

    @Provides
    @Singleton
    Retrofit providesRequest(Retrofit.Builder builder, OkHttpClient.Builder okHttpClientBuilder) {
        return builder.client(okHttpClientBuilder.build()).build();
    }
}