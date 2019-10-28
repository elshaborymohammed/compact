package com.smart.sample.domain.protocol

import com.smart.sample.domain.model.Trend
import io.reactivex.Single

interface ITrendsProtocol {
    fun get(): Single<List<Trend>>
}