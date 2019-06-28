package com.smart.sample.di

import android.app.Application
import com.compact.di.module.AuthenticatorModule
import com.compact.di.module.NetworkModule
import com.smart.sample.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    AppModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    AuthenticatorModule::class
])
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}