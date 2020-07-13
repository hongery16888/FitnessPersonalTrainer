package com.milestone.fitnesspersonaltrainer.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.adapter.VAdviceAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VDetailAdapter
import com.milestone.fitnesspersonaltrainer.base.BaseActivity
import com.milestone.fitnesspersonaltrainer.databinding.ActivityDetailsBinding
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener
import com.milestone.fitnesspersonaltrainer.vewmodel.DetailsViewModel

class DetailsActivity : BaseActivity<ActivityDetailsBinding?, DetailsViewModel?>() {

    private var manager: VirtualLayoutManager? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_details
    }

    override fun createViewModel(): DetailsViewModel {
        return DetailsViewModel(this)
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
//        GlideApp.with(this).load(R.mipmap.diet_banner).into(binding.img);
        manager = VirtualLayoutManager(this)
        val pool = RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(0, 20);
        binding?.vlayoutRv?.setRecycledViewPool(pool);
        manager?.setRecycleOffset(300)
//        manager?.reverseLayout = true
        binding?.vlayoutRv?.layoutManager = manager

        val delegateAdapter = DelegateAdapter(manager, true)

        delegateAdapter.addAdapter(VDetailAdapter(this, LinearLayoutHelper()))

        binding?.vlayoutRv?.adapter = delegateAdapter
    }

    private fun setListener() {}
}