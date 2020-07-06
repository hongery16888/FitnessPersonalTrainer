package com.milestone.fitnesspersonaltrainer.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.adapter.*
import com.milestone.fitnesspersonaltrainer.base.BaseFragment
import com.milestone.fitnesspersonaltrainer.databinding.FragmentVBinding
import com.milestone.fitnesspersonaltrainer.vewmodel.CourseViewModel


internal class VFragment : BaseFragment<FragmentVBinding?, CourseViewModel?>() {

    private var manager: VirtualLayoutManager? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_v
    }

    override fun createFragmentViewModel(): CourseViewModel {
        return CourseViewModel(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        manager = VirtualLayoutManager(context!!)
        val pool = RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(0, 20);
        binding?.vlayoutRv?.setRecycledViewPool(pool);
        manager?.setRecycleOffset(300)
        binding?.vlayoutRv?.layoutManager = manager

        val delegateAdapter = DelegateAdapter(manager, true)

        delegateAdapter.addAdapter(VCommonAdapter(context!!, LinearLayoutHelper()))

        binding?.vlayoutRv?.adapter = delegateAdapter
    }

}