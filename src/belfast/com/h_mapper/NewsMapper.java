package com.h_mapper;

import com.a_pojo.News;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface NewsMapper extends BaseMapper<News> {
    void deleteAll();

    List<News> selectsByIdPage(Map<String,Object> condition);
}
