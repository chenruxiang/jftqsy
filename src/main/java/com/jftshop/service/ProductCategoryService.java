package com.jftshop.service;

import com.jftshop.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> findTree();

    public List<ProductCategory> findAll();
}
