package com.jftshop.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by ThinkPad on 2018/1/26.
 */
public class RequestInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,String[]> map = request.getParameterMap();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        Iterator<String> item = map.keySet().iterator();
        String[] value = null;
        Object returnValue = null;

        while(item.hasNext()) {
            String key = item.next();
            value = map.get(key);
            if(null==value) {
                returnValue = "";
            }else if(value.length==1) {
                returnValue=value[0].toString().replaceAll("\\+",  " "); //处理空格;
            }else {//若是数组则封装成List
                List<String> list = new ArrayList<String>();
                for(String s:value) {
                    list.add(s);
                }
                returnValue = list;
            }
            key = key.replace("[]", "");
            //key = key.toUpperCase();
            paramMap.put(key, returnValue);
        }
        request.setAttribute("pmap",paramMap);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
