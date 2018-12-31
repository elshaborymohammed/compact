package com.compact;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compact.util.ButterKnifeUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactFragment extends Fragment {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private Unbinder unbinder;
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
        unbinder = ButterKnife.bind(this, inflate);
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
        ButterKnifeUtils.unbind(unbinder);
        super.onDestroyView();
    }

    protected void subscribe(Disposable d) {
        disposable.add(d);
    }

    public View getInflate() {
        return inflate;
    }
}