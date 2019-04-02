package com.compact.di.module;

import com.compact.di.qualifier.Endpoint;

import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lshabory on 3/8/18.
 */

@Module(includes = NetworkModule.class)
public class RequestModule {

    @Provides
    @Singleton
    Retrofit.Builder providesRequestBuilder(Set<Converter.Factory> converterFactories, Set<CallAdapter.Factory> callAdapterFactories, @Endpoint String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(HttpUrl.parse(baseUrl));

        for (Converter.Factory factory : converterFactories) {
            builder.addConverterFactory(factory);
        }

        for (CallAdapter.Factory factory : callAdapterFactories) {
            builder.addCallAdapterFactory(factory);
        }
        return builder;
    }

    @Provides
    @Singleton
    Retrofit providesRequestCached(Retrofit.Builder builder, OkHttpClient okHttpClient) {
        return builder.client(okHttpClient).build();
    }
}