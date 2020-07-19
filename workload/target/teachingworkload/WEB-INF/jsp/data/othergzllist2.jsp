<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <title>其它教学工作量数据录入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
   <div class="easyui-panel" title="其它教学工作量数据录入"
         data-options="region:'north',border:false,iconCls:'icon-home'"
         style="height:80px; overflow: hidden;">
       <div style="margin:0;padding:0;height:auto">
        <div>
            <form id="searchForm">
                <table>
                    <tr>
                        <th>所属学期:</th>
                        <td>
                            <select id="term" name="term" class="easyui-combobox"
                                    data-options="width:150,height:29,editable:false,panelHeight:'auto'">
                                <option value="0">请选择学期</option>
                                <c:forEach items="${terms}" var="term">
                                    <option value="${term.termid}">${term.termname}</option>
                                </c:forEach>
                            </select>

                            <!--操作-->
                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
                        </td>

                    </tr>
                </table>
            </form>
        </div>
       </div>
   </div>

    <!--中央区域开始-->
    <div data-options="region:'center'">
       <table id="kcdg" data-options="fit:true,border:false,toolbar:'#tb'"></table>
        <div id="tb">
            <span>&nbsp;|&nbsp;</span>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               data-options="iconCls:'icon-application-osx-add',plain:true" onclick="addOthergzlFun();">添加</a>
            <span>&nbsp;|&nbsp;</span>
            <a href="javascript:void(0);" class="easyui-linkbutton"
               data-options="iconCls:'icon-export',plain:true" onclick="exportOthergzlFun();">导出</a>
            <span>&nbsp;|&nbsp;</span>
            <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="removeAll()">清空数据</a>
        </div>
    </div>
    <!--中央区域结束-->
    <script type="text/javascript">
        var dataGrid;
        $(function () {
            //使用js生成datagrid
            dataGrid = $("#kcdg").datagrid({
                url:"findotherwl2",
                singleSelect:true,
                loadMsg: "数据加载中，请稍后...",
                remoteSort: false,
                rownumbers: true, //行号
                pagination:true,
                pageSize:20,
                pageList:[20,30,40,50],
                columns:[[
                    {field:"name",title:"所属学院",width:160},
                    {field:"termname",title:"学期",width:120},
                    {field:"gzl",title:"补贴课时",width:100},
                    {field:"gzlmc",title:"补贴名头",width:200},
                    {field:"brief",title:"说明",width:400},
                    {field: 'action', title: '操作', width: 130,
                        formatter: function (value, row, index) {
                            var str = '';
                            str += $.formatString('<a href="javascript:void(0)" class="department-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-mini-edit\'" onclick="othergzlwindow(\'{0}\');" >编辑</a>', row.otherid);
                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                            str += $.formatString('<a href="javascript:void(0)" class="department-easyui-linkbutton-delete" data-options="plain:true,iconCls:\'icon-delete\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.otherid);
                            return str;
                        }
                    }
                ]],
                onLoadSuccess: function (data) {
                    $('.department-easyui-linkbutton-edit').linkbutton({text: '编辑', plain: true, iconCls: 'icon-mini-edit'});
                    $('.department-easyui-linkbutton-delete').linkbutton({text: '删除', plain: true, iconCls: 'icon-delete'});
                }
            });
        });

        //查询
        function searchFun() {
            dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
        }

        //数据导出
        function exportOthergzlFun() {
            parent.$.messager.alert('提示', "数据导出暂时未提供", 'info');
        }

        //打开添加数据窗口
        function addOthergzlFun(){
            othergzlwindow(-1);//参数小于0则在数据库中查无此数据，表示新增数据
        }

        //添加或修改数据窗口
        /**
         * @param otherid 如果小于0则表示转到添加页面
         */
        function othergzlwindow(otherid){
            //alert(otherid);
            var _title = "其它工作量补贴数据录入";
            if(otherid>0) _title = "其它工作量补贴数据修改";
            parent.$.modalDialog({
                title: _title,
                width: 800,
                height: 200,
                href: "findOthergzlByid2?otherid=" + otherid,
                buttons: [{
                    text: '保存',
                    iconCls:'icon-save',
                    handler: function () {
                        parent.$.modalDialog.openner_dataGrid = $("#kcdg");
                        var f = parent.$.modalDialog.handler.find('#othergzlEditForm');
                        //表单必选项校验
                        var isValid = f.form('validate');
                        if(!isValid){
                            parent.$.messager.alert('提示', "其它工作量补贴信息不正确", 'info');
                            return;
                        }
                        progressLoad();
                        $.ajax({
                            url:"updateotherwl2?"+f.serialize(),
                            type: "get",
                            contentType: "application/json",
                            success: function (result) {
                                progressClose();
                                //result = $.parseJSON(result);
                                if (result.success) {
                                    parent.$.messager.alert('提示', result.msg, 'info');
                                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                                    //parent.$.modalDialog.handler.dialog('close');
                                } else {
                                    parent.$.messager.alert('提示', result.msg, 'warning');
                                }
                            }
                        });
                    }
                },{
                    text: '关闭',
                    iconCls:'icon-back',
                    handler: function () {
                        parent.$.modalDialog.handler.dialog('close');
                    }
                }]
            });
        }

        function deleteFun(id) {
            parent.$.messager.confirm('询问', '您是否要删除当前数据吗？', function (b) {
                if (b) {
                    progressLoad();
                    $.ajax({
                        type: "post",  //数据的提交方式：get和post
                        url: "deleteotherwl2", //数据的提交路径
                        cache:false,
                        async:true, //默认是true：异步，false：同步。是否支持异步刷新，默认是true
                        dataType: 'json',  //服务器返回数据的类型，例如xml,String,Json等
                        data:{"otherid": id},  //需要提交的数据
                        success: function(result){  //请求成功后的回调函数
                            if (result.success) {
                                parent.$.messager.alert('提示', result.msg, 'info');
                                dataGrid.datagrid('reload');
                                //dataGrid.datagrid('clearSelections');
                            }else {
                                parent.$.messager.alert('警告', result.msg, 'warning');
                                dataGrid.datagrid('reload');
                                //dataGrid.datagrid('clearSelections');
                            }
                            progressClose();
                        },
                        error:function(xhr,status,err){  //请求失败后的回调函数
                            //失败
                            progressClose();
                            parent.$.messager.alert('错误', xhr.responseText, 'error');
                            dataGrid.datagrid('reload');
                            dataGrid.datagrid('clearSelections');
                        }
                    });
                }
            });
        }

        function  removeAll() {
            parent.$.messager.confirm('询问', '您是否要删除全部数据吗？', function (b) {
                if (b) {
                    progressLoad();
                    $.ajax({
                        type: "post",  //数据的提交方式：get和post
                        url: "deleteall2", //数据的提交路径
                        cache:false,
                        async:true, //默认是true：异步，false：同步。是否支持异步刷新，默认是true
                        dataType: 'json',  //服务器返回数据的类型，例如xml,String,Json等
                        success: function(result){  //请求成功后的回调函数
                            if (result.success) {
                                parent.$.messager.alert('提示', result.msg, 'info');
                                dataGrid.datagrid('reload');
                                //dataGrid.datagrid('clearSelections');
                            }else {
                                parent.$.messager.alert('警告', result.msg, 'warning');
                                dataGrid.datagrid('reload');
                                //dataGrid.datagrid('clearSelections');
                            }
                            progressClose();
                        },
                        error:function(xhr,status,err){  //请求失败后的回调函数
                            progressClose();
                            parent.$.messager.alert('错误', xhr.responseText, 'error');
                            dataGrid.datagrid('reload');
                        }
                    });
                }
            });
        }

    </script>
</body>

</html>