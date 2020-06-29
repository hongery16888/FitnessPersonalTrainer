package com.milestone.fitnesspersonaltrainer.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.adapter.VideoAdapter;
import com.milestone.fitnesspersonaltrainer.base.BaseActivity;
import com.milestone.fitnesspersonaltrainer.base.GlideApp;
import com.milestone.fitnesspersonaltrainer.databinding.ActivityCourseVideoBinding;
import com.milestone.fitnesspersonaltrainer.listener.OnBaseNetworkListener;
import com.milestone.fitnesspersonaltrainer.listener.OnRecyclerViewItemClickListener;
import com.milestone.fitnesspersonaltrainer.model.Course;
import com.milestone.fitnesspersonaltrainer.utils.LocalRepository;
import com.milestone.fitnesspersonaltrainer.vewmodel.CourseVideoViewModel;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import cn.jzvd.Jzvd;

public class CourseVideoActivity extends BaseActivity <ActivityCourseVideoBinding, CourseVideoViewModel> {

    private VideoAdapter adapter;
    private Course course;

    private int currentVideoPosition = -1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_course_video;
    }

    @Override
    protected CourseVideoViewModel createViewModel() {
        return new CourseVideoViewModel(this);
    }

    @Override
    protected OnBaseNetworkListener getNetworkListener() {
        return null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentVideoPosition", currentVideoPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentVideoPosition = savedInstanceState.getInt("currentVideoPosition");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPara();
        setListener();
    }

    private void initPara() {
        course = getApp().getCourse();

        adapter = new VideoAdapter(this);
        binding.videoRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.videoRecycler.setAdapter(adapter);

        if (course != null) {

            //  课程名称
            String courseName = course.getCourse_title();

            TextView tvTitle = binding.titleBar.findViewById(R.id.title);
            tvTitle.setText(courseName);

            binding.tvCourseName.setText(courseName);

            String courseTotalTimeStr = course.getTotal_time();

            //  课程时长
            long minutes = 0;
            if (!TextUtils.isEmpty(courseTotalTimeStr)) {
                long totalTime = Long.valueOf(courseTotalTimeStr);
                minutes = totalTime / 60;
            }
            binding.tvCourseTotalTime.setText(String.valueOf(minutes));

            //  卡路里
            String calories = course.getCalories();
            binding.tvCalories.setText(calories);

            //  课程总课程数
            int totalLessons = 0;

            List <Course.CourseLessonBean> courseLessons = course.getCourse_lesson();
            if (courseLessons != null && !courseLessons.isEmpty()) {

                totalLessons = courseLessons.size();

                currentVideoPosition = 0;

                Course.CourseLessonBean lessonFirst = courseLessons.get(0);
                playVideo(lessonFirst, false);

//                String defaultImageUrl = lessonFirst.getLesson_img_url();
//                GlideApp.with(this).load(defaultImageUrl).into( binding.videoplayer.thumbImageView);
//
//                String defaultVideoUrl = lessonFirst.getLesson_video_url();
//                String defaultLessonName = lessonFirst.getLesson_name();
//                binding.videoplayer.setUp(defaultVideoUrl, defaultLessonName, Jzvd.SCREEN_WINDOW_NORMAL);
//                String progressHistory = LocalRepository.INSTANCE.get(defaultVideoUrl);
//                if (!TextUtils.isEmpty(progressHistory)) {
//                    String lessonTimeStr = lessonFirst.getLesson_time();
//                    if (!TextUtils.isEmpty(lessonTimeStr)) {
//                        long lessonTime = Long.valueOf(lessonTimeStr);
//                        int progress = Integer.valueOf(progressHistory);
//
//                        long seekToTime = lessonTime * progress;
//                        binding.videoplayer.seekToInAdvance = seekToTime;
//                    }
//                }

            }

            binding.tvTotalLessons.setText(String.valueOf(totalLessons));

            adapter.getItems().addAll(courseLessons);
        }


//                binding.videoplayer.setUp("http://sepelling.xyz/video/test.mp4"
//                        , "Breathing", Jzvd.SCREEN_WINDOW_NORMAL);
//        GlideApp.with(this).load("http://sepelling.xyz/video/test_img.png").into( binding.videoplayer.thumbImageView);


//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
//        adapter.getItems().add("1");
    }

    private void playVideo(Course.CourseLessonBean courseLessonBean, boolean needStart) {

        String curVideoUrl = null;
        if (binding.videoplayer.jzDataSource != null) {
            curVideoUrl = (String) binding.videoplayer.getCurrentUrl();
        }

        String urlLessonVideo = courseLessonBean.getLesson_video_url();

        if (curVideoUrl != null && curVideoUrl.equals(urlLessonVideo)) {
            int state = binding.videoplayer.currentState;
//
////            public static final int CURRENT_STATE_NORMAL = 0;
////            public static final int CURRENT_STATE_PREPARING = 1;
////            public static final int CURRENT_STATE_PREPARING_CHANGING_URL = 2;
////            public static final int CURRENT_STATE_PLAYING = 3;
////            public static final int CURRENT_STATE_PAUSE = 5;
////            public static final int CURRENT_STATE_AUTO_COMPLETE = 6;
////            public static final int CURRENT_STATE_ERROR = 7;
//
            if (state == Jzvd.CURRENT_STATE_NORMAL || state == Jzvd.CURRENT_STATE_PAUSE) {

            } else if (state == Jzvd.CURRENT_STATE_PREPARING || state == Jzvd.CURRENT_STATE_PREPARING_CHANGING_URL
                    || state == Jzvd.CURRENT_STATE_PLAYING || state == Jzvd.CURRENT_STATE_PREPARING) {
                saveProgress();
            }

            binding.videoplayer.startButton.performClick();
        } else {
            String urlImg = courseLessonBean.getLesson_img_url();
            GlideApp.with(this).load(urlImg).into( binding.videoplayer.thumbImageView);


            String lessonName = courseLessonBean.getLesson_name();
            binding.videoplayer.setUp(urlLessonVideo, lessonName, Jzvd.SCREEN_WINDOW_NORMAL);
            String progressHistory = LocalRepository.INSTANCE.get(urlLessonVideo);
            if (!TextUtils.isEmpty(progressHistory)) {
                String lessonTimeStr = courseLessonBean.getLesson_time();
                if (!TextUtils.isEmpty(lessonTimeStr)) {
                    int progress = Integer.valueOf(progressHistory);

                    //  TODO  服务器返回的时间不准确
                    long lessonTime = Long.valueOf(lessonTimeStr);

                    long duration = binding.videoplayer.getDuration();
//                long seekToTime = lessonTime * progress;
                    long seekToTime = (progress == 100 ? 0 : duration * progress / 100);
                    binding.videoplayer.seekToInAdvance = seekToTime;
                }
            }

            if (needStart) {
                binding.videoplayer.startVideo();
            }
        }


    }

    private void setListener() {

        binding.videoplayer.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProgress();
            }
        });

        adapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                currentVideoPosition = position;
                Course.CourseLessonBean courseLessonBean = adapter.getItems().get(position);
                playVideo(courseLessonBean, true);
            }
        });

        binding.videoplayer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Log.i("--->", "进度：" + i + "   isFromUser == " + b + "  binding.videoplayer.currentState == " + binding.videoplayer.currentState);

                if (binding.videoplayer.currentState == Jzvd.CURRENT_STATE_PLAYING && currentVideoPosition >= 0) {
                    Course.CourseLessonBean courseLessonBean = adapter.getItems().get(currentVideoPosition);
                    saveProgress();
                    courseLessonBean.setProgress(i);
                    adapter.notifyItemChanged(currentVideoPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("--->", "onStopTrackingTouch进度：" + binding.videoplayer.progressBar.getProgress());

                Course.CourseLessonBean courseLessonBean = adapter.getItems().get(currentVideoPosition);
                seekToPlay(courseLessonBean, binding.videoplayer.progressBar.getProgress());
            }
        });


    }


    private void seekToPlay(Course.CourseLessonBean courseLessonBean, int progress) {

        String urlLessonVideo = courseLessonBean.getLesson_video_url();
        String urlImg = courseLessonBean.getLesson_img_url();
        GlideApp.with(this).load(urlImg).into( binding.videoplayer.thumbImageView);


        String lessonTimeStr = courseLessonBean.getLesson_time();
        String lessonName = courseLessonBean.getLesson_name();
        binding.videoplayer.setUp(urlLessonVideo, lessonName, Jzvd.SCREEN_WINDOW_NORMAL);
        String progressHistory = LocalRepository.INSTANCE.get(urlLessonVideo);

        //  TODO  服务器返回的时间不准确
        long lessonTime = Long.valueOf(lessonTimeStr);
        long duration = binding.videoplayer.getDuration();
//                long seekToTime = lessonTime * progress;
        long seekToTime = (progress == 100 ? 0 : duration * progress / 100);
        binding.videoplayer.seekToInAdvance = seekToTime;
        binding.videoplayer.startVideo();

    }



    private void saveProgress() {
        String urlPlaying = (String) binding.videoplayer.getCurrentUrl();
        int progress = binding.videoplayer.progressBar.getProgress();
        LocalRepository.INSTANCE.put(urlPlaying, String.valueOf(progress));
        LocalRepository.INSTANCE.putLongLastTime(urlPlaying, System.currentTimeMillis());
    }

    @Override
    public void onBackPressed() {

        saveProgress();

        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        saveProgress();
        super.onDestroy();
    }
}
