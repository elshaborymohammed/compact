package com.smart.github.data.repository

import com.smart.github.data.api.RequesterTrendsApi
import com.smart.github.domain.model.Trend
import com.smart.github.domain.protocol.ITrendsProtocol
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendsRepository @Inject constructor(private val api: RequesterTrendsApi) : ITrendsProtocol {
    override fun get(): Single<List<Trend>> {
        return api.get().map { it.body() }
    }
}