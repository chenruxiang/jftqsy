<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<%@ page import="com.jftshop.entity.Product" %>
<%@ page import="com.jftshop.entity.ProductSpecification" %>
<%@ page import="com.jftshop.entity.ProductSpecificationValue" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>

<!-- datatable导数-->
<link rel="stylesheet" href="<%=path%>/common/css/product.css">


<a href="<%=path%>">返回</a>

<div class="productContent">

<%

    Object object = request.getAttribute("product");

    if ( object != null ){

        Product product = (Product)object;
        String pi = product.getImage().replace("d:/upload/","");
        out.write("<img src='/productimg/"+pi+"' width='170' height='170'>");
        out.write("<br>");
        out.write("价格&nbsp;&nbsp;￥");
        out.write(product.getPrice().toString());
        out.write("<br>");
        out.write("商品名字：&nbsp;&nbsp;");
        out.write(product.getName());
        out.write("<br>规格---------------------------<br>");
        Iterator<ProductSpecification> iterator = product.getProductspecifications().iterator();

        %>
    <div class="action">
        <div id="specification" class="specification clearfix">
            <div class="title" style="display: none;">请选择商品规格</div>
    <%
        while (iterator.hasNext()){
            ProductSpecification productspecification = iterator.next();
            out.write("<dt><span>");
            out.write(productspecification.getName());
            out.write(":</span></dt>");
            Iterator<ProductSpecificationValue> iterator2  = productspecification.getProductspecificationvalues().iterator();
            while (iterator2.hasNext()){
                ProductSpecificationValue productspecificationvalue = iterator2.next();

                out.write("<a href='javascript:;' class='text'>");
                out.write(productspecificationvalue.getName());
                out.write("</a>");
            }
            out.write("<br>");
        }

        //out.write("</a>");
        out.write("<br>");



    }else{

        out.write("没有商品");
    }

%>

            </div>

    <dl class="quantity">
        <dt>购买数量:</dt>
        <dd>
            <input type="text" id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;">
            <div>
                <span id="increase" class="increase">&nbsp;</span>
                <span id="decrease" class="decrease">&nbsp;</span>
            </div>
        </dd>
        <dd>
            件
        </dd>
    </dl>


</div>

加入购物车

<script type="text/javascript">
    $().ready(function() {

        var $quantity = $("#quantity");

    });

</script>