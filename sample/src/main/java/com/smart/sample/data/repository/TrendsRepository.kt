package com.smart.sample.data.repository

import com.smart.sample.data.api.RequesterTrendsApi
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.protocol.ITrendsProtocol
import io.reactivex.Single

class TrendsRepository constructor(private val api: RequesterTrendsApi) : ITrendsProtocol {
    override fun get(): Single<List<Trend>> {
        return api.get()
    }

}