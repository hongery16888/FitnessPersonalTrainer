package com.milestone.fitnesspersonaltrainer.view.navigation.lib

import android.view.Menu
import com.milestone.fitnesspersonaltrainer.view.navigation.VerticalViewpager

/**
 * Created by Mayokun Adeniyi on 24/04/2020.
 */
class NavigationComponentHelper {
    companion object {

        fun setupWithNavController(
                viewpager: VerticalViewpager,
                smoothBottomBar: SmoothBottomBar
        ) {
            smoothBottomBar.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelect(pos: Int): Boolean {
                    viewpager.currentItem = pos
                    return true
                }
            }

        }

    }
}