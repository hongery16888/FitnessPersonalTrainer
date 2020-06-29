package com.milestone.fitnesspersonaltrainer.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.milestone.fitnesspersonaltrainer.R;
import com.milestone.fitnesspersonaltrainer.adapter.CourseAdapter;
import com.milestone.fitnesspersonaltrainer.base.BaseFragment;
import com.milestone.fitnesspersonaltrainer.databinding.FragmentCourseBinding;
import com.milestone.fitnesspersonaltrainer.listener.OnHomeCourseListener;
import com.milestone.fitnesspersonaltrainer.listener.OnRecyclerViewItemClickListener;
import com.milestone.fitnesspersonaltrainer.model.Course;
import com.milestone.fitnesspersonaltrainer.vewmodel.CourseViewModel;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;

public class CoursesssFragment extends BaseFragment <FragmentCourseBinding, CourseViewModel> implements OnHomeCourseListener {

    private CourseAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    protected CourseViewModel createFragmentViewModel() {
        return new CourseViewModel(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPara();
        setListener();
        loadData();
    }

    private void initPara() {
        setDrawTop(binding.all, R.drawable.course_type_all_selector);
        setDrawTop(binding.equipment, R.drawable.course_type_equipment_selector);
        setDrawTop(binding.sports, R.drawable.course_type_sports_selector);
        setDrawTop(binding.dance, R.drawable.course_type_dance_selector);
        setDrawTop(binding.ranking, R.drawable.course_type_ranking_selector);

        adapter = new CourseAdapter(getContext());
        binding.courseRecyclerr.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.courseRecyclerr.setAdapter(adapter);


    }

    private void setListener() {
        adapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                getApp().setCourse(adapter.getItems().get(position));
//                startActivity(new Intent(getContext(), CourseVideoActivity.class));
            }
        });
    }

    private void setDrawTop(RadioButton button, int res){
        Drawable drawable = getResources().getDrawable(res);
        drawable.setBounds(0,0,80,80);
        button.setCompoundDrawables(null,drawable,null,null);
    }

    private void loadData() {
        //测试数据
//        adapter.getItems().add(new Course());
        //正式数据
//        viewModel.onHomeCourseListener = this;
//        viewModel.getCourse();
    }

    @Override
    public void onSuccess(ArrayList <Course> courses) {
        adapter.getItems().addAll(courses);
    }

    @Override
    public void onError(String error) {

    }
}
