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
import java.math.BigDecimal;
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
    public String save(Product product , String productcategoryid , String[] specificationIds , HttpServletRequest request) {

        //查询产品目录
        ProductCategory productCategory = categoryService.getOne( productcategoryid );
        //设置产品目录
        product.setProductcategory(  productCategory ) ;

        Specification specification = specificationService.getOne("d5d942adb0534ab48b5b0e559ab0695a");
        List<SpecificationValue> list = specification.getSpecificationValues();

        Specification specification2 = specificationService.getOne("da829783c94d44f396ccb3646d6affba");
        List<SpecificationValue> list2 = specification2.getSpecificationValues();

        //校验上传的图片
        Iterator<ProductImage> productimages = product.getProductimages().iterator();
        while ( productimages.hasNext() )
        {
            ProductImage productimage = productimages.next();
            if ( productimage == null )
            {
                productimages.remove();
            }else{
                this.productService.build( productimage );
                productimage.setId( JFTStringUtils.get32UUID() );
                productimage.setProduct( product );
                //设置主图
                product.setImage(productimage.getThumbnail());
            }
        }


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
                    pp.setProduct( product );
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
                String aps = request.getParameter("attribute_" + attributeoption.getId());
                if ( StringUtils.isNotEmpty(aps) ) {
                    ProductAttribute ap = new ProductAttribute();
                    ap.setId(JFTStringUtils.get32UUID() );
                    ap.setAttributevalue(aps);
                    ap.setAttributevaluekey(attribute.getName());
                    ap.setProduct( product );
                    product.getProductattributes().add(ap);
                }
            }
        }


        product.setId(JFTStringUtils.get32UUID());
        product.setIntroduction("hello");
        product.setIsgift(true);
        product.setIslist(true);
        product.setIsmarketable(true);
        product.setIstop(true);
        product.setName("hello");
        product.setPrice(new BigDecimal(100));



        ProductSpecification productspecification = new ProductSpecification();
        productspecification.setId(JFTStringUtils.get32UUID());
        productspecification.setName( specification.getName() );
        productspecification.setType(ProductSpecification.Type.text);

        Iterator<SpecificationValue> iterator = list.iterator();
        while ( iterator.hasNext() ){
            SpecificationValue specificationvalue = iterator.next();

            ProductSpecificationValue productspecificationvalue = new ProductSpecificationValue();
            productspecificationvalue.setId(JFTStringUtils.get32UUID());
            productspecificationvalue.setName( specificationvalue.getName() );
            productspecification.getProductspecificationvalues().add( productspecificationvalue );
            productspecificationvalue.setProductspecification( productspecification );
        }

        product.getProductspecifications().add( productspecification );
        productspecification.setProduct( product );

        ProductSpecification productspecification2 = new ProductSpecification();
        productspecification2.setId(JFTStringUtils.get32UUID());
        productspecification2.setName( specification2.getName() );
        productspecification2.setType(ProductSpecification.Type.text);

        Iterator<SpecificationValue> iterator2 = list2.iterator();
        while ( iterator2.hasNext() ){
            SpecificationValue specificationvalue = iterator2.next();

            ProductSpecificationValue productspecificationvalue = new ProductSpecificationValue();
            productspecificationvalue.setId(JFTStringUtils.get32UUID());
            productspecificationvalue.setName( specificationvalue.getName() );
            productspecification2.getProductspecificationvalues().add( productspecificationvalue );
            productspecificationvalue.setProductspecification( productspecification2 );
        }

        product.getProductspecifications().add( productspecification2 );
        productspecification2.setProduct( product );


        int size = product.getProductspecifications().size();

        if (size>0 && size==1){
            List<ProductSpecificationValue> list7 = product.getProductspecifications().get(0).getProductspecificationvalues();
            if ( list7.size() > 0 ){
                for (int i = 0 ; i < list7.size() ; i ++){
                    ProductSpecificationValue productspecificationvalue =  list7.get(i);
                    ProductSku productsku = new ProductSku();
                    productsku.setId(JFTStringUtils.get32UUID());
                    productsku.setProductspecificationvalueid1( productspecificationvalue.getId() );
                    product.getProductskus().add( productsku );
                    productsku.setProduct( product );
                }
            }
        }else{
            List<ProductSpecificationValue> list7 = product.getProductspecifications().get(0).getProductspecificationvalues();
            List<ProductSpecificationValue> list8 = product.getProductspecifications().get(1).getProductspecificationvalues();
            if ( list7.size() > 0 ){
                for ( int i = 0 ; i < list7.size() ; i ++ ){
                    ProductSpecificationValue productspecificationvalue =  list7.get(i);

                    for ( int j = 0 ; j < list8.size() ; j ++ ){
                        ProductSpecificationValue productspecificationvalue2 =  list8.get(j);
                        ProductSku productsku = new ProductSku();
                        productsku.setId(JFTStringUtils.get32UUID());
                        productsku.setProductspecificationvalueid1( productspecificationvalue.getId() );
                        productsku.setProductspecificationvalueid2( productspecificationvalue2.getId() );
                        product.getProductskus().add( productsku );
                        productsku.setProduct( product );
                    }
                }
            }
        }

        product.setProductcategory( productCategory );

        return "";
    }


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SpecificationService specificationService;

}
