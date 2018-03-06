package com.jftshop.controller.shop;

import com.jftshop.bean.Message;
import com.jftshop.entity.Cart;
import com.jftshop.entity.Member;
import com.jftshop.entity.Product;
import com.jftshop.service.MemberService;
import com.jftshop.service.product.CartService;
import com.jftshop.service.product.ProductService;
import com.jftshop.util.JFTStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller("shopCartController")
@RequestMapping({"/cart"})
public class CartController {


    @PostMapping(value={"/add"})
    @ResponseBody
    public Message add(String id, Integer quantity, HttpServletRequest request, HttpServletResponse response)
    {
        if ((quantity == null) || (quantity.intValue() < 1))
            return Message.error("商品数量错误", new Object[0]);

        Product product = productService.getOne( id );

        if (product == null)
            return Message.warn("商品不存在", new Object[0]);

        //查找会员ID
        Member member = this.memberService.getCurrent();

        if (member == null)
            return Message.warn("会员不存在或未登录", new Object[0]);

        Cart cart = member.getCart();

        if ( cart == null ){
             cart = new Cart();
             cart.setId( JFTStringUtils.get32UUID() );
             cart.setMember( member );
            cartService.save( cart );
        }


        if (cart.contains(product)) {


        }



        return Message.success("success", new Object[0]);

    }

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Autowired
    MemberService memberService;


}
