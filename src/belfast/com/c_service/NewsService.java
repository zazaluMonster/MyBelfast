package com.c_service;

import com.a_pojo.News;
import com.d_dao.INewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NewsService implements INewsService {

    @Autowired
    private INewsDao newsDao;

    @Override
    public void inserts(List<News> items) {
        newsDao.inserts(items);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deletes(List<Integer> ids) {

    }

    @Override
    public void update(News item) {

    }

    @Override
    public void updates(List<News> items) {

    }

    @Override
    public List<News> selects(Map<String, Object> condition) {
        return null;
    }

    @Override
    public void deleteAll() {
        newsDao.deleteAll();
    }

    @Override
    public List<News> selectsByIdPage(Map<String, Object> condition) throws Exception {
        return newsDao.selectsByIdPage(condition);
    }
}
