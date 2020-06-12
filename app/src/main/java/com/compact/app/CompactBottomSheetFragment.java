package com.compact.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

import dagger.android.support.AndroidSupportInjection;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class CompactBottomSheetFragment extends BottomSheetDialogFragment {

    private final CompositeDisposable disposables = new CompositeDisposable();
    protected BottomSheetBehavior<View> bottomSheetBehavior;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewBound(view);
        disposables.addAll(subscriptions());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View bottomSheet = ((View) Objects.requireNonNull(getView()).getParent());
        bottomSheet.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
        bottomSheet.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        bottomSheet.setBackgroundColor(Color.TRANSPARENT);

        setHasOptionsMenu(true);
        bottomSheetBehavior(Objects.requireNonNull(getView()));
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void onViewBound(View view);

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    protected void subscribe(Disposable d) {
        disposables.add(d);
    }

    protected void bottomSheetBehavior(View view) {
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO, true);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (BottomSheetBehavior.STATE_HIDDEN == newState) {
                    dismiss();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    protected void addBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        disposables.clear();
        super.onDestroyView();
    }
}
