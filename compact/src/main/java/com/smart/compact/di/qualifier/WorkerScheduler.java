package com.smart.compact.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by lshabory on 3/16/18.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkerScheduler {
}