<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<%@ page import="com.jftshop.entity.Product" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>

<a href="<%=path%>">返回</a>

<%

    Object object = request.getAttribute("products");

    if ( object != null ){

        Iterator<Product> iterator = ((Set)object).iterator();
        out.write("<br>");

        while (iterator.hasNext()){
            Product product = iterator.next();
            String pi = product.getImage().replace("d:/upload/","");
            out.write("<a href='"+path+"/shop/product/product/"+product.getId()+"'>");
            out.write("<img src='/productimg/"+pi+"' width='170' height='170'>");
            out.write("</a>");
            out.write("￥");
            out.write(product.getPrice().toString());
            out.write("<br>");
            out.write(product.getName());
            //out.write("</a>");
            out.write("<br>");
        }

    }else{

        out.write("没有商品");
    }

%>