<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/lte.jsp"%>

<!DOCTYPE html>
<html style="height: 100%;width: 100%">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>电商后台</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=path%>/common/js/lte/dist/css/skins/skin-blue.min.css">
</head>

<style>
    .ifc {
        position: absolute;
        border:0;
        min-height: 100%;
    }
    .content-wrapper{
        height: 100%;
    }
    #myTabContent{
        width: 100%;
        height: 100%;
    }
    .tab_iframe{
        width: 100%;
        height: 100%;
    }
    .iframe_content{
        width: 100%;
        height: 100%;;
    }
    #welcome_div{
        width: 100%;
        height: 100%;
    }
    #welcome_div iframe{
        width: 100%;
        height: 100%;
    }

    #form0 .form-group{
        margin-bottom: 0;
        height: 52px;
    }

    .modal-body{
        text-align: center;
        height: 100%;
        padding-right: 60px;
        padding-bottom: 0px;
    }

    .skin-blue .sidebar-menu>li:hover>a, .skin-blue .sidebar-menu>li.active>a {
        color: #fff;
        background: #53acc5;
        border-left-color: #53acc5;
    }
    .skin-blue .sidebar-menu>li>.treeview-menu {
        margin: 0 1px;
        background: #94bbc5;
    }
    .skin-blue .treeview-menu>li>a {
        color: #27586d;
    }
    .skin-blue .treeview-menu>li.active>a, .skin-blue .treeview-menu>li>a:hover {
        color: #1b7382;
    }

    .sidebar-menu .active .fa-angle-left{
        -webkit-transform: rotate(-90deg);
        -ms-transform: rotate(-90deg);
        -o-transform: rotate(-90deg);
        transform: rotate(-90deg);
    }

    #myTab {
        height: 32px;
    }

    #myTab li {
        height: 31px;
    }

    #myTab li a {
        height: 32px;
        padding-top: 5px;
    }
</style>


<body class="hold-transition skin-blue" style="height: 100%;width: 100%">
<div class="wrapper" style="height: 100%;width: 100%">
    <header class="main-header">
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span style="float: left; line-height: 48px;"></span>
            <!-- logo for regular state and mobile devices -->
            <span class="" style="font-size: 16px;">电商后台</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <p style="display: inline;color: #fff; line-height: 50px; margin-right:20px;">${pmsOperator.real_name}</p>
            <p style="display: inline;color: #fff; line-height: 50px;" id="showtime">显示系统当前时间的位置</p>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu" style="line-height: 48px; margin-right: 18px;">
                <button id="off" type="button" class="btn btn-primary btn-sm" style="margin-right:15px; ">注销</button>
                <!-- 按钮触发模态框 -->
                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                    重置密码
                </button>
            </div>
        </nav>
    </header>

    <aside class="main-sidebar" style="background-color: #37839e">
        <section class="sidebar">
            <ul id="menu" class="sidebar-menu">
            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <div id="welcome_div">
            <iframe src="<%=path%>/admin/welcome.jsp" scrolling="yes" frameborder="yes" ></iframe>
        </div>
        <div id="myaddTab" style="width: 100%;height:100%;">
            <ul id="myTab" class="nav nav-tabs" >
            </ul>
            <div id="myTabContent" class="tab-content">
            </div>
        </div>
    </div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="width: 350px; ">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="cancelClick()">&times;</button>
                <h4 class="modal-title" id="myModalLabel">重置密码</h4>
            </div>

            <div class="modal-body">

                <form id="form0" action="" method="post" class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="row">
                            <label for="loginName" class="col-sm-6 control-label">账户：</label>
                            <div class="col-sm-6">
                                <input type="text" value="" name="loginName" class="form-control" id="loginName" required placeholder="" readonly="readonly">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label for="oldPwd" class="col-sm-6 control-label">输入原密码：</label>
                            <div class="col-sm-6">
                                <input type="password" name="oldPwd" class="form-control" id="oldPwd" required placeholder="">
                            </div>
                        </div>
                        <p id="oldPwd-err" style="padding: 0;margin:0;text-align:right;color: red;"></p>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label for="newPwd" class="col-sm-6 control-label">输入新密码：</label>
                            <div class="col-sm-6">
                                <input type="password" name="newPwd" class="form-control" id="newPwd" required placeholder="">
                            </div>
                        </div>
                        <p id="newPwd-err" style="padding: 0;margin:0;text-align:right;color: red;"></p>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <label for="newPwdT" class="col-sm-6 control-label">再次输入新密码：</label>
                            <div class="col-sm-6">
                                <input type="password" name="newPwdT" class="form-control" id="newPwdT" required placeholder="">
                            </div>
                        </div>
                        <p id="newPwdT-err" style="padding: 0;margin:0;text-align:right;color: red;"></p>
                    </div>

                </form>
            </div>

            <div class="modal-footer" style="text-align:center;">
                <!--data-dismiss="modal"模态框关闭-->
                <button type="button" class="btn btn-primary" onclick="saveClick()">保存</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="cancelClick()">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>


