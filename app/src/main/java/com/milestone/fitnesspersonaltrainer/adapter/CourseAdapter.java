package com.milestone.fitnesspersonaltrainer.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.base.BaseBindingAdapter;
import com.milestone.fitnesspersonaltrainer.databinding.CourseItemBinding;
import com.milestone.fitnesspersonaltrainer.model.Course;

import java.util.List;

public class CourseAdapter extends BaseBindingAdapter<Course, CourseItemBinding> {

    public CourseAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.course_item;
    }

    @Override
    protected void onBindItem(CourseItemBinding binding, Course item, final int position) {

        Glide.with(binding.ivCourse).load(item.getCourse_img_url()).into(binding.ivCourse);
        binding.tvCourseName.setText(item.getCourse_title());

        List <Course.CourseLessonBean> lessons = item.getCourse_lesson();
        int lessonTotal = 0;
        if (lessons != null) {
            lessonTotal = lessons.size();
        }

        binding.tvLessonTotal.setText(binding.tvLessonTotal.getContext().getString(R.string.total_lessons, lessonTotal));


        binding.courseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnRecyclerViewItemClickListener().onItemClick(position);
            }
        });
    }
}
