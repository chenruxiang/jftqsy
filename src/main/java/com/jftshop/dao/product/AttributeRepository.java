package com.jftshop.dao.product;

import com.jftshop.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ThinkPad on 2018/2/6.
 */

public interface AttributeRepository extends JpaRepository<Attribute, String>  {
}
