package com.smart.sample.domain.usecase

import com.smart.compact.response.Resource
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.protocol.ITrendsProtocol
import io.reactivex.Completable
import io.reactivex.Single
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