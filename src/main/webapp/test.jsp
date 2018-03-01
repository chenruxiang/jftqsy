<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">

    .hidden {
        display:none;
    }

</style>
<body>

<a href="javascript:;" id="viewa" class="button">显示</a>
<p id="dla" class="hidden">这是一个段落。</p>
ssdddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
</body>
</html>


<script>

    $("#viewa").click(function(){
        alert("a");
        $("#dla").show();
    });

</script>