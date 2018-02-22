package com.jftshop.dao.product;

import com.jftshop.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ThinkPad on 2018/2/22.
 */
public interface SpecificationRepository extends JpaRepository<Specification, String> {
}
