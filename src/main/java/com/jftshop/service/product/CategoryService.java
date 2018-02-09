package com.jftshop.service.product;

import com.jftshop.entity.ProductCategory;
import com.jftshop.service.BaseService;

import java.util.List;

public interface CategoryService extends BaseService<ProductCategory, String> {

    public abstract List<ProductCategory> findTree();


}
