package com.milestone.fitnesspersonaltrainer.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.adapter.VAdviceAdapter
import com.milestone.fitnesspersonaltrainer.adapter.VCommonAdapter
import com.milestone.fitnesspersonaltrainer.base.BaseFragment
import com.milestone.fitnesspersonaltrainer.databinding.FragmentAdviceBinding
import com.milestone.fitnesspersonaltrainer.databinding.FragmentCourseBinding
import com.milestone.fitnesspersonaltrainer.listener.OnHomeCourseListener
import com.milestone.fitnesspersonaltrainer.model.Course
import com.milestone.fitnesspersonaltrainer.vewmodel.CourseViewModel
import java.util.*

class AdviceFragment : BaseFragment<FragmentAdviceBinding?, CourseViewModel?>(), OnHomeCourseListener {

    private var manager: VirtualLayoutManager? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_advice
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
//        manager?.reverseLayout = true
        binding?.vlayoutRv?.layoutManager = manager

        val delegateAdapter = DelegateAdapter(manager, true)

        delegateAdapter.addAdapter(VAdviceAdapter(context!!, LinearLayoutHelper()))

        binding?.vlayoutRv?.adapter = delegateAdapter
    }

    override fun onSuccess(course: ArrayList<Course>) {}

    override fun onError(error: String) {}
}