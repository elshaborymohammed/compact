package com.smart.sample.app.di

import android.app.Application
import com.compact.app.di.binding.AndroidBindingModule
import com.compact.di.module.AuthenticatorModule
import com.smart.sample.app.App
import com.smart.sample.data.module.ProtocolModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidBindingModule::class,
    ViewModelModule::class,
    AuthenticatorModule::class,
    ProtocolModule::class
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