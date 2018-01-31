package com.jftshop.service;

import com.jftshop.entity.Admin;

/**
 * Created by ThinkPad on 2018/1/31.
 */
public interface AdminService {

    public void save(Admin admin);

    public boolean usernameExists(String username);

    public Admin findByUsername(String username);
}
