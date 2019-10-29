package com.smart.sample.app.trend

import com.compact.app.viewmodel.CompactViewModel
import com.compact.executor.MainThread
import com.compact.executor.WorkerThread
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase, private val subscribeOn: WorkerThread, private val observeOn: MainThread) : CompactViewModel<List<Trend>>() {

    override fun call() {
        useCase.buildUseCaseObservable()
                .subscribeOn(subscribeOn.scheduler)
                .observeOn(observeOn.scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribe(doOnSuccess(), doOnError())
    }

    fun completable() {
        useCase.completable()
                .subscribeOn(subscribeOn.scheduler)
                .observeOn(observeOn.scheduler)
                .doOnSubscribe {
                    println("doOnSubscribe")
                }
                .subscribe({
                    println("onComplete")
                }, {
                    println("onError : $it")
                })
    }

}