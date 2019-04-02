package com.smart.github.di

import com.compact.di.module.GsonModule
import com.compact.di.module.RequestModule
import com.compact.di.qualifier.DatePattern
import com.compact.di.qualifier.Endpoint
import com.compact.requester.adapter.CompactCallAdapter
import com.google.gson.Gson
import com.smart.github.data.repository.TrendsRepository
import com.smart.github.domain.protocol.ITrendsProtocol
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    GsonModule::class,
    RequestModule::class
])
class AppModule {

    @Provides
    @Singleton
    @DatePattern
    fun providesDatePattern(): String {
        return GsonModule.providesDatePattern()
    }

    @Provides
    @Singleton
    @Endpoint
    fun providesEndpoint(): String {
        return "https://api.github.com/"
    }

    @Provides
    @IntoSet
    internal fun providesGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @IntoSet
    fun providesCompactCallAdaterFactory(): CallAdapter.Factory {
        return CompactCallAdapter.Factory.create();
    }

    @Provides
    @Singleton
    fun providesTrendsProtocol(trendsProtocol: TrendsRepository): ITrendsProtocol {
        return trendsProtocol
    }
}