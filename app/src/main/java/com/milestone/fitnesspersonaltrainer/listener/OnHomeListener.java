package com.milestone.fitnesspersonaltrainer.listener;

import com.milestone.fitnesspersonaltrainer.model.HomeModel;

import java.util.ArrayList;

public interface OnHomeListener {

    void onSuccessHome(ArrayList <HomeModel> list);
    void onSuccessGallery(ArrayList <HomeModel> list);
    void onError(String error);
}
