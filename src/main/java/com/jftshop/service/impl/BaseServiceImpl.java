package com.jftshop.service.impl;

import com.jftshop.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/9.
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    public JpaRepository<T, ID> jpaRepository;

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
    public T findOne(ID id)
    {
        return this.jpaRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<T> findAll(){
        return this.jpaRepository.findAll();
    }

    @Transactional
    public <S extends T> S save(S s){
        return jpaRepository.save(s);
    }



}


