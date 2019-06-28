package com.smart.sample.di

import com.compact.di.module.AuthenticatorModule
import com.compact.di.module.TestNetworkModule
import com.compact.di.module.TestSchedulerModule
import com.smart.sample.TrendViewModelTest
import com.smart.sample.TrendViewModelTestMockServer
import com.smart.sample.base.BaseTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestNetworkModule::class,
    TestAppModule::class,
    ViewModelModule::class,
    AuthenticatorModule::class,
    TestSchedulerModule::class
])
interface TestAppComponent {
    fun inject(testClass: BaseTest)
    fun inject(testClass: TrendViewModelTest)
    fun inject(testClass: TrendViewModelTestMockServer)
}