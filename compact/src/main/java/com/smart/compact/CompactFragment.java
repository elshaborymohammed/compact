package com.smart.compact;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.compact.util.ButterKnifeUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by lshabory on 3/8/18.
 */

public abstract class CompactFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutRes(), container, false);
        setHasOptionsMenu(true);
        unbinder = ButterKnife.bind(this, inflate);
        onViewBound(inflate);
        return inflate;
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void onViewBound(View view);

    @Override
    public void onDestroyView() {
        ButterKnifeUtils.unbind(unbinder);
        super.onDestroyView();
    }
}