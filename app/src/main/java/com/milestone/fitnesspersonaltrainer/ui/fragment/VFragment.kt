package com.milestone.fitnesspersonaltrainer.ui.fragment

import android.os.Bundle
import android.view.View
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.adapter.VDemandAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VHeaderAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VTrendingAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VUpcomingAdapter
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
        binding?.vlayoutRv?.layoutManager = manager
        val delegateAdapter = DelegateAdapter(manager, true)
        binding?.vlayoutRv?.adapter = delegateAdapter

        delegateAdapter.addAdapter(VHeaderAdapter(context!!, LinearLayoutHelper()))
        delegateAdapter.addAdapter(VTrendingAdapter(context!!, LinearLayoutHelper()))
        delegateAdapter.addAdapter(VUpcomingAdapter(context!!, LinearLayoutHelper()))
        delegateAdapter.addAdapter(VDemandAdapter(context!!, LinearLayoutHelper()))
    }

}