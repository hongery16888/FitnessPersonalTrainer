package com.milestone.fitnesspersonaltrainer;

import android.app.Application;

import com.milestone.fitnesspersonaltrainer.model.Course;
import com.milestone.fitnesspersonaltrainer.utils.LocalRepository;

import org.litepal.LitePal;

/**
 * Created by ThinkPad on 2017/11/1.
 */

public class FitnessApplication extends Application {

    private Course course;

    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(this);
        LocalRepository.INSTANCE.initLocalRepository(getApplicationContext());
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
