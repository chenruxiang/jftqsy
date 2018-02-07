<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="addform" action="<%=path%>/admin/product_category/save" method="post">

    <span class="requiredField">*</span>名字
    <input type="text" id="name" name="name" required/>
    <br>

    上级目录ID
    <input type="text" id="parentid" name="parentid"/>
    <br>

    <input type="submit"  value="提交">

</form>


</body>
</html>


<script type="text/javascript">


    $().ready(function() {

        var $addform = $("#addform");
        var $name = $("#name");
        var $parentid = $("#parentid");
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
                        parentid: $parentid.val()
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
