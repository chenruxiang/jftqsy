package com.jftshop.service.product;

import com.jftshop.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    public List<ProductCategory> findTree();

    public List<Object[]> listAll();

    public  ProductCategory getOne( String id );

    public  ProductCategory save( ProductCategory productCategory );

}
