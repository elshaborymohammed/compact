package com.smart.sample.app.trend;

import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.compact.app.CompactActivity;
import com.smart.sample.R;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/smart/sample/app/trend/TrendActivity;", "Lcom/compact/app/CompactActivity;", "()V", "adapter", "Lcom/smart/sample/app/trend/TrendAdapter;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewModel", "Lcom/smart/sample/app/trend/TrendViewModel;", "layoutRes", "", "onCreate", "", "subscriptions", "", "Lio/reactivex/disposables/Disposable;", "()[Lio/reactivex/disposables/Disposable;", "sample_debug"})
public final class TrendActivity extends com.compact.app.CompactActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public androidx.lifecycle.ViewModelProvider.Factory factory;
    private com.smart.sample.app.trend.TrendViewModel viewModel;
    private com.smart.sample.app.trend.TrendAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.ViewModelProvider.Factory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.ViewModelProvider.Factory p0) {
    }
    
    @java.lang.Override()
    protected int layoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected io.reactivex.disposables.Disposable[] subscriptions() {
        return null;
    }
    
    public TrendActivity() {
        super();
    }
}