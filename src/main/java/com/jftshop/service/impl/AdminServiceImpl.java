package com.jftshop.service.impl;

import com.jftshop.dao.AdminRepository;
import com.jftshop.entity.Admin;
import com.jftshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ThinkPad on 2018/1/31.
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Transactional
    public void save(Admin admin)
    {
        adminRepository.save(admin);
    }


    //
    @Transactional(readOnly=true)
    public boolean usernameExists(String username)
    {
        return  adminRepository.findByUsername(username).size() == 0 ? true : false ;
    }

    @Transactional(readOnly=true)
    public Admin findByUsername(String username)
    {
        List<Admin> list =  adminRepository.findByUsername( username );
        return  list == null ? null : list.get(0);
    }


    @Autowired
    private AdminRepository adminRepository;

}
