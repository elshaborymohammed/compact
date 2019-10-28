package com.smart.sample.app.trend

import com.compact.app.viewmodel.CompactViewModel
import com.compact.executor.MainThread
import com.compact.executor.WorkerThread
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase, private val subscribeOn: WorkerThread, private val observeOn: MainThread) : CompactViewModel<List<Trend>>() {

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
                useCase.buildUseCaseObservable()
                        .subscribeOn(subscribeOn.scheduler)
                        .observeOn(observeOn.scheduler)
                        .doOnSubscribe(doOnSubscribe())
                        .subscribe(doOnSuccess(), doOnError())
        )
    }

}