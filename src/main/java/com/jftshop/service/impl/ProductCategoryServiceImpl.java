package com.jftshop.service.impl;


import com.jftshop.dao.ProductCategoryRepository;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Transactional(readOnly=true)
    public  List<ProductCategory> findAll(){
        return  productCategoryRepository.findAll();
    }

    @Transactional(readOnly=true)
    public  List<ProductCategory> findTree(){
        return  productCategoryRepository.findByParentIsNull();
    }


}
