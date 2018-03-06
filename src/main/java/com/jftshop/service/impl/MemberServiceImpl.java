package com.jftshop.service.impl;

import com.jftshop.dao.MemberRepository;
import com.jftshop.entity.Member;
import com.jftshop.entity.Principal;
import com.jftshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
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
        return  list.size() == 0 ? null : list.get(0);
    }

    @Transactional(readOnly=true)
    public Member getCurrent()
    {
        RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
        if (localRequestAttributes != null)
        {
            HttpServletRequest localHttpServletRequest = ((ServletRequestAttributes)localRequestAttributes).getRequest();
            Principal localPrincipal = (Principal)localHttpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
            if (localPrincipal != null)
                return (Member)this.memberRepository.getOne(localPrincipal.getId());
        }
        return null;
    }





    @Autowired
    private MemberRepository memberRepository;

}
