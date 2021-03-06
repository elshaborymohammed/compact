package com.compact.di.module;

import androidx.annotation.NonNull;

import com.compact.di.qualifier.Endpoint;

import java.util.Objects;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lshabory on 3/8/18.
 */
@Module
public class RequestBuilderModule {

    @Provides
    @Singleton
    Retrofit.Builder providesRequestBuilder(Set<Converter.Factory> converterFactories, Set<CallAdapter.Factory> callAdapterFactories, @NonNull @Endpoint String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Objects.requireNonNull(HttpUrl.parse(baseUrl)));

        for (Converter.Factory factory : converterFactories) {
            builder.addConverterFactory(factory);
        }

        for (CallAdapter.Factory factory : callAdapterFactories) {
            builder.addCallAdapterFactory(factory);
        }
        return builder;
    }
}