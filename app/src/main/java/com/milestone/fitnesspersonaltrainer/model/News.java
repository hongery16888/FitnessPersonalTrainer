package com.milestone.fitnesspersonaltrainer.model;

import java.util.List;

public class News {

    private List <BannerBean> banner;
    private List <NewsBean> news;

    public List <BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List <BannerBean> banner) {
        this.banner = banner;
    }

    public List <NewsBean> getNews() {
        return news;
    }

    public void setNews(List <NewsBean> news) {
        this.news = news;
    }

    public static class BannerBean {
        /**
         * id : 0
         * image_url : http://www.baidu.com
         * news_title : News headline
         * news_time : 1000000
         * news_author : magic
         * like : 999
         * news_content : There is something about parenthood
         */

        private int id;
        private String image_url;
        private String news_title;
        private long news_time;
        private String news_author;
        private String like;
        private String news_content;

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

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public long getNews_time() {
            return news_time;
        }

        public void setNews_time(long news_time) {
            this.news_time = news_time;
        }

        public String getNews_author() {
            return news_author;
        }

        public void setNews_author(String news_author) {
            this.news_author = news_author;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }
    }

    public static class NewsBean {
        /**
         * id : 0
         * image_url : http://www.baidu.com
         * news_title : News headline
         * news_time : 1000000
         * news_author : magic
         * like : 999
         * news_content : There is something about parenthood
         */

        private int id;
        private String image_url;
        private String news_title;
        private long news_time;
        private String news_author;
        private String like;
        private String news_content;

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

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public long getNews_time() {
            return news_time;
        }

        public void setNews_time(long news_time) {
            this.news_time = news_time;
        }

        public String getNews_author() {
            return news_author;
        }

        public void setNews_author(String news_author) {
            this.news_author = news_author;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }
    }
}
