package com.compact.widget.recyclerview;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

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
            recyclerView.setItemAnimator(itemAnimator());
            if (null != itemDecorations())
                for (RecyclerView.ItemDecoration itemDecoration : itemDecorations()) {
                    recyclerView.addItemDecoration(itemDecoration);
                }
            super.onAttachedToRecyclerView(recyclerView);
            this.recyclerView = recyclerView;
        }

        protected RecyclerView.ItemAnimator itemAnimator() {
            return new DefaultItemAnimator();
        }

        protected RecyclerView.LayoutManager layoutManager() {
            return new LinearLayoutManager(context);
        }

        protected RecyclerView.ItemDecoration[] itemDecorations() {
            return new RecyclerView.ItemDecoration[]{
                    SpaceDecoration.builder(context).space(8).build()
            };
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

        public void add(T t) {
            this.data.add(t);
            notifyItemInserted(data.size() - 1);
        }

        public void addAll(List<T> data) {
            this.data.addAll(data);
            notifyItemRangeInserted(this.data.size() - data.size(), data.size());
        }

        public void replace(int position, T data) {
            this.data.set(position, data);
            notifyItemChanged(position);
        }

        public void remove(int position) {
            this.data.remove(position);
            notifyItemRemoved(position);
        }

        public void clear() {
            this.data.clear();
            notifyDataSetChanged();
        }
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected abstract void bind(int position, T object);
    }

    public static abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

        @Override
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
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