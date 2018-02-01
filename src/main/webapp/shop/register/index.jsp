<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>


<script type="text/javascript">
    $().ready(function() {

    var $registerForm = $("#registerForm");
    var $username = $("#username");
    var $password = $("#password");
    var rePassword = $("#rePassword");
    var $captcha = $("#captcha");
    var $email = $("#email");
    var $submit = $(":submit");

    $registerForm.validate({
        rules: {
            username: {
                required: true,
                pattern: /^[0-9a-z_A-Z\u4e00-\u9fa5]+$/,
                minlength: 6
            },
            password: {
                required: true,
                pattern: /^[^\s&\"<>]+$/,
                minlength: 6
            },
            rePassword: {
                required: true,
                equalTo: "#password"
            },
            email: {
                required: true,
                email: true
            },
            captcha: "required"
        },
        messages: {
            username: {
                pattern: "username1"
            },
            password: {
                pattern: "password1"
            }
        },
        submitHandler: function(form) {
            $.ajax({
                url: $registerForm.attr("action"),
                type: "POST",
                data: {
                    username: $username.val(),
                    password: $password.val(),
                    email: $email.val(),
                    captcha: $captcha.val()
                },
                dataType: "json",
                cache: false,
                beforeSend: function() {
                    $submit.prop("disabled", true);
                },
                success:submit_success(message)
             });
        }
    });


     var submit_success = function(message) {
        $.message(message);
        if (message.type == "success") {
            window.setTimeout(function() {
                $submit.prop("disabled", false);
                location.href = "<%=path%>/";
            }, 3000);
        } else {
            $submit.prop("disabled", false);
            alert(message.content);
        }
    }

    });
</script>

<form id="registerForm" action="<%=path%>/register/submit" method="post">

    <span class="requiredField">*</span>账户
    <input type="text" id="username" name="username" required/>
    <br>

    <span class="requiredField">*</span>密码
    <input type="password" id="password" name="password" required/>
    <br>

    <span class="requiredField">*</span>确认密码
    <input type="password" name="rePassword" required/>
    <br>

    <span class="requiredField">*</span>电子邮件
    <input type="text" id="email" name="email" required/>
    <br>

    地址
    <input type="text" id="address" name="address"/>
    <br>

    <span class="requiredField">*</span>校验码
    <input type="text" placeholder="输入验证码"  id="captcha" name="captcha"  required>
    <img src="<%=path%>/captcha.jpg" width="65" height="24"/>
    <br>

    <input type="submit" class="submit" value="提交">

</form>

</body>
</html>
