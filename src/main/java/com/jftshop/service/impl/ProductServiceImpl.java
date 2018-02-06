package com.jftshop.service.impl;


import com.jftshop.dao.ProductRepository;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly=true)
    public  List<Object[]> listAllCategory(){
        return  productRepository.listAllCategory();
    }

    @Transactional(readOnly=true)
    public  ProductCategory getProductCategory( String id ){
        return  productRepository.getOne( id );
    }

    @Transactional
    public  ProductCategory save( ProductCategory productCategory ){
        return  productRepository.save( productCategory );
    }


    @Transactional(readOnly=true)
    public  List<ProductCategory> findTree(){
        return  productRepository.findByParentIsNull();
    }


}
