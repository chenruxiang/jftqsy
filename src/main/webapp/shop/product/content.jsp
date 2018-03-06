<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<%@ page import="com.jftshop.entity.Product" %>
<%@ page import="com.jftshop.entity.ProductSpecification" %>
<%@ page import="com.jftshop.entity.ProductSpecificationValue" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>

<a href="<%=path%>">返回</a>

<br>



<%

    Product product = null;
    Object object = request.getAttribute("product");

    if ( object != null ){

        product = (Product)object;
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

        int count = 0;

        while (iterator.hasNext()){
            ProductSpecification productspecification = iterator.next();

            out.write(productspecification.getName());
            out.write(":");
            Iterator<ProductSpecificationValue> iterator2  = productspecification.getProductspecificationvalues().iterator();
            while (iterator2.hasNext()){
                ProductSpecificationValue productspecificationvalue = iterator2.next();
                out.write("<input type='radio' name='ps"+count+"' value='"+productspecificationvalue.getId()+"'>");
                out.write(productspecificationvalue.getName());
                out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            count++ ;
            out.write("<br>");
        }

    }else{

        out.write("没有商品");
    }

%>

购买数量:<input type="text" id="quantity" name="quantity" value="1">件

<br>

<a href="void(0)" onclick="addCart()"  >加入购物车</a>

<script type="text/javascript">
    $().ready(function() {



    });


    // 加入购物车
    function addCart() {


        var quantity = $("#quantity").val();

        if (/^\d*[1-9]\d*$/.test(quantity) && parseInt(quantity) > 0) {
            $.ajax({
                url: "<%=path%>/cart/add",
                type: "POST",
                data: {id: <%=product.getId()%>, quantity: quantity},
                dataType: "json",
                cache: false,
                success: function(message) {
                    $.message(message);
                }
            });
        } else {
            alert("数量输入数字");
        }
    }

</script>