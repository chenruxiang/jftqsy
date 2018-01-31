<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>


<form id="registerForm" action="<%=path%>/register/submit" method="post">
    <input type="text" id="username" name="username"/>
    <input type="password" id="password" name="password"/>
    <input type="password" name="rePassword"/>
    <input type="text" id="email" name="email"/>
    <input type="text" id="address" name="address"/>

    <input type="text" class="form-control" placeholder="输入验证码" required id="code" name="captchaCode" size="6">
    <img src="<%=path%>/captcha.jpg" width="65" height="24"/>

    <input type="submit" class="submit" value="提交">

</form>

</body>
</html>
