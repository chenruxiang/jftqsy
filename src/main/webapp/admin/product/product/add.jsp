<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
            <input type="text" id="name" name="name" required/>
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

        </div>

    </div>
</div>


<input type="submit"  value="提交">

</form>

</body>
</html>


<script type="text/javascript">

    $(function(){

        KindEditor.ready(function(K) {
            window.editor = K.create('#editor_id');
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


</script>