package com.milestone.fitnesspersonaltrainer.vewmodel

import com.milestone.fitnesspersonaltrainer.base.BaseFragment
import com.milestone.fitnesspersonaltrainer.base.FragmentViewModel
import com.milestone.fitnesspersonaltrainer.listener.OnHomeCourseListener

class CourseViewModel(fragment: BaseFragment<*, *>?) : FragmentViewModel(fragment) {

    var onHomeCourseListener: OnHomeCourseListener? = null


}