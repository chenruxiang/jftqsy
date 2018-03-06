package com.jftshop.service.product.impl;

import com.jftshop.dao.product.CartRepository;
import com.jftshop.entity.Cart;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2018/3/6.
 */

@Service("cartService")
public class CartServiceImpl extends BaseServiceImpl<Cart,String> implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    public void setBaseDao(CartRepository cartRepository)
    {
        super.setBaseDao(cartRepository);
    }


}
