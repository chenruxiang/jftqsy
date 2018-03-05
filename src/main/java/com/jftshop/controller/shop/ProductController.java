package com.jftshop.controller.shop;

import com.jftshop.entity.Product;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * Created by ThinkPad on 2018/3/5.
 */

@Controller("shopproductController")
@RequestMapping({"/shop/product"})
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/listinproductcategory/{id}")
    public String listinproductcategory(Model model, @PathVariable String id)
    {
        ProductCategory productcategory  = this.categoryservice.getOne( id );
        if ( productcategory != null ){

            Set<Product> set = productcategory.getProducts();
            model.addAttribute("products",set);
        }
        return "shop/product/list";
    }

    @GetMapping("/product/{id}")
    public String content(Model model, @PathVariable String id)
    {
        Product product  = this.productservice.getOne( id );
        if ( product != null ){
            model.addAttribute("product",product);
        }
        return "shop/product/content";
    }

    @Autowired
    CategoryService categoryservice;

    @Autowired
    ProductService productservice;

}
