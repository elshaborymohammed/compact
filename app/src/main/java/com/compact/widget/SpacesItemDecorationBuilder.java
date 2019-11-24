package com.compact.widget;

import android.content.Context;
import android.util.TypedValue;

import androidx.recyclerview.widget.RecyclerView;

public abstract class SpacesItemDecorationBuilder {

    private final Context context;
    private int first;
    private int top;
    private int left;
    private int right;
    private int bottom;

    public SpacesItemDecorationBuilder(Context context) {
        this.context = context;
        first(1).space(8);
    }

    public SpacesItemDecorationBuilder space(int space) {
        return top(space).left(space).right(space).bottom(0);
    }

    public SpacesItemDecorationBuilder first(int factor) {
        this.first = factor;
        return this;
    }

    public SpacesItemDecorationBuilder top(int space) {
        this.top = toDIP(context, space);
        return this;
    }

    public SpacesItemDecorationBuilder left(int space) {
        this.left = toDIP(context, space);
        return this;
    }

    public SpacesItemDecorationBuilder right(int space) {
        this.right = toDIP(context, space);
        return this;
    }

    public SpacesItemDecorationBuilder bottom(int space) {
        this.bottom = toDIP(context, space);
        return this;
    }

    protected int toDIP(Context context, int pixel) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixel, context.getResources().getDisplayMetrics());
    }

    public int getFirst() {
        return (first < 1) ? 1 : first;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public abstract RecyclerView.ItemDecoration build();
}
