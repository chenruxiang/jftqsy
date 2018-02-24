<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="addform" action="<%=path%>/admin/product/parameter/save" method="post">

    <span class="requiredField">*</span>绑定分类ID
    <input type="text" id="productcategoryid" name="productcategoryid" required/>
    <br>

    <span class="requiredField">*</span>名字
    <input type="text" id="name" name="name" required/>
    <br>

    <a href="javascript:void(0)" onclick="addPar()">增加参数</a><br><br>
    名称：<br>

    <input type="text" name="parameters[0].name">

    <div id ="pc">

    </div>

    <input type="submit" value="提交">

</form>


</body>
</html>


<script type="text/javascript">

   /* $().ready(function() {

        var $addform = $("#addform");
        var $name = $("#name");
        var $categoryid = $("#categoryid");
        var $submit = $(":submit");


        $addform.validate({
            rules: {
                name: {
                    required: true
                },
                categoryid: {
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
                        categoryid: $categoryid.val()
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
 */
    var num = 0;
    function addPar() {
        num = num + 1;
        $("#pc").append( '<input type="text" name="parameters['+num+'].name">'+"<br>")
    }
</script>
