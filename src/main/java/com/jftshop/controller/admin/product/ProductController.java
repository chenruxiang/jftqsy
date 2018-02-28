package com.jftshop.controller.admin.product;

import com.jftshop.entity.*;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ProductService;
import com.jftshop.service.product.SpecificationService;
import com.jftshop.util.JFTStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

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

    @GetMapping("/add")
    public String add(Model model)
    {
        model.addAttribute("specifications", this.specificationService.findAll());
        return "admin/product/product/add";
    }


    @PostMapping("/save")
    public String save(Product product , String productcategoryid , Long[] specificationIds , HttpServletRequest request) {

        Product product1 = product;

        //校验上传的图片
        Iterator<ProductImage> productimages = product.getProductimages().iterator();
        while ( productimages.hasNext() )
        {
            ProductImage productimage = productimages.next();
            if ((productimage == null) )
            {
                productimages.remove();
            }
            this.productService.build(productimage);
             //设置主图
            product.setImage(productimage.getThumbnail());
        }


        //设置产品目录
        product.setProductcategory(   categoryService.getOne( productcategoryid ) ) ;

        product.setFullname(null);
        product.setAllocatedstock( Integer.valueOf(0) );
        product.setScore( Float.valueOf(0.0F) );
        product.setHits(Long.valueOf(0L));
        product.setSales(Long.valueOf(0L));


        ProductCategory productCategory = product.getProductcategory();


        //产品参数处理
        Iterator<ParameterGroup> parametergroups = productCategory.getParametergroups().iterator();
        while ( parametergroups.hasNext() )
        {
            ParameterGroup parametergroup = parametergroups.next();
            Iterator<Parameter> parameters = parametergroup.getParameters().iterator();

            while (parameters.hasNext())
            {
                Parameter parameter = parameters.next();
                String pv = request.getParameter("parameter_" + ((Parameter)parameter).getId());
                if ( StringUtils.isNotEmpty(pv) ) {
                    ProductParameter pp = new ProductParameter();
                    pp.setId(JFTStringUtils.get32UUID() );
                    pp.setParametervaluekey( parametergroup.getName() );
                    pp.setParametervalue( pv );
                    product.getProductparameters().add(pp);
                }
            }
        }

        //产品属性处理
        Iterator<Attribute> attributes = productCategory.getAttributes().iterator();
        while ( attributes.hasNext() ) {
            Attribute attribute = attributes.next();
            Iterator<AttributeOption> attributeoptions = attribute.getAttributeoptions().iterator();
            while (attributeoptions.hasNext())
            {
                AttributeOption attributeoption = attributeoptions.next();
                String aps = request.getParameter("attributeoption_" + attributeoption.getId());
                if ( StringUtils.isNotEmpty(aps) ) {
                    ProductAttribute ap = new ProductAttribute();
                    ap.setId(JFTStringUtils.get32UUID() );
                    ap.setAttributevalue(aps);
                    ap.setAttributevaluekey(attribute.getName());
                    product.getProductattributes().add(ap);
                }
            }
        }





        return "";
    }


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SpecificationService specificationService;

}
