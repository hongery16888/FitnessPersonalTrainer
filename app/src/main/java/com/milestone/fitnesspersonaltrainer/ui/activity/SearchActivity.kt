package com.milestone.fitnesspersonaltrainer.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.adapter.VCommonAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VSearchAdapter
import com.milestone.fitnesspersonaltrainer.base.BaseActivity
import com.milestone.fitnesspersonaltrainer.databinding.ActivitySearchBinding
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener
import com.milestone.fitnesspersonaltrainer.vewmodel.SearchViewModel

class SearchActivity : BaseActivity<ActivitySearchBinding?, SearchViewModel?>() {

    private var manager: VirtualLayoutManager? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_search
    }

    override fun createViewModel(): SearchViewModel {
        return SearchViewModel(this)
    }

    override fun getNetworkListener(): OnBaseNetworkListener? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPara()
        setListener()
    }

    private fun initPara() {
        setSupportActionBar(binding!!.mainToolbarTb)

        manager = VirtualLayoutManager(this)
        val pool = RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(0, 20);
        binding?.vlayoutRv?.setRecycledViewPool(pool);
        manager?.setRecycleOffset(300)
//        manager?.reverseLayout = true
        binding?.vlayoutRv?.layoutManager = manager

        val delegateAdapter = DelegateAdapter(manager, true)

        delegateAdapter.addAdapter(VSearchAdapter(this, LinearLayoutHelper()))

        binding?.vlayoutRv?.adapter = delegateAdapter
    }

    private fun setListener() {}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val item = menu.findItem(R.id.action_search)
        item.setOnMenuItemClickListener {
            binding!!.mainSearchViewRsv.showSearch()
            false
        }
        return true
    }
}