package com.milestone.fitnesspersonaltrainer.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseBindingAdapter;
import com.milestone.fitnesspersonaltrainer.databinding.CourseVideoItemBinding;
import com.milestone.fitnesspersonaltrainer.model.Course;
import com.milestone.fitnesspersonaltrainer.utils.LocalRepository;
import com.milestone.fitnesspersonaltrainer.utils.TimeUtil;

public class VideoAdapter extends BaseBindingAdapter <Course.CourseLessonBean, CourseVideoItemBinding> {

    private Context context;

    public VideoAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.course_video_item;
    }

    @Override
    protected void onBindItem(CourseVideoItemBinding binding, Course.CourseLessonBean item, final int position) {

        String urlLessonImg = item.getLesson_img_url();

//        GlideApp.with(context).load(R.mipmap.diet_pic1)
//                .into(binding.img);

        //  课程图片
//        GlideApp.with(context).load(urlLessonImg).into(binding.img);

        String urlVideo = item.getLesson_video_url();

        //  进度

        int progress = item.getProgress();

//        progress = (int) JZUtils.getSavedProgress(context, urlVideo);
        if (progress == 0) {
            String progressStr = LocalRepository.INSTANCE.get(urlVideo);
            if (!TextUtils.isEmpty(progressStr)) {
                progress = Integer.valueOf(progressStr);
            }
        }

        binding.crpv.setPercent(progress);
        binding.progressNum.setText(String.format("%d%%", progress));

        //  课程名
        String lessonName = item.getLesson_name();
        binding.tvLessonName.setText(lessonName);

        //  剩余时间
        String lessonTimeStr = item.getLesson_time();
        long lessonTime = 0;
        if (!TextUtils.isEmpty(lessonTimeStr)) {
            lessonTime = Long.valueOf(lessonTimeStr);
        }

        long restTime = lessonTime * (100 - progress) / 60 / 100;
        String restTimeStr = context.getString(R.string.minutes_rest, restTime);
        binding.tvRestTime.setText(restTimeStr);

        //   观看时间
        long last = LocalRepository.INSTANCE.getLongLastTime(urlVideo);
        long now = System.currentTimeMillis();

        int time[] = TimeUtil.divideBetween(last, now);
        if (time != null) {
            //  [年][月][日][时][分][秒]
            int year = time[0];
            int month = time[1];
            int day = time[2];
            int hour = time[3];
            int minute = time[4];
            int second = time[5];
            if (year > 0) {
                if (year == 1) {
                    binding.tvLastWatchTime.setText(year + " year ago");
                } else {
                    binding.tvLastWatchTime.setText(year + " years ago");
                }
            } else if (month > 0) {
                if (month == 1) {
                    binding.tvLastWatchTime.setText(month + " month ago");
                } else {
                    binding.tvLastWatchTime.setText(month + " months ago");
                }
            } else if (day > 0) {
                if (day == 1) {
                    binding.tvLastWatchTime.setText(day + " day ago");
                } else {
                    binding.tvLastWatchTime.setText(day + " days ago");
                }
            } else if (hour > 0) {
                if (hour == 1) {
                    binding.tvLastWatchTime.setText(hour + " hour ago");
                } else {
                    binding.tvLastWatchTime.setText(hour + " hours ago");
                }
            } else if (minute > 0) {
                if (minute == 1) {
                    binding.tvLastWatchTime.setText(minute + " minute ago");
                } else {
                    binding.tvLastWatchTime.setText(minute + " minutes ago");
                }
            } else if (second > 0) {
                if (second == 1) {
                    binding.tvLastWatchTime.setText(second + " second ago");
                } else {
                    binding.tvLastWatchTime.setText(second + " seconds ago");
                }
            } else {
                binding.tvLastWatchTime.setText("just now");
            }
        } else {
            binding.tvLastWatchTime.setText("unknown");
        }

        binding.courseVideoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnRecyclerViewItemClickListener().onItemClick(position);
            }
        });
    }
}
