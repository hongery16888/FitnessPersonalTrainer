package com.milestone.fitnesspersonaltrainer.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.adapter.DietListAdapter;
import com.milestone.fitnesspersonaltrainer.base.BaseActivity;
import com.milestone.fitnesspersonaltrainer.databinding.ActivityDietListBinding;
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener;
import com.milestone.fitnesspersonaltrainer.listener.OnRecyclerViewItemClickListener;
import com.milestone.fitnesspersonaltrainer.vewmodel.DietListViewModel;

import androidx.recyclerview.widget.GridLayoutManager;

public class DietListActivity extends BaseActivity <ActivityDietListBinding, DietListViewModel> {

    private DietListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_diet_list;
    }

    @Override
    protected DietListViewModel createViewModel() {
        return new DietListViewModel(this);
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
        adapter = new DietListAdapter(this);
        binding.dietRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        binding.dietRecycler.setAdapter(adapter);

        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
    }

    private void setListener() {
        adapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(DietListActivity.this, DetailsActivity.class));
            }
        });
    }
}
