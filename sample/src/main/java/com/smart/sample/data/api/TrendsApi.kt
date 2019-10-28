package com.smart.sample.data.api

import com.compact.requester.annotation.Requester
import com.smart.sample.domain.model.Trend
import io.reactivex.Single
import retrofit2.http.GET

@Requester
interface TrendsApi {
    @GET("repositories")
    fun get(): Single<List<Trend>>
}