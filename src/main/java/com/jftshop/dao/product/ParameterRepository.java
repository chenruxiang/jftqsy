package com.jftshop.dao.product;

import com.jftshop.entity.ProductParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<ProductParameter, String> {


}
