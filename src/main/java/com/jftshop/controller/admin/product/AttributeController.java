package com.jftshop.controller.admin.product;

import com.jftshop.entity.Attribute;
import com.jftshop.service.product.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("attributeController")
@RequestMapping({"/admin/attribute"})
public class AttributeController {

    private static final Logger LOG = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    AttributeService attributeService;


    @GetMapping("/listall")
    public String listAll(ModelMap model)
    {
        List<Attribute> list = this.attributeService.findAll();
       // model
        return list;
    }





}
