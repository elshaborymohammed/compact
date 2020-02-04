package com.compact.di.module;

import com.compact.di.qualifier.Endpoint;

import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lshabory on 3/8/18.
 */
@Module
public class TestRequestBuilderModule {

    @Provides
    @Singleton
    Retrofit.Builder providesRequestBuilder(Set<Converter.Factory> converterFactories, Set<CallAdapter.Factory> callAdapterFactories, @Endpoint String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl);

        for (Converter.Factory factory : converterFactories) {
            builder.addConverterFactory(factory);
        }

        for (CallAdapter.Factory factory : callAdapterFactories) {
            builder.addCallAdapterFactory(factory);
        }
        return builder;
    }
}