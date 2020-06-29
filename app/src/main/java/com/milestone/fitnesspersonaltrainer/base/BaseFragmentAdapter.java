package com.milestone.fitnesspersonaltrainer.base;

import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by ThinkPad on 2018/2/26.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    private List <BaseFragment> list;

    public BaseFragmentAdapter(FragmentManager fm, List <BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public BaseFragment getItem(int position) {
        return list.get(position);
    }


    @Override
    public int getCount() {
        return list.size();
    }
}
