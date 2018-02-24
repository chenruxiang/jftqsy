<%@ page import="com.jftshop.entity.ParameterGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.jftshop.entity.Parameter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="<%=path%>/admin/product/parameter/listall">刷新</a>
<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增参数','<%=path%>/admin/product/parameter/add.jsp')">新增参数</a>

<%
  Iterator<ParameterGroup> iterator = ((List)request.getAttribute("parlist")).iterator();
  out.write("<br>");
  out.write("<br>");

  while (iterator.hasNext()){
      ParameterGroup parameterGroup = iterator.next();
      out.write(parameterGroup.getName()+"<br>");
   //   out.write("<br>");
      Iterator<Parameter> iterator2 = parameterGroup.getParameters().iterator();
      while (iterator2.hasNext()){
          out.write("&nbsp;&nbsp;&nbsp;");
          out.write(iterator2.next().getName() +"<br>");
      }
      out.write("<br>");
  }
%>

</body>
</html>
