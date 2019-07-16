package com.d_dao;

import com.a_pojo.News;
import com.h_mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NewsDao implements INewsDao {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public void inserts(List<News> items) {
        newsMapper.inserts(items);
    }

    @Override
    public void delete(int id) {
        newsMapper.delete(id);
    }

    @Override
    public void deletes(List<Integer> ids) {
        newsMapper.deletes(ids);
    }

    @Override
    public void update(News item) {
        newsMapper.update(item);
    }

    @Override
    public void updates(List<News> items) {
        newsMapper.updates(items);
    }

    @Override
    public List<News> selects(Map<String, Object> condition) {
        return newsMapper.selects(condition);
    }

    @Override
    public void deleteAll() {
        newsMapper.deleteAll();
    }

    @Override
    public List<News> selectsByIdPage(Map<String, Object> condition) throws Exception {
        int page = (int) condition.get("page");

        if(page<1){
            throw new Exception("分页错误");
        }else{
            int pageStart = (page-1) * 10 + 1;
            int pageEnd = page * 10;
            condition.put("pageStart",pageStart);
            condition.put("pageEnd",pageEnd);
            return newsMapper.selectsByIdPage(condition);
        }
    }
}
