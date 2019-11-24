package com.compact.widget;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public abstract class LinearSpacesItemDecorationBuilder extends SpacesItemDecorationBuilder {

    @RecyclerView.Orientation
    private int orientation = RecyclerView.VERTICAL;

    public LinearSpacesItemDecorationBuilder(Context context) {
        super(context);
    }

    public LinearSpacesItemDecorationBuilder orientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public int getOrientation() {
        return orientation;
    }
}
