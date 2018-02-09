package com.jftshop.controller.admin.product;


import com.jftshop.bean.Message;
import com.jftshop.entity.Brand;
import com.jftshop.entity.ProductCategory;
import com.jftshop.service.product.BrandService;
import com.jftshop.util.JFTStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("brandController")
@RequestMapping({"/admin/brand"})
public class BrandController {

    private static final Logger LOG = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    BrandService brandService;


   @GetMapping("/listBrand")
    public String listAll(Model model) {
       List<Brand> list = this.brandService.findAll();
       model.addAttribute("abc",list);
       return "admin/product/brand/list";
    }

    @PostMapping({"/saveBrand"})
    @ResponseBody
    public Message submit(String name, String urls,String orders,
                          HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {

        Brand brand = new Brand();
        brand.setId( JFTStringUtils.get32UUID() );
        brand.setUrl( urls );
        brand.setName( name );
        brand.setOrders( orders );
        brandService.save( brand  );

        return Message.success("shop.SaveProductCategory.success", new Object[0]);

    }

}
