package com.jftshop.dao.product;

import com.jftshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<ProductCategory, String> {


}
