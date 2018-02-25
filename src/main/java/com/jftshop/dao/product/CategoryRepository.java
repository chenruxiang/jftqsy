package com.jftshop.dao.product;

import com.jftshop.entity.Attribute;
import com.jftshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findByName(String name);

    List<ProductCategory> findByParentIsNull();

    @Query(value = "select  *  from product_category ",nativeQuery = true)
    List<Object[]> listAll();


    @Query("select a from ProductCategory a inner join FETCH  a.attributes b inner join FETCH  b.attributeoptions c where a.id = ?1 ")
    ProductCategory getAttibuteByCategoryId(String id);

}
