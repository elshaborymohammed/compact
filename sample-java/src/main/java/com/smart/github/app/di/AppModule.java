package com.smart.github.app.di;

import com.compact.di.module.GsonModule;
import com.compact.di.module.RequestModule;
import com.compact.di.qualifier.DatePattern;
import com.compact.di.qualifier.Endpoint;
import com.compact.requester.adapter.CompactCallAdapter;
import com.google.gson.Gson;
import com.smart.github.data.repository.TrendsRepository;
import com.smart.github.domain.protocol.ITrendsProtocol;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module(includes = {GsonModule.class, RequestModule.class})
public class AppModule {

    @Provides
    @Singleton
    @DatePattern
    String providesDatePattern() {
        return GsonModule.providesDatePattern();
    }

    @Provides
    @Singleton
    @Endpoint
    String providesEndpoint() {
        return "https://api.github.com/";
    }

    @Provides
    @IntoSet
    Converter.Factory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @IntoSet
    CallAdapter.Factory providesCompactCallAdapterFactory() {
        return CompactCallAdapter.Factory.create();
    }

    @Provides
    @Singleton
    ITrendsProtocol providesTrendsProtocol(TrendsRepository trendsProtocol) {
        return trendsProtocol;
    }
}
