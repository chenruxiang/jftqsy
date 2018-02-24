package com.jftshop.controller.admin.product;


import com.jftshop.entity.ParameterGroup;
import com.jftshop.entity.ProductCategory;
import com.jftshop.entity.Parameter;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ParameterService;
import com.jftshop.util.JFTStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller("parameterController")
@RequestMapping({"/admin/product/parameter"})
public class ParameterController {

    private static final Logger LOG = LoggerFactory.getLogger(ParameterController.class);

    @GetMapping("/listall")
    public String listAll(Model model) {
        List<ParameterGroup> list = this.parameterService.findAll();
        model.addAttribute("parlist",list);
        return "admin/product/parameter/list";
    }

    @PostMapping({"/save"})
    public String submit(ParameterGroup parameterGroup, String productcategoryid) {

        ProductCategory productCategory = this.categoryService.getOne(productcategoryid);
        List<Parameter> parameters = parameterGroup.getParameters();
        Iterator<Parameter> iterator = parameters.iterator();
        while (iterator.hasNext()){
            Parameter parameter = iterator.next();
            if (parameter == null || JFTStringUtils.isBlank(parameter.getName())){
                iterator.remove();
            }else {
                parameter.setId(JFTStringUtils.get32UUID());
                parameter.setParametergroup(parameterGroup);
            }
        }

        parameterGroup.setId(JFTStringUtils.get32UUID());
        parameterGroup.setProductcategory(productCategory);
        parameterService.save(parameterGroup);

        return "admin/product/parameter/add";
    }

    @Autowired
    ParameterService parameterService;

    @Autowired
    CategoryService categoryService;

}
