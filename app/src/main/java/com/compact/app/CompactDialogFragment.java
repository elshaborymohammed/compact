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
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class CompactDialogFragment extends DialogFragment {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private View inflate;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(layoutRes(), container, false);
        setHasOptionsMenu(true);
        onViewBound(inflate);
        disposable.addAll(subscriptions());
        return inflate;
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

    protected abstract void onViewBound(View view);

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    @Override
    public void onDestroyView() {
        disposable.dispose();
        disposable.clear();
        super.onDestroyView();
    }

    protected void subscribe(Disposable d) {
        disposable.add(d);
    }

    public View getInflate() {
        return inflate;
    }

    protected void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
