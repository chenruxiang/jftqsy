<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="com.jftshop.util.SpringUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
jjj
<%
    String base = request.getContextPath();
    ApplicationContext applicationContext = SpringUtils.getApplicationContext();
    if (applicationContext != null) {
%>
<shiro:authenticated>
    <%="ok"%>
</shiro:authenticated>

<shiro:notAuthenticated>
    <%="false"%>
</shiro:notAuthenticated>
<%
    }
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/admin/login.jsp" method="post">
    账户：<input type="text" id="username" name="loginName"  /><br>
    密码：<input type="password" name="pwd"  /><br>
    验证码：<input id="code" name="captchaCode" size="6" /><img src="${pageContext.request.contextPath}/captcha.jpg"  width="65" height="24" /><br>
    ${message }<br>
    <input  type="submit" value="登录" /><br>
</form>

</body>
</html>
