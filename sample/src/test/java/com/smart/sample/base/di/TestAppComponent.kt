package com.smart.sample.base.di

import com.compact.di.module.*
import com.smart.sample.data.repository.TrendsRepositoryTest
import com.smart.sample.domain.usecase.TrendsUseCaseTest
import com.smart.sample.presentation.ui.TrendViewModelTest
import dagger.Component
import javax.inject.Singleton

/**
 * this test component uses for injecting dependencies throughout test cases
 */
@Singleton
@Component(
        modules = [
            TestAppModule::class,
            TestSchedulerModule::class
        ]
)
interface TestAppComponent {
    fun inject(testClass: TrendsRepositoryTest)
    fun inject(testClass: TrendsUseCaseTest)
    fun inject(testClass: TrendViewModelTest)
}