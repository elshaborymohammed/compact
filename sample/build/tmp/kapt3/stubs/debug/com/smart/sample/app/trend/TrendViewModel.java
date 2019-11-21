package com.smart.sample.app.trend;

import com.compact.app.viewmodel.CompactDataViewModel;
import com.compact.executor.RxCompactSchedulers;
import com.smart.compact.response.Resource;
import com.smart.sample.domain.model.Trend;
import com.smart.sample.domain.usecase.TrendsUseCase;
import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\rJ\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000f0\rJ\u0016\u0010\u0010\u001a\u0002H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u0001H\u0082\b\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/smart/sample/app/trend/TrendViewModel;", "Lcom/compact/app/viewmodel/CompactDataViewModel;", "", "Lcom/smart/sample/domain/model/Trend;", "useCase", "Lcom/smart/sample/domain/usecase/TrendsUseCase;", "scheduler", "Lcom/compact/executor/RxCompactSchedulers;", "(Lcom/smart/sample/domain/usecase/TrendsUseCase;Lcom/compact/executor/RxCompactSchedulers;)V", "call", "", "completable", "trends", "Lio/reactivex/Single;", "trendsResource", "Lcom/smart/compact/response/Resource;", "withSchedulers", "T", "()Ljava/lang/Object;", "sample_debug"})
@javax.inject.Singleton()
public final class TrendViewModel extends com.compact.app.viewmodel.CompactDataViewModel<java.util.List<? extends com.smart.sample.domain.model.Trend>> {
    private final com.smart.sample.domain.usecase.TrendsUseCase useCase = null;
    private final com.compact.executor.RxCompactSchedulers scheduler = null;
    
    @java.lang.Override()
    protected void call() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.smart.sample.domain.model.Trend>> trends() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.smart.compact.response.Resource<java.util.List<com.smart.sample.domain.model.Trend>>> trendsResource() {
        return null;
    }
    
    public final void completable() {
    }
    
    private final <T extends java.lang.Object>T withSchedulers() {
        return null;
    }
    
    @javax.inject.Inject()
    public TrendViewModel(@org.jetbrains.annotations.NotNull()
    com.smart.sample.domain.usecase.TrendsUseCase useCase, @org.jetbrains.annotations.NotNull()
    com.compact.executor.RxCompactSchedulers scheduler) {
        super();
    }
}