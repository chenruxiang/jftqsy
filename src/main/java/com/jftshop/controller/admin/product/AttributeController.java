package com.jftshop.controller.admin.product;

import com.jftshop.service.product.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("attributeController")
@RequestMapping({"/admin/attribute"})
public class AttributeController {

    private static final Logger LOG = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    AttributeService attributeService;


/*    @GetMapping("/listall")
    public String listAll(Model model)
    {
        List<Attribute> list = this.attributeService.findAll();
        Model
        return list;
    }*/





}
