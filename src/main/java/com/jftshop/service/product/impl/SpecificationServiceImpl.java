package com.jftshop.service.product.impl;

import com.jftshop.dao.product.SpecificationRepository;
import com.jftshop.entity.Specification;
import com.jftshop.service.impl.BaseServiceImpl;
import com.jftshop.service.product.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Service("specificationService")
public class SpecificationServiceImpl extends BaseServiceImpl<Specification,String>
        implements SpecificationService {

    @Autowired
    SpecificationRepository specificationRepository;

    @Autowired
    public void setBaseDao(SpecificationRepository specificationRepository)
    {
        super.setBaseDao(specificationRepository);
    }


}
