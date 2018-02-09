package com.jftshop.service.product.impl;


import com.jftshop.dao.product.CategoryRepository;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Transactional(readOnly=true)
    public  List<Object[]> listAll(){
        return  categoryRepository.listAll();
    }

    @Transactional(readOnly=true)
    public  ProductCategory getOne( String id ){
        return  categoryRepository.getOne( id );
    }

    @Transactional
    public  ProductCategory save( ProductCategory productCategory ){
        return  categoryRepository.save( productCategory );
    }


    @Transactional(readOnly=true)
    public  List<ProductCategory> findTree(){
        return  categoryRepository.findByParentIsNull();
    }


}
