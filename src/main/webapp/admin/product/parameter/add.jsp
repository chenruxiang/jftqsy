<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="addform" action="<%=path%>/admin/product_parameter/save" method="post">

    <span class="requiredField">*</span>名字
    <input type="text" id="name" name="name" required/>
    <br>

    <span class="requiredField">*</span>绑定分类ID
    <input type="text" id="categoryid" name="categoryid" required/>
    <br>

    <span class="requiredField">*</span>参数内容
    <input type="text" id="contents" name="contents" required/>
    <br>

    <input type="submit" value="提交">

</form>


</body>
</html>


<script type="text/javascript">


    $().ready(function() {

        var $addform = $("#addform");
        var $name = $("#name");
        var $categoryid = $("#categoryid");
        var $contents = $("#contents");
        var $submit = $(":submit");


        $addform.validate({
            rules: {
                name: {
                    required: true
                },
                categoryid: {
                    required: true
                },
                contents: {
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
                        categoryid: $categoryid.val(),
                        contents:$contents.val()
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
