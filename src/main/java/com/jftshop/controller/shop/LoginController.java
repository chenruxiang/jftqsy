package com.jftshop.controller.shop;

import com.jftshop.bean.Message;
import com.jftshop.controller.BaseController;
import com.jftshop.entity.Member;
import com.jftshop.entity.Principal;
import com.jftshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/6 0006.
 */

@Controller("shopLoginController")
@RequestMapping({"/login"})
public class LoginController extends BaseController {

    @PostMapping({"/submit"})
    @ResponseBody
    public Message submit(@RequestAttribute Map<String, String> pmap, HttpSession session) {

        String captcha = (String)session.getAttribute("captcha");
        if(!captcha.equals(pmap.get("captcha")))
            return Message.error("验证码错误", new Object[0]);
        Member member = this.memberService.findByUsername(pmap.get("username"));
        if(member == null){
            return Message.error("此账号不存在", new Object[0]);
        }else if(!pmap.get("password").equals(member.getPassword())){
            return Message.error("账号或密码错误", new Object[0]);
        }
        session.setAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME, new Principal(member.getId(), member.getUsername()));
        Message message = Message.success("shop.register.success", new Object[0]);
        return message;
    }

    @Autowired
    MemberService memberService;
}
