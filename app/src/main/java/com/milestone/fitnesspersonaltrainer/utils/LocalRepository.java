package com.milestone.fitnesspersonaltrainer.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.milestone.fitnesspersonaltrainer.constants.ConstantCode;


/**
 * Created by zhangchong on 2015/12/9.
 * for user info
 */
public enum LocalRepository {
    INSTANCE;
    public SharedPreferences sharedPreferences = null;

    public void initLocalRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(ConstantCode.USER_PREFRENCE, Application.MODE_PRIVATE);
    }

    public void put(String tag, String info) {
        sharedPreferences.edit().putString(tag, info).apply();
    }

    public String get(String tag) {
        return sharedPreferences.getString(tag, null);
    }


    public void putLongLastTime(String tag, long info) {
        sharedPreferences.edit().putLong("last_time_" + tag, info).apply();
    }

    public long getLongLastTime(String tag) {
        return sharedPreferences.getLong("last_time_" + tag, 0);
    }


    //  是否连续点击两次返回按钮
    public boolean isDoubleClick() {

        long lastClick = sharedPreferences.getLong("double_click", 0);
        long cur = System.currentTimeMillis();

        long span = cur - lastClick;
        if (span > 2000) {
            sharedPreferences.edit().putLong("double_click", cur).apply();
            return false;
        }
        return true;
    }

    //  是否第一次打开APP
    public boolean isFirstLaunch() {
        boolean flag = sharedPreferences.getBoolean("first_launch", false);
        if (flag == false) {
            sharedPreferences.edit().putBoolean("first_launch", true).apply();
        }
        return !flag;
    }




}
