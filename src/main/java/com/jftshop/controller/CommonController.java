package com.jftshop.controller;

import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by ThinkPad on 2018/1/29.
 */

@Controller("commonController")
public class CommonController {

    private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);

    @GetMapping("/")
    public String index(Model model) {
        LOG.debug("/admin/main");
        List<ProductCategory> list =  categoryService.findAll();
        model.addAttribute("productcategorylist",list);
        return "index";
    }

    @Autowired
    CategoryService categoryService;

}
