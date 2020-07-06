package com.milestone.fitnesspersonaltrainer.ui.activity

import android.os.Bundle
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.base.BaseActivity
import com.milestone.fitnesspersonaltrainer.base.BaseFragment
import com.milestone.fitnesspersonaltrainer.base.BaseFragmentAdapter
import com.milestone.fitnesspersonaltrainer.databinding.ActivityMainBinding
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener
import com.milestone.fitnesspersonaltrainer.ui.fragment.*
import com.milestone.fitnesspersonaltrainer.vewmodel.MainViewModel
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding?, MainViewModel?>(), OnBaseNetworkListener {
    private val list: MutableList<BaseFragment<*, *>> = ArrayList()
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createViewModel(): MainViewModel {
        return MainViewModel(this)
    }

    override fun getNetworkListener(): OnBaseNetworkListener {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPara()
    }

    private fun initPara() {
        list.add(VFragment())
        list.add(AdviceFragment())
        list.add(CourseFragment())
        list.add(DietFragment())
        binding!!.viewPager.offscreenPageLimit = 4
        binding!!.viewPager.setScanScroll(false)
        binding!!.viewPager.adapter = BaseFragmentAdapter(supportFragmentManager, list)
        binding!!.bottomBar.setupWithNavController(binding!!.viewPager)
    }

    override fun onFailure(errorMsg: String?) {

    }

    override fun onSuccess(any: Any) {

    }
}