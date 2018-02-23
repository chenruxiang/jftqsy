<%@ page language="java" contentType="text/html; charset=UTF-8"
                                   pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.Random" %>

<% String path = request.getContextPath();%>


<!-- Bootstrap 3.3.6 -->
<link href="<%=path%>/common/jftw.jpg" rel="shortcut icon" type="image/x-icon" />

<link rel="stylesheet" href="<%=path%>/common/js/lte/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="<%=path%>/common/js/lte/bootstrapValidator/css/bootstrapValidator.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=path%>/common/js/lte/dist/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="<%=path%>/common/js/lte/dist/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=path%>/common/js/lte/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<%=path%>/common/js/lte/dist/css/skins/skin-blue.min.css">

<link rel="stylesheet" href="<%=path%>/common/js/lte/plugins/datatables/jquery.dataTables.min.css">

<!-- datatable导数-->
<link rel="stylesheet" href="<%=path%>/common/js/lte/plugins/datatables/buttons/buttons.dataTables.min.css">

<!-- jQuery 2.2.3 -->
<script src="<%=path%>/common/js/lte/plugins/jQuery/jquery-2.2.3.min.js"></script>

<!-- jQuery UI 1.11.4 -->
<script src="<%=path%>/common/js/lte/plugins/jQueryUI/jquery-ui.min.js"></script>

<script src="<%=path%>/common/js/lte/plugins/datatables/jquery.dataTables.min.js"></script>
<!-- jQuery 模板插件 -->
<script src="<%=path%>/common/js/lte/plugins/tmpljs/jquery.tmpl.min.js"></script>

<!-- Bootstrap 3.3.6 -->
<script src="<%=path%>/common/js/lte/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/common/js/lte/bootstrapValidator/js/bootstrapValidator.min.js"></script>
<script src="<%=path%>/common/js/lte/bootstrapValidator/js/language/zh_CN.js"></script>

<script src="<%=path%>/common/js/lte/plugins/fastclick/fastclick.js"></script>
<!-- Slimscroll -->
<script src="<%=path%>/common/js/lte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=path%>/common/js/lte/dist/js/app.js"></script>
<!-- 校验 -->
<script src="<%=path%>/common/js/lte/plugins/validate/jquery.validate.js"></script>

<!-- 引入HTML模板 -->
<%@include file="tmpl.jsp"%>

<!-- 页面初始化-->
<script src="<%=path%>/common/js/lte/plugins/datatables/init.js?version=<%=new Random().nextDouble()%>"></script>

<!-- datatable导数-->
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/dataTables.buttons.min.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/buttons.flash.min.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/jszip.min.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/pdfmake.min.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/vfs_fonts.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/buttons.html5.min.js"></script>
<script src="<%=path%>/common/js/lte/plugins/datatables/buttons/buttons.print.min.js"></script>

<!-- 异步上传文件 -->
<script src="<%=path%>/common/js/jquery-ui.min.js"></script>
<script src="<%=path%>/common/js/jquery.form.js"></script>

<script src="<%=path%>/common/jedate/jedate.js"></script>

<!-- 在线编辑器 -->
<script src="<%=path%>/common/js/editor/kindeditor.js"></script>

<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>

<style type="text/css">
       .modal-body{
              text-align: center;
              height: 100%;
              padding-right: 70px;
              padding-bottom: 0px;
       }
</style>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myReloginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
       <div class="modal-dialog modal-sm">
              <div class="modal-content" style="width: 350px; ">
                     <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">重新登录</h4>
                     </div>

                     <div class="modal-body">

                            <form id="relogin" class="form-horizontal" role="form">
                                   <div class="form-group">
                                          <div class="row">
                                                 <label for="loginName" class="col-sm-6 control-label">账户：</label>
                                                 <div class="col-sm-6">
                                                        <input type="text" name="loginName" class="form-control" id="loginName" required placeholder="" readonly="readonly">
                                                 </div>
                                          </div>
                                   </div>

                                   <div class="form-group">
                                          <div class="row">
                                                 <label for="Pwd" class="col-sm-6 control-label">密码：</label>
                                                 <div class="col-sm-6">
                                                        <input type="password" name="Pwd" class="form-control" id="Pwd" required placeholder="">
                                                 </div>
                                          </div>
                                          <p id="Pwd-err" style="padding: 0;margin:0;text-align:right;color: red;"></p>
                                   </div>

                            </form>
                     </div>

                     <div class="modal-footer" style="text-align:center;">
                            <!--data-dismiss="modal"模态框关闭-->
                            <button type="button" class="btn btn-primary" onclick="saveClick()">登录</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" >取消</button>
                     </div>
              </div><!-- /.modal-content -->
       </div><!-- /.modal -->
</div>

<script type="text/javascript">

      function saveClick(){
          var data = $("#relogin").serialize();
          $.ajax({
              url: "<%=path%>/relogin",
              type: 'post',
              data: data,
              success: function(result) {
                  if(result.flag){
                      $("#myReloginModal").modal('hide');
                  }else{
                      alert("密码错误");
                  }
              },
              error: function ()//服务器响应失败处理函数
              {
                  alert("系统异常，请联系管理员");
              }
          });
      }
</script>



