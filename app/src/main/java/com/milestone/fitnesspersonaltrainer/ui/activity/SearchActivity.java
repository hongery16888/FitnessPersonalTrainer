package com.milestone.fitnesspersonaltrainer.ui.activity;

import android.os.Bundle;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseActivity;
import com.milestone.fitnesspersonaltrainer.base.GlideApp;
import com.milestone.fitnesspersonaltrainer.databinding.ActivityDetailsBinding;
import com.milestone.fitnesspersonaltrainer.databinding.ActivitySearchBinding;
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener;
import com.milestone.fitnesspersonaltrainer.vewmodel.DetailsViewModel;
import com.milestone.fitnesspersonaltrainer.vewmodel.SearchViewModel;

public class SearchActivity extends BaseActivity <ActivitySearchBinding, SearchViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected SearchViewModel createViewModel() {
        return new SearchViewModel(this);
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
    }

    private void setListener() {

    }
}
