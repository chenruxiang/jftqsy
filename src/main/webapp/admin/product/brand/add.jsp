<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="addform" action="<%=path%>/admin/brand/saveBrand" method="post">

    <span class="requiredField">*</span>名字
    <input type="text" id="name" name="name" required/>
    <br>

    连接
    <input type="text" id="urls" name="urls"/>
    <br>
    排序
    <input type="text" id="orders" name="orders"/>
    <br>

    <input type="submit"  value="提交">

</form>


</body>
</html>


<script type="text/javascript">


    $().ready(function() {

        var $addform = $("#addform");
        var $name = $("#name");
        var $urls = $("#urls");
        var $orders = $("#orders");
        var $submit = $(":submit");


        $addform.validate({
            rules: {
                name: {
                    required: true
                }
            },
            messages: {
                name: {
                    pattern: "name"
                }
            },

            submitHandler: function(form) {
                $.ajax({
                    url: $addform.attr("action"),
                    type: "post",
                    data: {
                        name: $name.val(),
                        urls: $urls.val(),
                        orders: $orders.val()
                    },
                    dataType: "json",
                    cache: false,
                    beforeSend: function() {
                        $submit.prop("disabled", true);
                    },
                    success:submit_success
                });
            }
        });


        var submit_success = function(message) {
            alert(message.content);
            if (message.type == "success") {
                $submit.prop("disabled", false);
            } else {
                $submit.prop("disabled", false);
            }
        }

    });
</script>
