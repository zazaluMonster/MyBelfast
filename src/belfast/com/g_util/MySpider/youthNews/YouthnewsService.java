package com.g_util.MySpider.youthNews;

import DataService.DataService;
import com.a_pojo.News;
import com.c_service.INewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.io.IOException;
import java.util.List;

public class YouthnewsService implements DataService<News> {

    private INewsService newsService;

    @Override
    public void init() throws IOException {
        //由于MySpider的DataService不在MyBelfast的Spring容器中，所以没法使用Autowired
        //故手动获取MyBelfast的Spring容器，并获取我需要的service
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        newsService = context.getBean("newsService", INewsService.class);
    }

    @Override
    public void closed() {

    }

    @Override
    public int add(News news) {
        return 0;
    }

    @Override
    public void adds(List<News> list) throws ClassNotFoundException {
        newsService.inserts(list);
    }

    @Override
    public News get(int i) {
        return null;
    }

    @Override
    public void update(News news) {

    }

    @Override
    public void delete(int i) {

    }
}
