package com.jftshop.dao.product;

import com.jftshop.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ThinkPad on 2018/2/6.
 */

public interface AttributeRepository extends JpaRepository<Attribute, String>  {

    //FETCH
    @Query("select a from Attribute a inner join FETCH  a.attributeoptions b where a.id = ?1 ")
    Attribute getById(String id);


}
