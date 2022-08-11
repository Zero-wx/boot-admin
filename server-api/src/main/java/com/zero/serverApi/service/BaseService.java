package com.zero.serverApi.service;


public abstract class BaseService<T> implements CURDService<T> {

    @Override
    public T insert(T record) {
        return null;
    }


}
