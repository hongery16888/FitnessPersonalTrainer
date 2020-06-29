package com.milestone.fitnesspersonaltrainer.model;

import java.util.List;

public class Diet {

    private List <BannerBean> banner;
    private List <DietBean> recommended;

    public List <BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List <BannerBean> banner) {
        this.banner = banner;
    }

    public List <DietBean> getRecommended() {
        return recommended;
    }

    public void setRecommended(List <DietBean> recommended) {
        this.recommended = recommended;
    }

    public static class BannerBean {
        /**
         * id : 0
         * image_url : http://www.baidu.com
         * diet_title : News headline
         * diet_time : 1000000
         * diet_author : magic
         * like : 999
         * diet_content : There is something about parenthood
         */

        private int id;
        private String image_url;
        private String diet_title;
        private long diet_time;
        private String diet_author;
        private String like;
        private String diet_content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDiet_title() {
            return diet_title;
        }

        public void setDiet_title(String diet_title) {
            this.diet_title = diet_title;
        }

        public long getDiet_time() {
            return diet_time;
        }

        public void setDiet_time(long diet_time) {
            this.diet_time = diet_time;
        }

        public String getDiet_author() {
            return diet_author;
        }

        public void setDiet_author(String diet_author) {
            this.diet_author = diet_author;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getDiet_content() {
            return diet_content;
        }

        public void setDiet_content(String diet_content) {
            this.diet_content = diet_content;
        }
    }

    public static class DietBean {
        /**
         * id : 0
         * image_url : http://www.baidu.com
         * diet_title : News headline
         * diet_time : 1000000
         * diet_author : magic
         * like : 999
         * diet_content : There is something about parenthood
         */

        private int id;
        private String image_url;
        private String diet_title;
        private long diet_time;
        private String diet_author;
        private String like;
        private String diet_content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getDiet_title() {
            return diet_title;
        }

        public void setDiet_title(String diet_title) {
            this.diet_title = diet_title;
        }

        public long getDiet_time() {
            return diet_time;
        }

        public void setDiet_time(long diet_time) {
            this.diet_time = diet_time;
        }

        public String getDiet_author() {
            return diet_author;
        }

        public void setDiet_author(String diet_author) {
            this.diet_author = diet_author;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getDiet_content() {
            return diet_content;
        }

        public void setDiet_content(String diet_content) {
            this.diet_content = diet_content;
        }
    }
}
