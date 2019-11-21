package com.smart.sample.app.trend;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.compact.widget.CompactRecyclerView;
import com.smart.sample.domain.model.Trend;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/smart/sample/app/trend/TrendAdapter;", "Lcom/compact/widget/CompactRecyclerView$Adapter;", "Lcom/smart/sample/domain/model/Trend;", "Lcom/smart/sample/app/trend/TrendAdapter$ViewHolder;", "()V", "itemDecorations", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()[Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "ViewHolder", "sample_debug"})
public final class TrendAdapter extends com.compact.widget.CompactRecyclerView.Adapter<com.smart.sample.domain.model.Trend, com.smart.sample.app.trend.TrendAdapter.ViewHolder> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.recyclerview.widget.RecyclerView.ItemDecoration[] itemDecorations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smart.sample.app.trend.TrendAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public TrendAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smart/sample/app/trend/TrendAdapter$ViewHolder;", "Lcom/compact/widget/CompactRecyclerView$ViewHolder;", "Lcom/smart/sample/domain/model/Trend;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "bind", "", "position", "", "obj", "sample_debug"})
    public static final class ViewHolder extends com.compact.widget.CompactRecyclerView.ViewHolder<com.smart.sample.domain.model.Trend> {
        private final android.widget.TextView name = null;
        
        @java.lang.Override()
        protected void bind(int position, @org.jetbrains.annotations.Nullable()
        com.smart.sample.domain.model.Trend obj) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}