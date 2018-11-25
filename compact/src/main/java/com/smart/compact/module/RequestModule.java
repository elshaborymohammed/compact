package com.smart.compact.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smart.compact.qualifier.Cached;
import com.smart.compact.qualifier.DatePattern;
import com.smart.compact.qualifier.DefaultDatePattern;
import com.smart.compact.qualifier.Endpoint;
import com.smart.compact.qualifier.NonCached;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lshabory on 3/8/18.
 */

@Module(includes = NetworkModule.class)
public class RequestModule {

    @Provides
    @Singleton
    @DefaultDatePattern
    Gson provideGSONDefaultDatePattern() {
        return provideGSONDatePattern("yyyy-MM-dd'T'HH:mm:ssZ");
    }

    @Provides
    @Singleton
    @DatePattern
    Gson provideGSONDatePattern(@DatePattern String pattern) {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat(pattern)
                .create();
    }

    @Provides
    @Singleton
    Retrofit.Builder providesRequestBuilder(@DefaultDatePattern Gson gson, @Endpoint String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
    }

    @Provides
    @Singleton
    @Cached
    Retrofit providesRequestCached(Retrofit.Builder builder, @Cached OkHttpClient okHttpClient) {
        return builder.client(okHttpClient).build();
    }

    @Provides
    @Singleton
    @NonCached
    Retrofit providesRequestNonCached(Retrofit.Builder builder, @NonCached OkHttpClient okHttpClient) {
        return builder.client(okHttpClient).build();
    }
}