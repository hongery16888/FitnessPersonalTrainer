package com.milestone.fitnesspersonaltrainer.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.milestone.fitnesspersonaltrainer.FitnessApplication;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.reactivex.disposables.Disposable;

public abstract class BaseFragment<B extends ViewDataBinding, VM extends BaseViewModel> extends RxFragment {

    protected B binding;
    protected VM viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        binding = DataBindingUtil.bind(view);
        viewModel = viewModel == null ? createFragmentViewModel() : viewModel;

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(viewModel!=null)
            viewModel.create();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(viewModel!=null)
        {
            viewModel.onDestroy();
            viewModel=null;
        }
    }

    protected abstract int getLayoutId();

    protected abstract VM createFragmentViewModel();

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint()){
            onVisibilityChangedToUser(true, false);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getUserVisibleHint()){
            onVisibilityChangedToUser(false, false);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isResumed()){
            onVisibilityChangedToUser(isVisibleToUser, true);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(getUserVisibleHint()) {
            onVisibilityChangedToUser(!hidden, false);
        }
    }

    protected void onVisibilityChangedToUser(boolean isVisibleToUser, boolean isHappenedInSetUserVisibleHintMethod){
        if(isVisibleToUser){
            onShow();
        }else{
            onHidden();
        }
    }

    protected FitnessApplication getApp(){
        return (FitnessApplication) Objects.requireNonNull(getActivity()).getApplication();
    }

    protected void onShow()
    {

    }

    protected void onHidden()
    {

    }

}