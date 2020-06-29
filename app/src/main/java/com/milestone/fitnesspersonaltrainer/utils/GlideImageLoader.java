package com.milestone.fitnesspersonaltrainer.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by ThinkPad on 2018/2/27.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //具体方法内容自己选择
        Glide.with(context)
                .asBitmap()
                .load(path)
                .apply(new RequestOptions().centerCrop()
                        .placeholder(android.R.color.white))
                .into(imageView);
    }
}
