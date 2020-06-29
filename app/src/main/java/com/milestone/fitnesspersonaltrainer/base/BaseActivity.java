package com.milestone.fitnesspersonaltrainer.base;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.milestone.fitnesspersonaltrainer.FitnessApplication;
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by yuzhe on 2017/4/7.
 */

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends RxAppCompatActivity {

    protected B binding;
    protected VM viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        loadParas();
        viewModel = viewModel == null ? createViewModel() : viewModel;
        if(viewModel!=null) {
            viewModel.create();
            if (getNetworkListener() != null){
                viewModel.setOnNetworkListener(getNetworkListener());
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(viewModel!=null) {
            viewModel.onDestroy();
        }
    }

    protected abstract int getLayoutId();

    protected abstract VM createViewModel();

    protected abstract OnBaseNetworkListener getNetworkListener();

    protected void loadParas()
    {

    }

    protected FitnessApplication getApp(){
        return (FitnessApplication)getApplication();
    }

}
