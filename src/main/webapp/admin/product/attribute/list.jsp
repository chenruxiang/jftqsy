<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<%@ page import="com.jftshop.entity.Attribute" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="<%=path%>/admin/product/attribute/listall">刷新</a>
<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增属性','<%=path%>/admin/product/attribute/add.jsp')">新增属性</a>

<%


    Iterator<Attribute> iterator = ( (List)request.getAttribute("attlist") ).iterator();

    out.write("<br>");
    out.write("<br>");

    while (iterator.hasNext()){
        Attribute attribute = iterator.next();
        out.write(attribute.getName()+"<br>");
        out.write(attribute.getAttributeoptions().size()+"<br>");
        out.write("<br>");
    }



%>

</body>
</html>
