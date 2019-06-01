package com.smart.github.data.api

import com.compact.requester.annotation.Requester
import com.smart.compact.response.ApiResponse
import com.smart.github.domain.model.Trend
import io.reactivex.Single
import retrofit2.http.GET

@Requester
interface TrendsApi {
    @GET("repositories")
    fun get(): Single<ApiResponse<List<Trend>>>
}