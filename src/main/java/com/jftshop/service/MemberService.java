package com.jftshop.service;

import com.jftshop.entity.Member;

/**
 * Created by ThinkPad on 2018/1/31.
 */
public interface MemberService {

    public void save(Member member);

    public boolean usernameExists(String username);

    public Member findByUsername(String username);
}
