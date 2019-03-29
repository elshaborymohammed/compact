package com.compact.di.module;

import com.compact.di.qualifier.DatePattern;
import com.compact.di.qualifier.DefaultDatePattern;
import com.compact.di.qualifier.Endpoint;
import com.compact.requester.adapter.CompactCallAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lshabory on 3/8/18.
 */

@Module(includes = NetworkModule.class)
public class RequestModule {

//    @Provides
//    @Singleton
//    @DefaultDatePattern
//    Gson provideGSONDefaultDatePattern() {
//        return provideGSONDatePattern("yyyy-MM-dd'T'HH:mm:ssZ");
//    }
//
//    @Provides
//    @Singleton
//    @DatePattern
//    Gson provideGSONDatePattern(@DatePattern String pattern) {
//        return new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .excludeFieldsWithoutExposeAnnotation()
//                .setDateFormat(pattern)
//                .create();
//    }

    @Provides
    @Singleton
    Retrofit.Builder providesRequestBuilder(@DefaultDatePattern Gson gson, @Endpoint String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(HttpUrl.parse(baseUrl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CompactCallAdapter.Factory.create());
    }

    @Provides
    @Singleton
    Retrofit providesRequestCached(Retrofit.Builder builder, OkHttpClient okHttpClient) {
        return builder.client(okHttpClient).build();
    }
}