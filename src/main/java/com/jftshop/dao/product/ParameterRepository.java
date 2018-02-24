package com.jftshop.dao.product;

import com.jftshop.entity.Parameter;
import com.jftshop.entity.ParameterGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<ParameterGroup, String> {


}
