package com.jftshop.dao.product;

import com.jftshop.entity.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ThinkPad on 2018/3/6.
 */
public interface ProductSkuRepository extends JpaRepository<ProductSku, String> {

    //查询库存规格
    @Query(value = "select  a  from ProductSku a where a.productspecificationvalueid1=?1 and  a.productspecificationvalueid2=?2 ")
    List<ProductSku> findByP1P2( String p1, String p2);
}
