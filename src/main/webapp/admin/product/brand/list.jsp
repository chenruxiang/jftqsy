<%@ page import="com.jftshop.entity.Brand" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>




<p><a href="<%=path%>/admin/brand/listBrand" >刷新</a>

<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增分类','<%=path%>/admin/product/brand/add.jsp')">新增</a>
<%
    out.write( "<br>");
            Iterator<Brand> uuu =   ((List) request.getAttribute("abc")) .iterator();

            while (uuu.hasNext()){
                Brand brand =  uuu.next();
                        out.write( brand.getName() +"<br>");
                        out.write( brand.getUrl() +"<br>");
            }


%>

<div id ="draw"></div>



</body>
</html>

<script type="text/javascript">

$(function(){


});


/*function refresh(){


        //alert(JSON.stringify(data));
        $("#draw").html("<br>");
        jQuery.each( data, function(index) {
            var id = data[index][0];
            var name = data[index][5];
            var urls = data[index][10];
            if ( urls == null  || urls == '') {
                $("#draw").append( "<br>" + name +"&nbsp;&nbsp;&nbsp;id:" +  id);
                iterator( data   , id );
            }
        });
    });

}


function iterator( data , parentid ) {
    jQuery.each( data, function(index) {
        var id = data[index][0];
        var urls = data[index][10];
        var name = data[index][5];
        if ( urls == parentid ){
            $("#draw").append( "<br>&nbsp&nbsp&nbsp"+ name +"&nbsp;&nbsp;&nbsp;id:" +  id);
        }
    });
}*/


</script>
