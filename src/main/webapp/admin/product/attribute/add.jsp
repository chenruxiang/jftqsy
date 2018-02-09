<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="addform" action="<%=path%>/admin/product/attribute/save" method="post">

    目录ID
    <input type="text" id="productcategoryid" name="productcategoryid"/>
    <br>

    <span class="requiredField">*</span>名字
    <input type="text" id="name" name="name" required/>
    <br>

    <a href="javascript:void(0)" onclick="addAtt()">新增</a><br>

    <input type="text" name="attributeoptions[0].options">

    <div id ="pc">


    </div>

    <input type="submit"  value="提交">

</form>

</body>
</html>

<script>

    $(function(){


    });

    var num = 1;

    function addAtt(){

        num = num + 1;


        $("#pc").append( '<input type="text" name="attributeoptions['+num+'].options">'+"<br>")
    }

</script>
