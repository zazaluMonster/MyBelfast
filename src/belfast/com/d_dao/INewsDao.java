package com.d_dao;

import com.a_pojo.News;

import java.util.List;
import java.util.Map;

public interface INewsDao extends BaseDao<News>{

    void deleteAll();
    List<News> selectsByIdPage(Map<String,Object> condition) throws Exception;
}
