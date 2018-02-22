package com.jftshop.dao.product;

import com.jftshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ThinkPad on 2018/2/22.
 */
public interface ProductRepository extends JpaRepository<Product, String> {
}
