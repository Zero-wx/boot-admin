package com.zero.serverApi.service;

import java.util.List;

/**
 * 增删改查基础接口
 */
public interface CURDService<T> {

    T insert(T record);
//
//    int delete();
//
//    int update();
//
//    List<T> select();
}


