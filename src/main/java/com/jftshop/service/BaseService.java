package com.jftshop.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/8.
 */
public  interface BaseService<T, ID extends Serializable> {

    public  T getOne(ID id);

    public  List<T> findAll();

    public <S extends T> S save(S s);

}
