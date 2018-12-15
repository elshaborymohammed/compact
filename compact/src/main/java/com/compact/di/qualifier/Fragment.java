package com.compact.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by lshabory on 2/12/2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Fragment {
}