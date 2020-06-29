package com.milestone.fitnesspersonaltrainer.ui.activity;

import android.os.Bundle;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseActivity;
import com.milestone.fitnesspersonaltrainer.base.GlideApp;
import com.milestone.fitnesspersonaltrainer.databinding.ActivityDetailsBinding;
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener;
import com.milestone.fitnesspersonaltrainer.vewmodel.DetailsViewModel;

public class DetailsActivity extends BaseActivity <ActivityDetailsBinding, DetailsViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected DetailsViewModel createViewModel() {
        return new DetailsViewModel(this);
    }

    @Override
    protected OnBaseNetworkListener getNetworkListener() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPara();
        setListener();
    }

    private void initPara() {
        GlideApp.with(this).load(R.mipmap.diet_banner).into(binding.img);
    }

    private void setListener() {

    }
}
