package com.jftshop.controller.admin.product;

import com.jftshop.entity.Specification;
import com.jftshop.service.product.SpecificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Controller("specificationController")
@RequestMapping({"/admin/specification"})
public class SpecificationController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);



    @GetMapping("/listall")
    public String listAll(Model model)
    {
        List<Specification> list = this.specificationService.findAll();
        model.addAttribute("attlist",list);
        return "admin/product/specification/list";
    }


    @Autowired
    SpecificationService specificationService;

}
