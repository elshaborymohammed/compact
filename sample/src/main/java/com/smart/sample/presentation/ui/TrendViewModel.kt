package com.smart.sample.presentation.ui

import com.compact.app.viewmodel.CompactDataViewModel
import com.compact.executor.RxCompactSchedulers
import com.compact.response.Resource
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.usecase.TrendsUseCase
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendViewModel
@Inject constructor(private val useCase: TrendsUseCase, private val scheduler: RxCompactSchedulers) : CompactDataViewModel<List<Trend>>() {

    override fun subscription(): Disposable {
        return trends().subscribe(onSuccess(), onError())
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

    fun completable(): Completable {
        return useCase.completable()
                .compose(scheduler.applyOnCompletable())
                .compose(composeLoadingCompletable())
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