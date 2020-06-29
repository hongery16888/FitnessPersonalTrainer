package com.milestone.fitnesspersonaltrainer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.milestone.fitnesspersonaltrainer.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;


/**
 * Created by ThinkPad on 2017/11/9.
 */

public class SHeardView extends LinearLayout implements RefreshHeader {

    private TextView textView;
    private Context context;

    public SHeardView(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.loading_header_view, this);

        textView = findViewById(R.id.text);
    }

    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {
        textView.setScaleX(percent);
        textView.setScaleY(percent);
    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
        textView.setScaleX(percent);
        textView.setScaleY(percent);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                textView.setText(context.getString(R.string.pull_to_refresh_pull_label));
                break;
            case Refreshing:
                textView.setText(context.getString(R.string.pull_to_refresh_refreshing_label));
                break;
            case ReleaseToRefresh:
                textView.setText(context.getString(R.string.pull_to_refresh_release_label));
                break;
        }
    }
}
