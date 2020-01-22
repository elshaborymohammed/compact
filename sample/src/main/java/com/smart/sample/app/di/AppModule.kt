package com.smart.sample.app.di

import com.compact.di.module.GsonModule
import com.compact.di.module.RequestBuilderModule
import com.compact.di.module.RequestModule
import com.compact.di.module.SchedulerModule
import com.compact.di.qualifier.DatePattern
import com.compact.di.qualifier.Endpoint
import com.compact.requester.adapter.RxCompactCallAdapterFactory
import com.google.gson.Gson
import com.smart.sample.data.module.ProtocolModule
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    GsonModule::class,
    RequestBuilderModule::class,
    RequestModule::class,
    SchedulerModule::class,
    ProtocolModule::class
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
//        return "https://newbadawer.overcoffees.com/api/mobile/"
    }

    @Provides
    @IntoSet
    internal fun providesGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @IntoSet
    fun providesCompactCallAdapterFactory(): CallAdapter.Factory {
        return RxCompactCallAdapterFactory.create()
    }
}