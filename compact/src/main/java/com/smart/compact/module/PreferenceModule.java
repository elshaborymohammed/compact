package com.smart.compact.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smart.compact.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lshabory on 3/16/18.
 */

@Module
public class PreferenceModule {
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(@ApplicationContext Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}