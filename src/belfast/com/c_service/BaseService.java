package com.c_service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    void inserts(List<T> items);
    void delete(int id);
    void deletes(List<Integer> ids);
    void update(T item);
    void updates(List<T> items);
    List<T> selects(Map<String,Object> condition);
}
