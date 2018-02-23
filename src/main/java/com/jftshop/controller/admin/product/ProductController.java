package com.jftshop.controller.admin.product;

import com.jftshop.entity.Attribute;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Controller("productController")
@RequestMapping({"/admin/product"})
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/listall")
    public String listAll(Model model)
    {
        List<Product> list = this.productService.findAll();
        model.addAttribute("productlist",list);
        return "admin/product/product/list";
    }

    @GetMapping("/attributes")
    @ResponseBody
    public Set<Attribute> attributes(String id)
    {
        ProductCategory localProductCategory = (ProductCategory)this.categoryService.getOne(id);
        return localProductCategory.getAttributes();
    }


    @PostMapping("/save")
    public String save(Product product , String productcategoryid) {

        return "";
    }


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

}
