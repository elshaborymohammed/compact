package com.compact.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CompactRecyclerView {

    public static abstract class Adapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        private RecyclerView recyclerView;
        private List<T> data = new ArrayList<>();
        private Context context;

        public Adapter() {
        }

        public Adapter(List<T> data) {
            this.data = data;
        }

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }

        public Context getContext() {
            return context;
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            this.context = recyclerView.getContext();
            recyclerView.setLayoutManager(layoutManager());
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            if (null != itemDecorations())
                for (RecyclerView.ItemDecoration itemDecoration : itemDecorations()) {
                    recyclerView.addItemDecoration(itemDecoration);
                }
            super.onAttachedToRecyclerView(recyclerView);
            this.recyclerView = recyclerView;
        }

        @Override
        public void onBindViewHolder(@NonNull VH vh, int i) {
            if (vh instanceof ViewHolder) {
                ViewHolder<T> viewHolder = (ViewHolder<T>) vh;
                viewHolder.bind(i, get(i));
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

        protected RecyclerView.LayoutManager layoutManager() {
            return new LinearLayoutManager(context);
        }

        protected RecyclerView.ItemDecoration[] itemDecorations() {
            return new RecyclerView.ItemDecoration[]{
                    new SpacesItemDecoration.Linear(context, 8)
            };
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
        }

        protected abstract void bind(int position, T object);
    }

    public static class SpacesItemDecoration {
        public static class Linear extends RecyclerView.ItemDecoration {
            private int top;
            private int left;
            private int right;
            private int bottom;

            public Linear(Context context, int space) {
                this.top = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, space, context.getResources().getDisplayMetrics());
                this.left = top;
                this.right = top;
                this.bottom = 0;
            }

            public Linear(Context context, int top, int left, int right, int bottom) {
                this.top = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, context.getResources().getDisplayMetrics());
                this.left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, context.getResources().getDisplayMetrics());
                this.right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, context.getResources().getDisplayMetrics());
                this.bottom = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, context.getResources().getDisplayMetrics());
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                // Add top margin only for the first item to avoid double space between items
                if (parent.getChildLayoutPosition(view) == 0) {
                    outRect.top = top * 2;
                    outRect.left = left;
                    outRect.right = right;
                } else if (parent.getChildLayoutPosition(view) == parent.getLayoutManager().getChildCount() - 1) {
                    outRect.top = top;
                    outRect.left = left;
                    outRect.right = right;
                    outRect.bottom = (bottom == 0) ? top : bottom;
                } else {
                    outRect.top = top;
                    outRect.left = left;
                    outRect.right = right;
                }
            }
        }

        public static class Grid extends RecyclerView.ItemDecoration {
            private int space;

            public Grid(int space) {
                this.space = space;
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = space;
                outRect.right = space;
                outRect.bottom = space;

                // Add top margin only for the first item to avoid double space between items
                if (parent.getChildLayoutPosition(view) == 0) {
                    outRect.top = 0;
                } else {
                    outRect.top = 0;
                }
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