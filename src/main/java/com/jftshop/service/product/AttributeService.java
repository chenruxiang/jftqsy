package com.jftshop.service.product;

import com.jftshop.entity.Attribute;

import java.util.List;

/**
 * Created by ThinkPad on 2018/2/8.
 */
public interface AttributeService{
    public Attribute getOne(String id);
    List<Attribute> findAll();
}
