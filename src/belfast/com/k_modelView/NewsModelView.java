package com.k_modelView;

import com.a_pojo.News;
import com.g_util.MyHttpStatus;

import java.util.List;

public class NewsModelView extends BaseModelView {

    public List<News> news;

    public NewsModelView(MyHttpStatus status, String msg, String errMsg) {
        super(status, msg, errMsg);
    }

    public NewsModelView(MyHttpStatus status) {
        super(status);
    }

    public NewsModelView(MyHttpStatus status, List<News> news) {
        super(status);
        this.news = news;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
