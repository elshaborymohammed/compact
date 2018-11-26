package com.smart.compact;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;

public class CompactRecyclerView {

    public static abstract class Adapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        private List<T> data;
        private Context context;

        public Adapter() {
        }

        public Adapter(List<T> data) {
            this.data = data;
        }

        public Context getContext() {
            return context;
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            this.context = recyclerView.getContext();
            recyclerView.setLayoutManager(getLayoutManager());
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), getDividerItemDecorationOrientation()));
            recyclerView.addItemDecoration(new SpacesItemDecoration(8));
            super.onAttachedToRecyclerView(recyclerView);
        }

        @Override
        public void onBindViewHolder(@NonNull VH vh, int i) {
            if (vh instanceof ViewHolder) {
                ((ViewHolder<T>) vh).bind(get(i));
            }
        }

        @Override
        public int getItemCount() {
            return null == data ? 0 : data.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        protected RecyclerView.LayoutManager getLayoutManager() {
            return new LinearLayoutManager(context);
        }

        protected int getDividerItemDecorationOrientation() {
            return DividerItemDecoration.VERTICAL;
        }

        protected T get(int position) {
            return data.get(position);
        }

        public List<T> getData() {
            return data;
        }

        public void swap(List<T> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        public void addAll(List<T> data) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

        public void add(T t) {
            this.data.add(t);
            notifyItemInserted(data.size() - 1);
        }
    }


    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected abstract void bind(T object);
    }

    private static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }

    public static abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
            int totalItemCount = layoutManager.getItemCount();
            int lastVisible = layoutManager.findLastCompletelyVisibleItemPosition();
            boolean endHasBeenReached = lastVisible >= totalItemCount && totalItemCount > 0;

            if (endHasBeenReached) {
                nextPage();
            }
        }

        protected abstract void nextPage();
    }
}