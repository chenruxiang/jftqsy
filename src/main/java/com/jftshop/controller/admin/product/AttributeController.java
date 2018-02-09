package com.jftshop.controller.admin.product;

import com.jftshop.entity.Attribute;
import com.jftshop.entity.AttributeOption;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.AttributeService;
import com.jftshop.service.product.CategoryService;
import com.jftshop.util.JFTStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller("attributeController")
@RequestMapping({"/admin/product/attribute"})
public class AttributeController {

    private static final Logger LOG = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    AttributeService attributeService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/listall")
    public String listAll(Model model)
    {
        List<Attribute> list = this.attributeService.findAll();
        model.addAttribute("attlist",list);
        return "admin/product/attribute/list";
    }

    @PostMapping("/save")
    public String save(Attribute attribute , String productcategoryid)
    {
        List<AttributeOption> attributeOptions =  attribute.getAttributeoptions();
        LOG.debug( "AttributeOption.size={}",attributeOptions.size());

        Iterator<AttributeOption> iterator =attributeOptions.iterator();
        while (iterator.hasNext()){
            AttributeOption attributeOption = iterator.next();
            if ( (attributeOption == null) || (attributeOption.getOptions() == null) ){
                iterator.remove();
            }else{
                attributeOption.setId( JFTStringUtils.get32UUID() );
            }
        }

        LOG.debug( "json={}",attribute.toJson());

        attribute.setId(JFTStringUtils.get32UUID());

        ProductCategory productCategory = categoryService.getOne( productcategoryid );

        attribute.setProductcategory( productCategory );

        attributeService.save( attribute );

        return "admin/product/attribute/add";
    }



}
