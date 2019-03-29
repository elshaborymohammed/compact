package com.smart.github.domain.protocol

import com.smart.github.domain.model.Trend
import io.reactivex.Single

interface ITrendsProtocol {
    fun get(): Single<List<Trend>>
}