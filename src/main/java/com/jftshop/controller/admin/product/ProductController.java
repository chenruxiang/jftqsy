package com.jftshop.controller.admin.product;

import com.jftshop.entity.Product;
import com.jftshop.entity.ProductImage;
import com.jftshop.service.product.CategoryService;
import com.jftshop.service.product.ProductService;
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




    @PostMapping("/save")
    public String save(Product product , String productcategoryid) {

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
        }


        //设置产品目录
        product.setProductcategory(   categoryService.getOne( productcategoryid ) ) ;

        product.setFullname(null);
        product.setAllocatedstock( Integer.valueOf(0) );
        product.setScore( Float.valueOf(0.0F) );
        product.setHits(Long.valueOf(0L));
        product.setSales(Long.valueOf(0L));




        //开始检查图片
        //Iterator<ProductImage> productimages = product.getProductimages().iterator();
        while ( productimages.hasNext() )
        {
            ProductImage productimage = productimages.next();
            //this.productImageService.build(productimage);
        }


        return "";
    }


    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

}
