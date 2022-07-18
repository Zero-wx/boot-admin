package com.zero.serverApi.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CURDService<T, ID> {

    /**
     * 增加记录
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 删除一条记录
     */
    int delete(Integer id);

    /**
     * 查询用户
     *
     * @return
     */
    List<T> select();

    /**
     * 更新
     */
    int update(T params);
}
