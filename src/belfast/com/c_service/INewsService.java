package com.c_service;

import com.a_pojo.News;

import java.util.List;
import java.util.Map;

public interface INewsService extends BaseService<News> {

    void deleteAll();
    List<News> selectsByIdPage(Map<String,Object> condition) throws Exception;
}
