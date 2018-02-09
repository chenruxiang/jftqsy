package com.jftshop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/8.
 */
public abstract  class BaseService<T, ID extends Serializable> {

    private JpaRepository<T, ID> jpaRepository;

    public void setBaseDao(JpaRepository<T, ID> jpaRepository)
    {
        this.jpaRepository = jpaRepository;
    }

    @Transactional(readOnly=true)
    public T getOne(ID id)
    {
        return this.jpaRepository.getOne(id);
    }


    @Transactional(readOnly=true)
    public List<T> findAll(){
        return this.jpaRepository.findAll();
    }


}
