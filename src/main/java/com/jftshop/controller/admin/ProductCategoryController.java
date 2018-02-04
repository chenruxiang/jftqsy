package com.jftshop.controller.admin;


import com.jftshop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("productCategoryController")
@RequestMapping({"/admin/product_category"})
public class ProductCategoryController {


    @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String list(ModelMap model)
    {
        model.addAttribute("productCategoryTree", this.productCategoryService.findAll());
        return "/admin/product_category/list";
    }

    @Autowired
    ProductCategoryService productCategoryService;

}
