package com.smart.compact.module;

import android.app.Application;
import android.content.Context;

import com.smart.compact.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lshabory on 3/8/18.
 */

@Module
public class ContextModule {

    @Provides
    @Singleton
    @ApplicationContext
    Context providesApplicationContext(Application application) {
        return application.getApplicationContext();
    }
}