package com.smart.sample.data.api

import com.compact.requester.annotation.Requester
import com.compact.response.Resource
import com.smart.sample.domain.model.Trend
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

@Requester
interface TrendsApi {
    //    @GET("repositories")
    @GET("https://badawar.getsandbox.com:443/trends/error")
    @Headers("Content-Type: application/json")
    fun get(): Single<List<Trend>>

    @GET("repositories")
    fun resource(): Single<Resource<List<Trend>>>

    @GET("repositories")
    fun completable(): Completable
}