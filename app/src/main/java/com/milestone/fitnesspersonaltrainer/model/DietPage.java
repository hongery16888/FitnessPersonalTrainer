package com.milestone.fitnesspersonaltrainer.model;

public class DietPage {
    private int pager_num;
    private int pager_par_size = 20;
    private String type;

    public int getPager_num() {
        return pager_num;
    }

    public void setPager_num(int pager_num) {
        this.pager_num = pager_num;
    }

    public int getPager_par_size() {
        return pager_par_size;
    }

    public void setPager_par_size(int pager_par_size) {
        this.pager_par_size = pager_par_size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
