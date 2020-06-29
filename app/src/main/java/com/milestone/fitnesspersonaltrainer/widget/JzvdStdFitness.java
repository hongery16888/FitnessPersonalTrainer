package com.milestone.fitnesspersonaltrainer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

import cn.jzvd.JzvdStd;

public class JzvdStdFitness extends JzvdStd {

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;

    public JzvdStdFitness(Context context) {
        super(context);
    }

    public JzvdStdFitness(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onSeekComplete() {
        super.onSeekComplete();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        super.onProgressChanged(seekBar, progress, fromUser);
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(seekBar, progress, fromUser);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStartTrackingTouch(seekBar);
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStopTrackingTouch(seekBar);
        }
    }


    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.onSeekBarChangeListener = onSeekBarChangeListener;
    }
}
