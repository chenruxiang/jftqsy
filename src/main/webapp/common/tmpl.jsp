<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script id="dt_templet" type="text/x-jquery-tmpl">
     <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h5>{{= title}}</h5>
                        <div class="box-tools pull-right">
                             <button id="box-widget" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        </div>
                </div>
                <div class="box-body">
                   <table id="{{= id}}" class="table table-bordered table-hover dataTable" style="height:100%;width:100%"></table>
                </div>
            </div>
        </div>
    </div>
</script>


<div class="modal modal-success fade" id="modal-success" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="modal-success-title">成功</h4>
            </div>
            <div class="modal-body" id="modal-success-body">
                <p></p>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div class="modal modal-warning fade" id="modal-warning" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="modal-warning-title">警告</h4>
            </div>
            <div class="modal-body" id="modal-warning-body">
                <p></p>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
