package com.smart.sample.data.api;

import com.compact.requester.annotation.Requester;
import com.smart.compact.response.Resource;
import com.smart.sample.domain.model.Trend;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.GET;

@com.compact.requester.annotation.Requester()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t0\u0005H\'\u00a8\u0006\n"}, d2 = {"Lcom/smart/sample/data/api/TrendsApi;", "", "completable", "Lio/reactivex/Completable;", "get", "Lio/reactivex/Single;", "", "Lcom/smart/sample/domain/model/Trend;", "resource", "Lcom/smart/compact/response/Resource;", "sample_debug"})
public abstract interface TrendsApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "repositories")
    public abstract io.reactivex.Single<java.util.List<com.smart.sample.domain.model.Trend>> get();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "repositories")
    public abstract io.reactivex.Single<com.smart.compact.response.Resource<java.util.List<com.smart.sample.domain.model.Trend>>> resource();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "repositories")
    public abstract io.reactivex.Completable completable();
}