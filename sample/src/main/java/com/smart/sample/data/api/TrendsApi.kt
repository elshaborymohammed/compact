package com.smart.sample.data.api

import com.compact.requester.annotation.Requester
import com.compact.response.Resource
import com.smart.sample.domain.model.Trend
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET

@Requester
interface TrendsApi {
    @GET("repositories")
    fun get(): Single<List<Trend>>

    @GET("repositories")
    fun resource(): Single<Resource<List<Trend>>>

    @GET("repositories")
    fun completable(): Completable
}