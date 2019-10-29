package com.elmenus.task.app.di.module

import android.content.Context
import com.compact.di.module.GsonModule
import com.compact.di.module.RequestModule
import com.compact.di.module.SchedulerModule
import com.compact.di.qualifier.ApplicationContext
import com.compact.di.qualifier.DatePattern
import com.compact.di.qualifier.Endpoint
import com.compact.requester.adapter.RxCompactCallAdapterCompletable
import com.elmenus.task.data.local.AppDatabase
import com.elmenus.task.data.local.dao.ItemsDao
import com.elmenus.task.data.local.dao.TagsDao
import com.elmenus.task.data.module.ProtocolModule
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * build DI Module graph that has GsonModule, RequestModule, ProtocolModule, SchedulerModule
 * and  provides
 */
@Module(
        includes = [
            GsonModule::class,
            RequestModule::class,
            ProtocolModule::class,
            SchedulerModule::class
        ]
)
class AppModule {

    @Provides
    @Singleton
    @DatePattern
    fun providesDatePattern(): String {
        return GsonModule.providesDatePattern()
    }

    /**
     * provides base url for API
     */
    @Provides
    @Singleton
    @Endpoint
    fun providesEndpoint(): String {
        return "https://elmenus-assignment.getsandbox.com/"
    }

    /**
     * provides Gson converter to build object from data string that come from api
     */
    @Provides
    @IntoSet
    internal fun providesGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    /**
     * provides CallAdapterFactory responsible for convert retrofit call api
     *  into Rx.Single object
     */
    @Provides
    @IntoSet
    fun providesCompactCallAdapterFactory(): CallAdapter.Factory {
        return RxCompactCallAdapterCompletable.Factory.create()
    }

    /**
     * provides Okhttp Interceptor responsible for build request header
     */
    @Provides
    @IntoSet
    fun providesInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()
                request = request.newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build()
                return chain.proceed(request)
            }
        }
    }

    /**
     * provides database instance in di graph
     */
    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.invoke(context)
    }

    /**
     * provides Tags DAO
     */
    @Singleton
    @Provides
    fun providesTagDao(appDatabase: AppDatabase): TagsDao {
        return appDatabase.tagDao()
    }

    /**
     * provides Items DAO
     */
    @Singleton
    @Provides
    fun providesItemDao(appDatabase: AppDatabase): ItemsDao {
        return appDatabase.itemDao()
    }
}