<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.jftshop.entity.Specification" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.jftshop.entity.SpecificationValue" %>
<%@ include file="/common/lte.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Title</title>
</head>
<body>


<style type="text/css">
    .specificationSelect {
        height: 100px;
        padding: 5px;
        overflow-y: scroll;
        border: 1px solid #cccccc;
    }

    .specificationSelect li {
        float: left;
        min-width: 150px;
        _width: 200px;
    }

    .hidden1 {
        display:none;
    }

    table.input {
        width: 100%;
        word-break: break-all;
    }

</style>

<form id="addform" action="<%=path%>/admin/product/save" method="post" enctype="multipart/form-data">

<div class="container">

    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#home">基本信息</a></li>
        <li><a data-toggle="tab" href="#menu1">商品介绍</a></li>
        <li><a data-toggle="tab" href="#menu2">商品图片</a></li>
        <li><a data-toggle="tab" href="#menu3">商品参数</a></li>
        <li><a data-toggle="tab" href="#menu4">商品属性</a></li>
        <li><a data-toggle="tab" href="#menu5">商品规格</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane fade in active">

            类目ID
            <input type="text" id="productcategoryid" name="productcategoryid"/>
            <p><a href="javascript:void(0)" onclick="refresh()">刷新参数和属性</a>
            <br>


            <span class="requiredField">*</span>名称：
            <input type="text" id="name" name="name" required />
            <br>

            编号
            <input type="text" id="sn" name="sn" />
            <br>

            <span class="requiredField">*</span>销售价：
            <input type="text" id="price" name="price" />
            <br>

            库存：
            <input type="text" id="stock" name="stock" />
            <br>

            是否上架
            <input type="checkbox" name="isMarketable" value="true" checked="checked">
            <br>
            是否列出
            <input type="checkbox" name="isList" value="true" checked="checked">



        </div>

        <div id="menu1" class="tab-pane fade">

            <textarea id="editor_id" name="introduction" class="editor" style="width: 100%;"></textarea>

        </div>

        <div id="menu2" class="tab-pane fade">

            <p><a href="javascript:void(0)" onclick="addpic();">增加图片</a></p>

            <div id="pic"></div>

        </div>

        <div id="menu3" class="tab-pane fade">

            <table id="parameterTable"></table>

        </div>

        <div id="menu4" class="tab-pane fade">

            <table id="attributeTable"></table>

        </div>

        <div id="menu5" class="tab-pane fade">

            <div id="specificationSelect" class="specificationSelect"><br>
                <%
                    Iterator<Specification> iterator = ((List)request.getAttribute("specifications")).iterator();
                    while (iterator.hasNext()){
                        Specification specification = iterator.next();
                        out.write( "<input type=\"checkbox\" " +
                                "name=\"specificationIds\" " +
                                "value="+specification.getId()+">"+specification.getName()+"/"+specification.getMemo()+"&nbsp;");
                    }
                %>
            </div>
            <br>
            <a href="javascript:;" id="addSpecificationProduct" class="button">增加规格商品</a>


            <table id="specificationProductTable" class="input">
                <tr class="title">
                    <td width="60">
                        &nbsp;
                    </td>
                    <%
                        Iterator<Specification> specifiterator = ((List)request.getAttribute("specifications")).iterator();
                        while (specifiterator.hasNext()){
                            Specification specification = specifiterator.next();
                            out.write( "<td class=\"specification_"+specification.getId() +" hidden1\">" +
                                            specification.getName() +"/"+specification.getMemo() + "</td>" );
                        }
                    %>
                    <td>
                        操作
                    </td>
                </tr>

                <tr class="hidden1">
                    <td>
                        &nbsp;
                    </td>

                    <%
                        Iterator<Specification> iterator3 = ((List)request.getAttribute("specifications")).iterator();
                        while (iterator3.hasNext()){
                            Specification specification = iterator3.next();
                            out.write("<td class=\"specification_"+specification.getId()+" hidden1\">"+
                                      "<select name=\"specification_"+specification.getId()+"\" disabled=\"disabled\">");

                            Iterator<SpecificationValue> iterator4 =  specification.getSpecificationValues().iterator();
                            while (iterator4.hasNext()){
                                SpecificationValue specificationvalue = iterator4.next();
                                out.write("<option value=\""+specificationvalue.getId()+"\">"+specificationvalue.getName()+"</option>");
                            }
                            out.write("</select></td>");
                        }
                    %>

                    <td>
                        <a href="javascript:void(0);" onclick="delone(this)">删除</a>
                    </td>
                </tr>

            </table>

        </div>

    </div>
