package com.milestone.fitnesspersonaltrainer.adapter;

import android.content.Context;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseBindingAdapter;
import com.milestone.fitnesspersonaltrainer.databinding.NewsItemBinding;

public class NewsAdapter extends BaseBindingAdapter <String, NewsItemBinding> {

    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.news_item;
    }

    @Override
    protected void onBindItem(NewsItemBinding binding, String item, int position) {

    }
}
