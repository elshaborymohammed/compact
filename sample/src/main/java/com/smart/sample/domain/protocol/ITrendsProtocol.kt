package com.smart.sample.domain.protocol

import com.smart.compact.response.Resource
import com.smart.sample.domain.model.Trend
import io.reactivex.Completable
import io.reactivex.Single

interface ITrendsProtocol {
    fun get(): Single<List<Trend>>

    fun resource(): Single<Resource<List<Trend>>>

    fun completable(): Completable
}