</div>


<input type="submit"  value="提交">

</form>

</body>
</html>


<script type="text/javascript">

    $().ready(function() {

        var $addSpecificationProduct = $("#addSpecificationProduct");
        var $specificationProductTable = $("#specificationProductTable");
        var $specificationIds = $("#specificationSelect :checkbox");
        var $deleteSpecificationProduct = $("a.deleteSpecificationProduct");

        KindEditor.ready(function(K) {
            window.editor = K.create('#editor_id');
        });

        // 修改商品规格
        $specificationIds.click(function() {
            if ($specificationIds.filter(":checked").size() == 0) {
                $specificationProductTable.find("tr:gt(1)").remove();
            }
            var $this = $(this);

            if ($this.prop("checked")) {

                $specificationProductTable.find("td.specification_" + $this.val()).show().find("select").prop("disabled", false);
            } else {
                $specificationProductTable.find("td.specification_" + $this.val()).hide().find("select").prop("disabled", true);
            }
        });



        // 增加规格商品
        $addSpecificationProduct.click(function() {
            if ($specificationIds.filter(":checked").size() == 0) {
                alert("没有添加规格");
                return false;
            }
            if ($specificationProductTable.find("tr:gt(1)").size() == 0) {
                $tr = $specificationProductTable.find("tr:eq(1)").clone().show().appendTo($specificationProductTable);
                $tr.find("td:first").text("当前规格");
                $tr.find("td:last").text("-");
            } else {
                $specificationProductTable.find("tr:eq(1)").clone().show().appendTo($specificationProductTable);
            }
        });

    });

    var productImageIndex = 0;

    function addpic() {

        var trHtml = '<tr><td><input type="file" name="productimages[' + productImageIndex + '].file" class="productImageFile" \/><\/td><td>' +
                '<input type="text" name="productimages[' + productImageIndex + '].title" class="text" maxlength="200" \/><\/td><td>' +
                '<a href="javascript:;" class="deleteProductImage">删除<\/a><\/td><\/tr>';

        $("#pic").append(trHtml);

        productImageIndex++;
    }


    function refresh(){
        loadAttribute();
        loadParameter();
    }


    // 加载属性
    function loadAttribute() {
        $.ajax({
            url: "<%=path%>/admin/product_category/getattibutebycategoryid",
            type: "GET",
            data: {id: $("#productcategoryid").val()},
            dataType: "json",
            beforeSend: function() {
                $("#attributeTable").empty();
            },
            success: function(data) {
                var trHtml = "";

                $.each(data, function(i, attribute) {

                    var optionHtml = '<option value="">请选择<\/option>';

                    $.each(attribute.attributeoptions, function(j, option) {
                        optionHtml += '<option value="' + option.options + '">' + option.options + '<\/option>';
                    });

                    trHtml += '<tr><th>' + attribute.name +
                              ': <\/th><td><select name="attribute_' + attribute.id + '">' + optionHtml + '<\/select><\/td><\/tr>';

                });

                $("#attributeTable").append(trHtml);
            }
        });
    }

    // 加载参数
    function loadParameter() {
        $.ajax({
            url: "<%=path%>/admin/product_category/getparametersbycategoryid",
            type: "GET",
            data: {id: $("#productcategoryid").val()},
            dataType: "json",
            beforeSend: function() {
                $("#parameterTable").empty();
            },
            success: function(data) {
                var trHtml = "";
                $.each(data, function(i, parameterGroup) {
                    trHtml += '<tr><td style="text-align: right;"><strong>' + parameterGroup.name + ':<\/strong><\/td><td>&nbsp;<\/td><\/tr>';
                    $.each(parameterGroup.parameters, function(i, parameter) {

                        trHtml += '<tr><th>' + parameter.name + ': <\/th><td><input type="text" name="parameter_' + parameter.id + '" class="text" maxlength="200" \/><\/td> <\/tr>';
                    });
                });
                $("#parameterTable").append(trHtml);
            }
        });
    }


    // 删除规格商品
    function delone(aa) {
        var $this = $(aa);
        $this.parent().parent().remove();
    }

</script>