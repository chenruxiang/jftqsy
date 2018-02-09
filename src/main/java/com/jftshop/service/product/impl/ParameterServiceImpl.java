package com.jftshop.service.product.impl;


import com.jftshop.dao.product.ParameterRepository;
import com.jftshop.service.product.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    ParameterRepository parameterRepository;
}
