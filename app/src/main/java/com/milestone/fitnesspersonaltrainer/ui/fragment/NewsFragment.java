package com.milestone.fitnesspersonaltrainer.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.adapter.NewsAdapter;
import com.milestone.fitnesspersonaltrainer.base.BaseFragment;
import com.milestone.fitnesspersonaltrainer.constants.ConstantCode;
import com.milestone.fitnesspersonaltrainer.databinding.FragmentNewsBinding;
import com.milestone.fitnesspersonaltrainer.utils.GlideImageLoader;
import com.milestone.fitnesspersonaltrainer.vewmodel.NewsViewModel;
import com.milestone.fitnesspersonaltrainer.widget.SHeardView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class NewsFragment extends BaseFragment <FragmentNewsBinding, NewsViewModel> {

    private NewsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected NewsViewModel createFragmentViewModel() {
        return new NewsViewModel(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPara();
        setListener();
    }

    private void initPara() {

        List <String> imgs = new ArrayList <>();
        imgs.add(ConstantCode.TEST_IMG_URL);

        binding.banner.setDelayTime(3000)
                .setImages(imgs)
                .setImageLoader(new GlideImageLoader())
                .start();

        adapter = new NewsAdapter(getContext());
        binding.newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.newsRecycler.setAdapter(adapter);

        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");
        adapter.getItems().add("1");

        binding.swipRefresh.setEnableLoadMore(true);
        binding.swipRefresh.setRefreshHeader(new SHeardView(getContext()));

        binding.swipRefresh.autoRefresh();
    }

    private void setListener() {
        binding.swipRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                binding.swipRefresh.finishRefresh();
            }
        });

        binding.swipRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                binding.swipRefresh.finishLoadMore();
            }
        });
    }

}
