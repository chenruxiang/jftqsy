package com.jftshop.dao.product;

import com.jftshop.entity.Brand;
import com.jftshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, String> {

    @Query(value = "select  *  from Brand ",nativeQuery = true)
    List<Object[]> listBrand();
}
