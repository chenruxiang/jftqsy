package com.jftshop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/4/5.
 */
public class JftPayExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(JftPayExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //如果是业务异常类
        if (BizException.class.isAssignableFrom(ex.getClass())) {
            BizException bizException = (BizException) ex;

            try {
                //response.setContentType("text/text;charset=UTF-8");
                //JsonUtils.responseJson(response, bizException.getMsg());
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", bizException.getCode() + bizException.getMsg());//将错误信息传递给view
                return new ModelAndView("exception/exception",map);
            } catch (Exception e) {
                LOG.error("系统异常:", e);
            }
        }else{
            //其他未知错误
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "-1");//将错误信息传递给view
            return new ModelAndView("exception/exception",map);
        }
        return null;
    }
}
