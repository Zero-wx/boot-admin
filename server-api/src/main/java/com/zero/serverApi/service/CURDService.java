package com.zero.serverApi.service;

import java.util.List;

/**
 * 增删改查service
 */
public interface CURDService<T, ID> {

    int insert(T record);

    void delete();

    void update();

    /**
     * 查询所有
     *
     * @return 返回所有结果
     */
    List<T> selectAll();

    /**
     * 根据单个 id 查询
     *
     * @param id
     * @return
     */
    List<T> selectById(int id);


    List<T> selectAll(String record);

}


