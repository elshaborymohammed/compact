package com.smart.sample.ui.trend

import com.compact.app.viewmodel.CompactViewModel
import com.compact.executor.MainThread
import com.compact.executor.WorkerThread
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase, private val subscribeOn: WorkerThread, private val observeOn: MainThread) : CompactViewModel() {

    fun get(): Single<List<Trend>> {
        return useCase.buildUseCaseObservable()
                .subscribeOn(subscribeOn.scheduler)
                .observeOn(observeOn.scheduler)
    }
}