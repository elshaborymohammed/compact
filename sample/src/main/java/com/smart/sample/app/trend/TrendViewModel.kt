package com.smart.sample.app.trend

import com.compact.app.viewmodel.CompactDataViewModel
import com.compact.executor.RxCompactSchedulers
import com.smart.compact.response.Resource
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import io.reactivex.CompletableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase, private val scheduler: RxCompactSchedulers) : CompactDataViewModel<List<Trend>>() {

    override fun call() {
        useCase.buildUseCaseObservable()
                .compose(composeLoadingSingle())
                .subscribe(onSuccess(), onError())
    }

    fun trends(): Single<List<Trend>> {
        return useCase.buildUseCaseObservable()
                .compose(scheduler.applyOnSingle())
                .compose(composeLoadingSingle())
    }

    fun trendsResource(): Single<Resource<List<Trend>>> {
        return useCase.buildUseCaseObservableResource()
                .compose(scheduler.applyOnSingle())
                .compose(composeLoadingSingle())
    }

    fun completable() {
        useCase.completable()
                .compose(scheduler.applyOnCompletable())
                .compose(composeLoadingCompletable())
                .doOnSubscribe {
                    println("doOnSubscribe")
                }
                .subscribe({
                    println("onComplete")
                }, {
                    println("onError : $it")
                })
    }

    private inline fun <reified T> withSchedulers(): T {
        when (T::class) {
            ObservableTransformer::class -> return ObservableTransformer<Unit, Unit> {
                it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            } as T
            SingleTransformer::class -> return SingleTransformer<Unit, Unit> {
                it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            } as T
            CompletableTransformer::class -> return CompletableTransformer {
                it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            } as T
        }
        throw IllegalArgumentException("not a valid Transformer type")
    }

}