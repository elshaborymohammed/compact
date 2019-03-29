package com.smart.github.domain.usecase

import com.smart.github.domain.model.Trend
import com.smart.github.domain.protocol.ITrendsProtocol
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendsUseCase @Inject constructor(private val trendsProtocol: ITrendsProtocol) {

    fun buildUseCaseObservable(): Single<List<Trend>> {
        return this.trendsProtocol.get()
    }
}