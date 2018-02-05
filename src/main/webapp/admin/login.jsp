<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/12
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>金富通小店</title>

    <link href="<%=path%>/common/css/bootstrap.min.css" rel="stylesheet">
</head>

<style>
    html {
        height: 100%;
        width: 100%;
        /*图片固定*/
        background-size: cover;
        background: url(<%=path%>/common/images/background.png) no-repeat fixed center;
    }

    body {
        background: transparent;
        padding: 40px 0;
    }

    h1 {
        margin-bottom: 50px;
        margin-top: 80px;
    }

    .form-signin {
        max-width: 460px;
        padding: 25px 50px;
        margin: 0 auto;
        color: #5e5e5e;
        background: rgba(255, 255, 255, 0.5);
        -moz-border-radius: 1em; /*火狐*/
        -webkit-border-radius: 1em; /*谷歌*/
        border-radius: 1em;
    }

    .loginN {
        padding: 0;
        margin-left: 4px;
        line-height: 16px;
    }
</style>

<h1 style="text-align: center;color: white">金富通小店</h1>
<div class="form-signin">

    <!--<p id="iTip" style="text-align: center;color: red;"></p>-->

    <h3 class="text-center">请登录</h3>
    <form id="form1" action="${pageContext.request.contextPath}/admin/login.jsp" method="post" class=" form-horizontal" role="form">
        <div class="form-group">
            <label for="loginName" class="loginN">账户：</label>
            <input type="text" name="loginName" class="form-control" id="loginName" required placeholder="输入账户">
        </div>
        <p id="log_err" class="iTip" style="padding: 0;text-align: left;margin: 0;margin-top: -10px;margin-left: -14px; color: red;"></p>

        <div class="form-group">
            <label for="pwd" class="loginN">密码：</label>
            <input type="password" name="pwd" class="form-control" id="pwd" required placeholder="输入密码">
        </div>

        <div class="row" style="padding: 0;margin: 0;">
            <div class="col-xs-6" style="padding: 0;margin: 0;"><p id="pwd_err" class="iTip" style="padding: 0;margin: 0;margin-top: -10px;margin-left: -14px;color: red;"></p></div>
            <%--<div class="col-xs-6" style="padding: 0;margin: 0;"><p style="padding: 0;margin: 0;text-align: right;margin-top: -10px;">
                <a>忘记密码</a>
            </p></div>--%>
        </div>


        <div class="form-group">
            <label for="code" class="loginN">验证码：</label>
            <div class="row">
                <div class="col-xs-9">
                    <input type="text" class="form-control" placeholder="输入验证码" required id="code" name="captchaCode" size="6">
                </div>
                <div class="col-xs-3" style="padding-top: 4px;">
                    <img src="${pageContext.request.contextPath}/captcha.jpg" width="65" height="24"/>
                </div>
            </div>
        </div>
        <p id="code_err" class="iTip" style="padding: 0;text-align: left;margin: 0;margin-top: -10px;margin-left: -14px; color: red;"></p>

        <input class="btn btn-lg btn-primary btn-block" name="sub" type="submit" value="登录"/>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    $(function(){
        var message = "${message}";
        var code = "${code}";
        if(message != "" && code != ""){
            var log_err = $("#log_err");
            var pwd_err = $("#pwd_err");
            var code_err = $("#code_err");
            if(code == "001"){
                log_err.html(message);
            }else if(code == "002"){
                pwd_err.html(message);
            }else if(code == "003"){
                code_err.html(message);
            }else if(code == "004"){
                code_err.html(message);
            }
        }
    });
</script>

