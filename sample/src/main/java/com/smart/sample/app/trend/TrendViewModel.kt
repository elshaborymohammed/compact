package com.smart.sample.ui.trend

import com.compact.app.viewmodel.CompactViewModel
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase) : CompactViewModel() {

    fun get(): Single<List<Trend>> {
        return useCase.buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
    }

    fun int(): Int {
        return 50
    }
}