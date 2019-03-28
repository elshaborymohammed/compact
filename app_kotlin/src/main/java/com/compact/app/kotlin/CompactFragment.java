package com.compact.app.kotlin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactFragment extends Fragment {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private View inflate;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
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
}