package com.zero.serverApi.service;

import com.zero.serverApi.bean.entity.system.Account;


public abstract class BaseService<T,ID> implements CURDService<T,Long>{

    public abstract Account findByAccount(String record);

}
