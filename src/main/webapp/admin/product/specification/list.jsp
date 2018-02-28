<%@ page import="com.jftshop.entity.Specification" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.jftshop.entity.SpecificationValue" %><%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2018/2/22
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="<%=path%>/admin/product/specification/listall">刷新</a>
<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增规格','<%=path%>/admin/product/specification/add.jsp')">新增规格</a>

<%
  Iterator<Specification> iterator = ((List)request.getAttribute("spelist")).iterator();
  out.write("<br>");
  out.write("<br>");

  while (iterator.hasNext()){
      Specification specification = iterator.next();
      out.write(specification.getName()+"[" + specification.getMemo() + "]");
      out.write("&nbsp;&nbsp;&nbsp;类型：" + specification.getType() + "&nbsp;&nbsp;&nbsp;");
      Iterator<SpecificationValue> iterator2 = specification.getSpecificationValues().iterator();
      while (iterator2.hasNext()){
          out.write("&nbsp;");
          out.write(iterator2.next().getName());
      }
      out.write("<br>");
  }
%>

</body>
</html>
