package com.jftshop.controller.admin.product;


import com.jftshop.bean.Message;
import com.jftshop.entity.ProductCategory;
import com.jftshop.entity.ProductParameter;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ParameterService;
import com.jftshop.util.JFTStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("productParameterController")
@RequestMapping({"/admin/product_parameter"})
public class ParameterController {

    private static final Logger LOG = LoggerFactory.getLogger(ParameterController.class);

    @GetMapping("/listall")
    @ResponseBody
    public List<Object[]> listAll(ModelMap model)
    {
     //   List<Object[]> list = this.parameterService.listAll();
        return null;
    }

    @PostMapping({"/save"})
    @ResponseBody
    public Message submit(@RequestAttribute Map<String, String> pmap) {

        String name = pmap.get("name");
        String categoryid = pmap.get("categoryid");
        String contents = pmap.get("contents");
        if ( JFTStringUtils.isBlank(name) || JFTStringUtils.isBlank(categoryid) || JFTStringUtils.isBlank(contents) )
            return Message.error("shop.common.invalid", new Object[0]);

        ProductParameter productParameter = new ProductParameter();
        productParameter.setId(JFTStringUtils.get32UUID());
        productParameter.setName(name);
        productParameter.setContents(contents);
        ProductCategory productCategory = categoryService.getOne(categoryid);
        productParameter.setProductcategory(productCategory);
        parameterService.save(productCategory);

        return Message.success("shop.SaveProductCategory.success", new Object[0]);

    }

    @Autowired
    ParameterService parameterService;

    @Autowired
    CategoryService categoryService;

}
