package com.jftshop.service.product.impl;


import com.jftshop.dao.product.CategoryRepository;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("productService")
public class CategoryServiceImpl extends BaseServiceImpl<ProductCategory,String> implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    public void setBaseDao(CategoryRepository categoryRepository)
    {
        super.setBaseDao(categoryRepository);
    }


    @Transactional(readOnly=true)
    public  List<ProductCategory> findTree(){
        this.save(new ProductCategory());
        return  categoryRepository.findByParentIsNull();
    }

}
