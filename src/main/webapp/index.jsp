<%@ page import="com.jftshop.entity.ProductCategory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>


<a href="<%=path%>/shop/register/index.jsp">注册</a>

<br>
<br>

产品目录
<br>
-----------------------------------------------
<%
    Iterator<ProductCategory> iterator = ((List)request.getAttribute("productcategorylist")).iterator();
    out.write("<br>");


    while (iterator.hasNext()){
        ProductCategory productcategory = iterator.next();
        out.write("<a href='"+path+"/shop/product/listinproductcategory/"+productcategory.getId()+"'>");
        out.write(productcategory.getName());
        out.write("</a>");
        out.write("<br>");
    }

%>






