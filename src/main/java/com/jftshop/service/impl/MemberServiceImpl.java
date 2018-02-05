package com.jftshop.service.impl;

import com.jftshop.dao.MemberRepository;
import com.jftshop.entity.Member;
import com.jftshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ThinkPad on 2018/1/31.
 */

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Transactional
    public void save(Member member)
    {
        memberRepository.save(member);
    }

    @Transactional(readOnly=true)
    public boolean usernameExists(String username)
    {
        return  memberRepository.findByUsername(username).size() == 0 ? true : false ;
    }

    @Transactional(readOnly=true)
    public Member findByUsername(String username)
    {
        List<Member> list =  memberRepository.findByUsername( username );
        return  list == null ? null : list.get(0);
    }

    @Autowired
    private MemberRepository memberRepository;

}
