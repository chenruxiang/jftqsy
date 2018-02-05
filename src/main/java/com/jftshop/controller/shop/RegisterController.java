package com.jftshop.controller.shop;

import com.jftshop.bean.Message;
import com.jftshop.controller.BaseController;
import com.jftshop.entity.Member;
import com.jftshop.service.MemberService;
import com.jftshop.util.JFTBeanUtils;
import com.jftshop.util.JFTStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by ThinkPad on 2018/1/31.
 */

@Controller("shopRegisterController")
@RequestMapping({"/register"})
public class RegisterController extends BaseController {

    @PostMapping({"/submit"})
    @ResponseBody
    public Message submit(Member member , String captcha, String username, String email, String password,
                          HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {

        if (!validator(Member.class, "username", username ))
         return Message.error("shop.common.invalid", new Object[0]);

        if (!validator(Member.class, "password", password))
         return Message.error("shop.common.invalid", new Object[0]);

        if (!validator(Member.class, "email", email))
         return Message.error("shop.common.invalid", new Object[0]);

        if ( !memberService.usernameExists( username ) )
            return Message.error("shop.register.disabledExist", new Object[0]);

        Member localMember = new Member();
        JFTBeanUtils.copyProperties( localMember , member  );
        localMember.setId( JFTStringUtils.get32UUID() );

        memberService.save( localMember );

        Message message =  Message.success("shop.register.success", new Object[0]);

        return message;
     }

    @Autowired
    MemberService memberService;

}
