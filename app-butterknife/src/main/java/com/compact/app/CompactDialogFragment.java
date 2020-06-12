package com.compact.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.compact.utils.ButterKnifeUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class CompactDialogFragment extends DialogFragment {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        setCancelable(cancelable());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        onViewBound(view);
        disposable.addAll(subscriptions());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected boolean cancelable() {
        return false;
    }

    protected abstract void onViewBound(View view);

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    protected void subscribe(Disposable d) {
        disposable.add(d);
    }

    @Override
    public void onDestroyView() {
        disposable.clear();
        ButterKnifeUtils.unbind(unbinder);
        super.onDestroyView();
    }
}