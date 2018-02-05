package com.jftshop.dao;

import com.jftshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findByName(String name);

    List<ProductCategory> findByParentIsNull();

    @Query(value = "select  *  from product_category ",nativeQuery = true)
    List<Object[]> listAll();

}
