package com.milestone.fitnesspersonaltrainer.adapter;

import android.content.Context;
import android.view.View;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseBindingAdapter;
import com.milestone.fitnesspersonaltrainer.databinding.DietListItemBinding;

public class DietListAdapter extends BaseBindingAdapter <String, DietListItemBinding> {

    public DietListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.diet_list_item;
    }

    @Override
    protected void onBindItem(DietListItemBinding binding, String item, final int position) {
        binding.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnRecyclerViewItemClickListener().onItemClick(position);
            }
        });
    }
}
