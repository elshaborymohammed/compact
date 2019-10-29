package com.smart.sample.app.trend;

import com.compact.app.viewmodel.CompactViewModel;
import com.compact.executor.MainThread;
import com.compact.executor.WorkerThread;
import com.smart.sample.domain.model.Trend;
import com.smart.sample.domain.usecase.TrendsUseCase;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/smart/sample/app/trend/TrendViewModel;", "Lcom/compact/app/viewmodel/CompactViewModel;", "", "Lcom/smart/sample/domain/model/Trend;", "useCase", "Lcom/smart/sample/domain/usecase/TrendsUseCase;", "subscribeOn", "Lcom/compact/executor/WorkerThread;", "observeOn", "Lcom/compact/executor/MainThread;", "(Lcom/smart/sample/domain/usecase/TrendsUseCase;Lcom/compact/executor/WorkerThread;Lcom/compact/executor/MainThread;)V", "call", "", "completable", "sample_debug"})
@javax.inject.Singleton()
public final class TrendViewModel extends com.compact.app.viewmodel.CompactViewModel<java.util.List<? extends com.smart.sample.domain.model.Trend>> {
    private final com.smart.sample.domain.usecase.TrendsUseCase useCase = null;
    private final com.compact.executor.WorkerThread subscribeOn = null;
    private final com.compact.executor.MainThread observeOn = null;
    
    @java.lang.Override()
    protected void call() {
    }
    
    public final void completable() {
    }
    
    @javax.inject.Inject()
    public TrendViewModel(@org.jetbrains.annotations.NotNull()
    com.smart.sample.domain.usecase.TrendsUseCase useCase, @org.jetbrains.annotations.NotNull()
    com.compact.executor.WorkerThread subscribeOn, @org.jetbrains.annotations.NotNull()
    com.compact.executor.MainThread observeOn) {
        super();
    }
}