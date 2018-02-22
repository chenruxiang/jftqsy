package com.jftshop.service.product.impl;

import com.jftshop.dao.product.AttributeRepository;
import com.jftshop.entity.Attribute;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2018/2/8.
 */

@Service("attributeService")
public class AttributeServiceImpl extends BaseServiceImpl<Attribute,String>
        implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    public void setBaseDao(AttributeRepository attributeRepository)
    {
        super.setBaseDao(attributeRepository);
    }






}
