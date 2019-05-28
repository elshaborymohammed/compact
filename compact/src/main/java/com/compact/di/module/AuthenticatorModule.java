package com.compact.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;

@Module
public class AuthenticatorModule {
    @Provides
    @Singleton
    Authenticator providesAuthenticator() {
        return Authenticator.NONE;
    }
}