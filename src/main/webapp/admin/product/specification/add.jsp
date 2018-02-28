<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/22
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>
<form id="addform" action="<%=path%>/admin/product/specification/save" method="post" enctype="multipart/form-data">

    <span class="requiredField">*</span>名称
    <input type="text" id="name" name="name" required/>
    <br>
    <select id="type" name="type">
        <option value="text">文本</option>
        <option value="image">图片</option>
    </select><br>
    备注<input type="text" id="memo" name="memo"/><br>

    <a href="javascript:void(0)" onclick="addPar()">增加规格值</a><br><br>
    规格值名称 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;规格值图片<br>

    <input type="text" style="width:100px;" name="specificationValues[0].name">&nbsp;&nbsp;
    <input type="text" id="image" name="specificationValues[0].image">
    <input type="file" name="file" id="file" multiple="multiple">
    <div id ="pc">

    </div>

    <input type="submit" value="提交">

</form>

</body>
</html>


<script type="text/javascript">

    var num = 0;
    function addPar() {
        num = num + 1;
        $("#pc").append( '<input type="text" style="width:100px;" name="specificationValues['+num+'].name">&nbsp;&nbsp;&nbsp;');
        $("#pc").append( '<input type="text" name="specificationValues['+num+'].image">&nbsp;');
        $("#pc").append( '<input type="file" name="file">')
    }

   /* function fileChange(num) {
        alert(num);
    }

    $("#file0").change(function(){
        $("#image").val("123");
    });*/
</script>
