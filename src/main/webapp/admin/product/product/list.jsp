<%@ page import="com.jftshop.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="javascript:void(0)" onclick="window.parent.addTab('新增商品','<%=path%>/admin/product/add')">新增商品</a>

        <%
  Iterator<Product> iterator = ((List)request.getAttribute("productlist")).iterator();
  out.write("<br>");
  out.write("<br>");

  while (iterator.hasNext()){
      Product product = iterator.next();
      out.write(product.getName());
      out.write("<br>");
  }
%>



</body>
</html>

<script type="text/javascript">


</script>
