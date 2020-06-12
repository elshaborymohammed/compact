package com.smart.sample.domain.usecase

import com.compact.response.Resource
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.protocol.ITrendsProtocol
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendsUseCase @Inject constructor(private val trendsProtocol: ITrendsProtocol) {

    fun buildUseCaseObservable(): Single<List<Trend>> {
        return this.trendsProtocol.get()
    }

    fun buildUseCaseObservableResource(): Single<Resource<List<Trend>>> {
        return this.trendsProtocol.resource()
    }

    fun completable(): Completable {
        return this.trendsProtocol.completable()
    }
}