package com.milestone.fitnesspersonaltrainer.model;

import java.util.List;

public class Course {

    /**
     * id : 0
     * course_title : DDP Yoga Combo
     * course_type : sport
     * like : 900
     * total_time : 1000000
     * calories : 100
     * course_img_url : http://www.baidu.com
     * course_lesson : [{"id":0,"lesson_name":"Push-ups","lesson_video_url":"http://www.baidu.com","lesson_time":10000,"calories":100,"lesson_img_url":"http://www.baidu.com"}]
     */

    private int id;
    private String course_title;
    private String course_type;
    private String like;
    private String total_time;
    private String calories;
    private String course_img_url;
    private List <CourseLessonBean> course_lesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCourse_img_url() {
        return course_img_url;
    }

    public void setCourse_img_url(String course_img_url) {
        this.course_img_url = course_img_url;
    }

    public List <CourseLessonBean> getCourse_lesson() {
        return course_lesson;
    }

    public void setCourse_lesson(List <CourseLessonBean> course_lesson) {
        this.course_lesson = course_lesson;
    }

    public static class CourseLessonBean {
        /**
         * id : 0
         * lesson_name : Push-ups
         * lesson_video_url : http://www.baidu.com
         * lesson_time : 10000
         * calories : 100
         * lesson_img_url : http://www.baidu.com
         */

        private int id;
        private String lesson_name;
        private String lesson_video_url;
        private String lesson_time;
        private String calories;
        private String lesson_img_url;
        private int progress;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLesson_name() {
            return lesson_name;
        }

        public void setLesson_name(String lesson_name) {
            this.lesson_name = lesson_name;
        }

        public String getLesson_video_url() {
            return lesson_video_url;
        }

        public void setLesson_video_url(String lesson_video_url) {
            this.lesson_video_url = lesson_video_url;
        }

        public String getLesson_time() {
            return lesson_time;
        }

        public void setLesson_time(String lesson_time) {
            this.lesson_time = lesson_time;
        }

        public String getCalories() {
            return calories;
        }

        public void setCalories(String calories) {
            this.calories = calories;
        }

        public String getLesson_img_url() {
            return lesson_img_url;
        }

        public void setLesson_img_url(String lesson_img_url) {
            this.lesson_img_url = lesson_img_url;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }
    }
}
