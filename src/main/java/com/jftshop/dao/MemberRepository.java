package com.jftshop.dao;

import com.jftshop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by ThinkPad on 2018/1/30.
 */

public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findByUsername(String username);

/*
    @Query(value="d")
    List<Admin> find123(String username);*/

}
