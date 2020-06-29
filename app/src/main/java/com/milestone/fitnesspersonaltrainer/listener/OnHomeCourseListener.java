package com.milestone.fitnesspersonaltrainer.listener;

import com.milestone.fitnesspersonaltrainer.model.Course;

import java.util.ArrayList;

public interface OnHomeCourseListener {

    void onSuccess(ArrayList <Course> course);
    void onError(String error);
}
