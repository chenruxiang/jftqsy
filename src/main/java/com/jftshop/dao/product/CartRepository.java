package com.jftshop.dao.product;

import com.jftshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ThinkPad on 2018/3/6.
 */

public interface CartRepository extends JpaRepository<Cart, String> {

}
