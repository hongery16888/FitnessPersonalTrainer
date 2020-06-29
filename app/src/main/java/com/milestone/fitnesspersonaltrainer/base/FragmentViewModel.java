package com.milestone.fitnesspersonaltrainer.base;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleTransformer;

import androidx.annotation.NonNull;

/**
 * Created by zhaoyu on 2017/6/30.
 */

public abstract class FragmentViewModel extends BaseViewModel{

    private final BaseFragment fragment;

    public FragmentViewModel(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Deprecated
    public BaseFragment getFragment() {
        return fragment;
    }

    @NonNull
    public Context getContext() {
        if (fragment != null) {
            return fragment.getContext();
        }
        throw new IllegalStateException("No view attached");
    }

    @NonNull
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        if (fragment != null) {
            return fragment.bindToLifecycle();
        }
        throw new IllegalStateException("No view attached");
    }

}
