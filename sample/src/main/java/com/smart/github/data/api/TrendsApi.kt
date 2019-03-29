package com.smart.github.data.api

import com.compact.requester.annotation.Requester
import com.smart.github.domain.model.Trend
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

@Requester
interface TrendsApi {
    @GET("repositories")
    fun get(): Single<Response<List<Trend>>>
}