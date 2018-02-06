package com.jftshop.service;

import com.jftshop.entity.ProductCategory;

import java.util.List;

public interface ProductService {

    public List<ProductCategory> findTree();

    public List<Object[]> listAllCategory();

    public  ProductCategory getProductCategory( String id );

    public  ProductCategory save( ProductCategory productCategory );

}
