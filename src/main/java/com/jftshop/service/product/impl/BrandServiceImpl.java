package com.jftshop.service.product.impl;

import com.jftshop.dao.product.AttributeRepository;
import com.jftshop.dao.product.BrandRepository;
import com.jftshop.entity.Attribute;
import com.jftshop.entity.Brand;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.AttributeService;
import com.jftshop.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2018/2/8.
 */

@Service("brandService")
public class BrandServiceImpl extends BaseServiceImpl<Brand,String>
        implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    public void setBaseDao(AttributeRepository attributeRepository)
    {
        super.setBaseDao(brandRepository);
    }






}
