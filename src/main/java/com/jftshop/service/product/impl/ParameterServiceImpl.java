package com.jftshop.service.product.impl;


import com.jftshop.dao.product.AttributeRepository;
import com.jftshop.dao.product.ParameterRepository;
import com.jftshop.entity.ProductParameter;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("parameterService")
public class ParameterServiceImpl extends BaseServiceImpl<ProductParameter, String> implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    public void setBaseDao(ParameterRepository parameterRepository)
    {
        super.setBaseDao(parameterRepository);
    }

}
