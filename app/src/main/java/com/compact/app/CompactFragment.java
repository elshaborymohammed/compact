package com.compact.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dagger.android.support.AndroidSupportInjection;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactFragment extends Fragment {

    private final CompositeDisposable disposables = new CompositeDisposable();

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
        postponeEnterTransition();
        onViewBound(view);
        disposables.addAll(subscriptions());
        view.getViewTreeObserver().addOnPreDrawListener(() -> {
            startPostponedEnterTransition();
            return true;
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
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

    @Override
    public void onDestroyView() {
        disposables.clear();
        super.onDestroyView();
    }
}