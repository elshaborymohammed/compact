package com.smart.github.di

import com.smart.github.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: App)
}