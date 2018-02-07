var DTCONSTANT = {

    // datatables常量  
    DATA_TABLES : {
        DEFAULT_OPTION : { // DataTables初始化选项  
            LANGUAGE : {
                sProcessing : "处理中...",
                sLengthMenu : "每页 _MENU_ 项结果",
                sZeroRecords : "没有匹配结果",
                sInfo : "当前显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                sInfoEmpty : "显示第 0 至 0 项结果，共 0 项",
                sInfoFiltered : "(由 _MAX_ 项结果过滤)",
                sInfoPostFix : "",
                sSearch : "搜索:",
                sUrl : "",
                sEmptyTable : "表中数据为空",
                sLoadingRecords : "载入中...",
                sInfoThousands : ",",
                oPaginate : {
                    sFirst : "首页",
                    sPrevious : "上页",
                    sNext : "下页",
                    sLast : "末页"
                },
                "oAria" : {
                    "sSortAscending" : ": 以升序排列此列",
                    "sSortDescending" : ": 以降序排列此列"
                }
            },
            // 禁用自动调整列宽  
            autoWidth : false,
            // 为奇偶行加上样式，兼容不支持CSS伪类的场合  
            stripeClasses : [ "odd", "even" ],
            // 取消默认排序查询,否则复选框一列会出现小箭头  
            order : [],
            // 隐藏加载提示,自行处理  
            processing : true,
            // 启用服务器端分页  
            serverSide : true,
            // 禁用原生搜索  
            searching : true
        },
        COLUMN : {
            // 复选框单元格  
            CHECKBOX : {
                //className: "checkbox",
                title:"<input id=\"dtcb\" type=\"checkbox\" class=\"checkbox\"/>",
                orderable : false,
                bSohao1rtable : false,
                width : "1%",
                data : "id",
                render : function(data, type, row, meta) {
                    //var content = '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">';
                    var content = '    <input type="checkbox" class="checkbox" value="' + data + '" />';
                    //content += '    <span></span>';
                    //content += '</label>';
                    return content;
                }
            },

            RNUM :  {
                data : null,
                bSortable : false,
                targets : 0,
                //title:"序号",
                width : "1%",
                render : function(data, type, row, meta) {
                            var startIndex = meta.settings._iDisplayStart;   // 显示行号
                            return startIndex + meta.row + 1;
                }
            }
        },
        // 常用render可以抽取出来，如日期时间、头像等  
        RENDER : {
            ELLIPSIS : function(data, type, row, meta) {
                data = data || "";
                return '<span title="' + data + '">' + data + '</span>';
            }
        }
    }
};

var g_dt_config = {
        language: DTCONSTANT.DATA_TABLES.DEFAULT_OPTION.LANGUAGE,
        scrollX: true,
        scrollY: 400,
        processing: true,
        serverSide : true,
        ordering: false,
     //   dom: 'Bfrtip',
        paging:true,
        pageLength: 50, //默认每页条数
        aLengthMenu: [50, 100, 500, 1000],
        lengthChange: true,
        searching: false,
        columnDefs:[{
            defaultContent: "",
            targets: "_all"
        }]
}

var g_dt_init = function ( id ,  conf ) {

    var config = $.extend( g_dt_config , conf );

    var dt_draw = $("#"+id);//渲染容器ID
    var dt_container = "dt_"+id ;  //数据表单容器ID

    //拷贝模板
    $("#dt_templet").tmpl( [ { id : dt_container , title : config.dt_title } ] ).appendTo( "#"+id );

    var dt =  $( "#"+dt_container ).DataTable(  config  ).on('xhr.dt', g_dt_xhr_event );

    if ( $( '#dtcb',dt_draw ).length == 1 ) {
        $( '#dtcb' , dt_draw ).on( 'click',function(){
            if (this.checked) {
                $('.checkbox', dt_draw ).each(function () {
                    this.checked = true;
                });
            } else {
                $('.checkbox', dt_draw ).each(function () {
                    this.checked = false;
                });
            }
        });
    }

    return dt ;
}

var g_dt_xhr_event = function ( e, settings, json, xhr ) {
   // xhr.fail(function( data, textStatus, jqXHR ) { alert('fail');});
   // xhr.done(function( data, textStatus, jqXHR ) { alert('success');});
}


//全局字典服务
var g_dic = {};

//全局初始化
var g_init = function(){
    $("select[dic]").each(function (i, e) {
        $("<option value=''>请选择</option>").appendTo($(e));
        var dicName = $(e).attr("dic");
        $.each(eval("g_dic."+dicName), function (n, v) {
            $("<option value="+n+">"+v+"</option>").appendTo($(e));
        });
    });
}


var g_form_reset = function(formid){
    $('#'+formid)[0].reset();
}


var g_form_load = function () {
    $("#formload").after("<div id='overlay' class='overlay'><i class='fa fa-refresh fa-spin'></i></div>");
}

var g_form_disload = function () {
    $("#overlay").remove();
}

var g_modal_success= function (  body ) {
    $('#modal-success-body').html("<p>"+body+"</p>");
    $('#modal-success').modal('show');
}

var g_modal_warn= function (  body ) {
    $("#modal-warning-body").html("<p>"+body+"</p>");
    $("#modal-warning").modal('show');
}





