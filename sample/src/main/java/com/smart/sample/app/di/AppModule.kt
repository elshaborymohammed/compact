package com.smart.sample.app.di

import com.compact.di.module.*
import com.compact.di.qualifier.DatePattern
import com.compact.di.qualifier.Endpoint
import com.google.gson.Gson
import com.smart.sample.data.module.ProtocolModule
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.multibindings.IntoSet
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    NetworkModule::class,
    GsonModule::class,
    RequestBuilderModule::class,
    RequestModule::class,
    SchedulerModule::class,
    NetworkCacheModule::class
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
    fun providesCompactCallAdapterFactory(): CallAdapter.Factory {
        return RxJava3CallAdapterFactory.createSynchronous()
    }
}