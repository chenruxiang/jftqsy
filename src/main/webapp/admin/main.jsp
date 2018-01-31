<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.jftshop.util.SpringUtils"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%
    String path = request.getContextPath();
    String base = request.getContextPath();
    ApplicationContext applicationContext = SpringUtils.getApplicationContext();

    if (applicationContext != null) {
%>

<shiro:authenticated>
    <%
        response.sendRedirect(base + "/admin/login.jsp");
    %>
</shiro:authenticated>

<%
    }
%>


<a href="#">商品</a>
<a href="#">订单</a>
<a href="#">会员</a>