<script>

    //显示系统当前时间
    window.onload = function(){
        showTime();
    }

    function checkTime(i) { //补位
        if (i < 10) {
            i = '0' + i;
        }
        return i;
    }

    function showTime(){
        var now=new Date();
        var year=now.getFullYear();
        var month=now.getMonth()+1;
        var day=now.getDate();
        var h=now.getHours();
        var m=now.getMinutes();
        var s=now.getSeconds();
        month=checkTime(month);
        day=checkTime(day);
        h=checkTime(h);
        m=checkTime(m);
        s=checkTime(s);

        //显示星期
        var weekday=new Array(7)
        weekday[0]="星期日"
        weekday[1]="星期一"
        weekday[2]="星期二"
        weekday[3]="星期三"
        weekday[4]="星期四"
        weekday[5]="星期五"
        weekday[6]="星期六"

        document.getElementById("showtime").innerHTML=""+year+"年"+month+"月"+day+"日 "+weekday[now.getDay()]+" "+h+":"+m+":"+s;
        t=setTimeout('showTime()',500);
    }

    $(document).ready(function(){

        //菜单
        var menu = [
            {"name":"商品","url":"#",
                "submenu":[
                        {"name":"商品分类","url":"<%=path%>/admin/product/category/list.jsp"},
                        {"name":"商品参数","url":"<%=path%>/admin/product/parameter/listall"},
                        {"name":"商品属性","url":"<%=path%>/admin/product/attribute/listall"},
                        {"name":"规格管理","url":"<%=path%>/admin/product/specification/listall"},
                        {"name":"品牌管理","url":"<%=path%>/admin/brand/listBrand"},
                        {"name":"商品管理","url":"<%=path%>/admin/product/product/list.jsp"}
            ]},
            {"name":"menu1","url":"#","submenu":[{"name":"menu1","url":"#"}]}
        ]

        var arr;
        if(menu.length == 6){
            arr = ["fa fa-circle","fa fa-user","fa fa-qq","fa fa-weixin","fa fa-home fa-lg","fa fa-home fa-lg"];
        }else if(menu.length == 1){
            arr = ["fa fa-home fa-lg"];
        }else if(menu.length == 2){
            arr = ["fa fa-weixin","fa fa-home fa-lg"];
        }else if(menu.length == 3){
            arr = ["fa fa-weixin","fa fa-home fa-lg","fa fa-home fa-lg"];
        }

        $.each( menu, function ( index , element ) {
            var f1 = '<li class="treeview"> <a href="#"><i class="'+arr[index]+'"></i> <span>'+element.name+'</span><span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span> </a>';

            var f2 ='<ul class="treeview-menu">';
            $.each( element.submenu , function ( index1 , element1 ) {
                //element1.url
                f2 = f2  +  '<li><a href="javascript:void(0);" onclick="addTab(\''+element1.name+'\',\''+element1.url+'\')">'+element1.name+'</a></li> ';
            });

            f2 += '</ul>';

            var f3 = '</li>';

            $('#menu').append( f1 + f2 + f3 );

        });

    });

    /**选项卡**/
    var tab_html = '<li id="li_%s4"><a href="#%s1" data-toggle="tab">%s2&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" onclick="closeTab(\'%s3\')"></span></a></li>';

    var tab_content_html = '<div class="iframe_content tab-pane fade" id="%s1"><iframe class="tab_iframe" src="%s2" frameborder="0" scrolling="yes" frameborder="yes"></iframe></div>';

    var tab_arr = [];

    function addTab(tab_name,tab_url) {
        //browser_width = $(document.body).width();
        if ($.inArray(tab_name,tab_arr) == -1 ){
            //隐藏welcome
            $('#welcome_div').hide();
            var tab_html_temp = tab_html.replace('%s1',tab_name);
            tab_html_temp = tab_html_temp.replace('%s2',tab_name);
            tab_html_temp = tab_html_temp.replace('%s3',tab_name);
            tab_html_temp = tab_html_temp.replace('%s4',tab_name);
            $('#myTab').append(tab_html_temp);

            var tab_content_html_temp = tab_content_html.replace('%s1',tab_name);
            tab_content_html_temp = tab_content_html_temp.replace('%s2',tab_url);
            $('#myTabContent').append(tab_content_html_temp);
            $('#myTab a:last').tab('show');
            tab_arr.push(tab_name);
        }else{
            $('#myTab li:eq('+$.inArray(tab_name, tab_arr)+') a').tab('show');
        }
    }

    function closeTab(tab_name){
        var temp_index = $.inArray(tab_name, tab_arr);
        if(temp_index > -1){
            $('#li_' + tab_name).remove();
            $('#' + tab_name).remove();

            tab_arr.splice(temp_index,1);
            if(tab_arr.length == 0){
                $('#welcome_div').show();
            }else{
                if(temp_index > tab_arr.length-1){
                    $('#myTab li:eq('+(temp_index - 1)+') a').tab('show')
                }else{
                    $('#myTab li:eq('+(temp_index)+') a').tab('show')
                }
            }
        }
    }


    /**验证不能为空**/
    function isNullVal(s)// 空值返回true
    {
        if($.trim(s).length==0){
            return true;
        }else{
            return false;
        }
    }

    function checkInput() {
        var isOk = true;
        var val1 = $('#oldPwd').val();
        var val2 = $('#newPwd').val();
        var val3 = $('#newPwdT').val();

        if( isNullVal(val1)){
            $('#oldPwd-err').html("原密码不能为空");
            isOk = false;
        }else{
            $('#oldPwd-err').html("");
        }
        if( isNullVal(val2)){
            $('#newPwd-err').html("不能为空");
            isOk = false;
        }else{
            $('#newPwd-err').html("");
        }
        if( isNullVal(val3)){
            $('#newPwdT-err').html("不能为空");
            isOk = false;
        }else{
            $('#newPwdT-err').html("");
            if (val2 != val3){
                $('#newPwdT-err').html("两次密码不同");
                isOk = false;
            }else{
                $('#onewPwdT-err').html("");
            }
        }
        return isOk;
    }

    function saveClick(){

    }


    /**模态框垂直居中**/
    $(function(){
        // dom加载完毕
        var $m_btn = $('#modalBtn');
        var $modal = $('#myModal');
        $m_btn.on('click', function(){
            $modal.modal({backdrop: 'static'});
        });

        // 测试 bootstrap 居中
        $modal.on('show.bs.modal', function(){
            var $this = $(this);
            var $modal_dialog = $this.find('.modal-dialog');
            // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
            $this.css('display', 'block');
            $modal_dialog.css({'margin-top': Math.max(0, ($(window).height() - $modal_dialog.height()) / 2) });
        });

    });

    /**注销*/
    $("#off").click(function(){
    });

</script>

