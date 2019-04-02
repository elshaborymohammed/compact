package com.compact.di.module;

import com.compact.di.qualifier.DatePattern;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {
    public static final String providesDatePattern() {
        return "yyyy-MM-dd'T'HH:mm:ssZ";
    }

    @Provides
    @Singleton
    Gson providesGson(@DatePattern String pattern) {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat(pattern)
                .create();
    }
}
