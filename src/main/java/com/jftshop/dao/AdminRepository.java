package com.jftshop.dao;

import com.jftshop.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




/**
 * Created by ThinkPad on 2018/1/30.
 */

@Transactional
public interface AdminRepository extends JpaRepository<Admin, String> {

    List<Admin> findById(String id);

    List<Admin> findByUsername(String username);

    Page<Admin> findByUsernameLike(String username, Pageable pageable);

    List<Admin> findByUsernameOrEmailLike(String username, String email);
/*
    @Query(value="d")
    List<Admin> find123(String username);*/

}
