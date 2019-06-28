package com.smart.sample.data.module

import com.smart.sample.data.api.RequesterTrendsApi
import com.smart.sample.data.repository.TrendsRepository
import com.smart.sample.domain.protocol.ITrendsProtocol
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProtocolModule {

    @Provides
    @Singleton
    fun providesTrendsProtocol(api: RequesterTrendsApi): ITrendsProtocol {
        return TrendsRepository(api)
    }
}