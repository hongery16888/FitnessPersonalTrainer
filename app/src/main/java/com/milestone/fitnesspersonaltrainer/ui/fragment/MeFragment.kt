package com.milestone.fitnesspersonaltrainer.ui.fragment

import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.base.BaseFragment
import com.milestone.fitnesspersonaltrainer.databinding.FragmentCourseBinding
import com.milestone.fitnesspersonaltrainer.listener.OnHomeCourseListener
import com.milestone.fitnesspersonaltrainer.model.Course
import com.milestone.fitnesspersonaltrainer.vewmodel.CourseViewModel
import java.util.*

class MeFragment : BaseFragment<FragmentCourseBinding?, CourseViewModel?>(), OnHomeCourseListener {
    override fun getLayoutId(): Int {
        return R.layout.fragment_diet
    }

    override fun createFragmentViewModel(): CourseViewModel {
        return CourseViewModel(this)
    }

    override fun onSuccess(course: ArrayList<Course>) {}
    override fun onError(error: String) {}
}