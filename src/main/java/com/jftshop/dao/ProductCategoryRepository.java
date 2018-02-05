package com.jftshop.dao;

import com.jftshop.entity.Member;
import com.jftshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findByName(String name);

    List<ProductCategory> findByParentIsNull();

}
