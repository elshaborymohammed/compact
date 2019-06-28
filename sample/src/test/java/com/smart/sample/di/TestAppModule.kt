package com.smart.sample.di

import com.compact.di.module.GsonModule
import com.compact.di.module.RequestModule
import com.compact.di.module.TestRequestModule
import com.compact.di.qualifier.DatePattern
import com.compact.di.qualifier.Endpoint
import com.compact.requester.adapter.CompactCallAdapter
import com.google.gson.Gson
import com.smart.sample.data.module.ProtocolModule
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockWebServer
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
    GsonModule::class,
    RequestModule::class,
    ProtocolModule::class
])
class TestAppModule {

    @Provides
    @Singleton
    @DatePattern
    fun providesDatePattern(): String {
        return GsonModule.providesDatePattern()
    }

//    @Provides
//    @Singleton
//    @Endpoint
//    fun providesEndpoint(mockWebServer: MockWebServer): HttpUrl {
//        //return "https://api.github.com/"
//        return mockWebServer.url("/")
//    }

    @Provides
    @Singleton
    @Endpoint
    fun providesEndpoint(mockWebServer: MockWebServer): String {
        //return "https://api.github.com/"
        return mockWebServer.url("/").toString()
    }

    @Provides
    @IntoSet
    internal fun providesGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @IntoSet
    fun providesCompactCallAdapterFactory(): CallAdapter.Factory {
        return CompactCallAdapter.Factory.create()
    }

    @Singleton
    @Provides
    fun providesMockWebServer(): MockWebServer = MockWebServer()
}