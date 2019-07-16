package com.a_pojo;

/**
 * 首页菜单pojo类
 */
public class Menu {
    public String url;
    public String title;

    public Menu(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
