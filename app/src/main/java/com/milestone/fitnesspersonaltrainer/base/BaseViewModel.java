package com.milestone.fitnesspersonaltrainer.base;

import android.util.Log;

import androidx.databinding.BaseObservable;

/**
 * Created by yuzhe on 2017/4/8.
 */

public abstract class BaseViewModel<OnBaseNetworkListener> extends BaseObservable {

    protected OnBaseNetworkListener onNetworkListener;

    public void create()
    {

    }

    public void onDestroy()
    {

    }

    public void setOnNetworkListener(OnBaseNetworkListener onNetworkListener) {
        this.onNetworkListener = onNetworkListener;
    }

    protected void logv(String str)
    {
        String tag=getClass().getSimpleName();
        Log.v(tag,str);
    }

    protected void loge(String str)
    {
        String tag=getClass().getSimpleName();
        Log.e(tag,str);
    }

    protected void logi(String str)
    {
        String tag=getClass().getSimpleName();
        Log.i(tag,str);
    }

    protected void logd(String str)
    {
        String tag=getClass().getSimpleName();
        Log.d(tag,str);
    }

}
