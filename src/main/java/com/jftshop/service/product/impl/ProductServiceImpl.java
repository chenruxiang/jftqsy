package com.jftshop.service.product.impl;

import com.jftshop.dao.product.ProductRepository;
import com.jftshop.entity.Product;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product,String>
        implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    public void setBaseDao(ProductRepository productRepository)
    {
        super.setBaseDao(productRepository);
    }

}
