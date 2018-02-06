<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="javascript:void(0)" onclick="refresh()">刷新</a>
<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增分类','<%=path%>/admin/product/parameter/add.jsp')">新增</a>



<div id ="draw"></div>



</body>
</html>

<script type="text/javascript">

$(function(){


});


function refresh(){

    $.get("<%=path%>/admin/product_parameter/listall",function(data,status){

        //alert(JSON.stringify(data));
        $("#draw").html("<br>");
        jQuery.each( data, function(index) {
            var id = data[index][0];
            var name = data[index][5];
            var parent = data[index][10];
            if ( parent == null  || parent == '') {
                $("#draw").append( "<br>" + name +"&nbsp;&nbsp;&nbsp;id:" +  id);
                iterator( data   , id );
            }
        });

    });

}


function iterator( data , parentid ) {
    jQuery.each( data, function(index) {
        var id = data[index][0];
       var parent = data[index][10];
        var name = data[index][5];
        if ( parent == parentid ){
            $("#draw").append( "<br>&nbsp&nbsp&nbsp"+ name +"&nbsp;&nbsp;&nbsp;id:" +  id);
        }
    });
}


</script>
