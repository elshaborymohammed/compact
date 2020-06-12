package com.smart.sample.domain.protocol

import com.compact.response.Resource
import com.smart.sample.domain.model.Trend
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ITrendsProtocol {
    fun get(): Single<List<Trend>>

    fun resource(): Single<Resource<List<Trend>>>

    fun completable(): Completable
}