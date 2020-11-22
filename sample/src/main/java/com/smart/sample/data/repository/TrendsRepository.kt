package com.smart.sample.data.repository

import com.compact.response.Resource
import com.smart.sample.data.api.RequesterTrendsApi
import com.smart.sample.domain.model.Trend
import com.smart.sample.domain.protocol.ITrendsProtocol
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

class TrendsRepository @Inject constructor(private val api: RequesterTrendsApi) : ITrendsProtocol {
    override fun completable(): Completable {
        return api.completable()
    }

    override fun get(): Single<List<Trend>> {
        return api.get()
    }

    override fun resource(): Single<Resource<List<Trend>>> {
        return api.resource()
    }
}