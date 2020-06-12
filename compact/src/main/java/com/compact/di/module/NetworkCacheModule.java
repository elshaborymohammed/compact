package com.compact.di.module;

import android.content.Context;

import com.compact.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

@Module(includes = ContextModule.class)
public class NetworkCacheModule {
    @Provides
    @Singleton
    Cache provideOkHttpCache(@ApplicationContext Context context) {
        int cacheSize = 50 * 1024 * 1024; // 50 MiB
        return new Cache(context.getCacheDir(), cacheSize);
    }
}
