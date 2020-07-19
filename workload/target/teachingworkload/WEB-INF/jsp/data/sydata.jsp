<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <title>分批次实践数据导入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div class="easyui-panel" title="课程实验环节多批次（包括单批次）实施数据"
     data-options="region:'north',border:false,split:false,striped:true,iconCls:'icon-home'"
     style="height:80px; overflow: hidden;">
    <div style="padding:5px;height:auto">
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


                        </td>
                        <th>课程号:</th>
                        <td>
                            <input id="kch" name="kch" class="easyui-validatebox textbox"
                                   style="width:150px; height:29px;" placeholder="课程名(可以不输入)">
                        </td>
                        <th>课序号:</th>
                        <td>
                            <input id="kxh" name="kxh" class="easyui-validatebox textbox"
                                   style="width:150px; height:29px;" placeholder="课序号(可以不输入)">
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
        <a href="javascript:void(0);" onclick="uploadFun();" class="easyui-linkbutton" iconCls="icon-add" plain="true">导入数据</a>
        <span>&nbsp;|&nbsp;</span>
        <a href="javascript:void(0);" onclick="datacheck();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">数据校验</a>
        <span>&nbsp;|&nbsp;</span>
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-bin-empty" plain="true" onclick="sygzlcal();">实验工作量统计</a>
        <span>&nbsp;|&nbsp;</span>
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="removeAll()">清理数据</a>

    </div>
</div>
<!--中央区域结束-->


<!--添加附件的对话框组件-->
<div id="attachmentDialog" class="easyui-dialog" style="width:600px;height:340px;"
     data-options="iconCls:'icon-upload',resizable:true,modal:true,closed:true">
    <form id="attachmentForm">
        <div class="easyui-panel">
            <div class="ftitle">附件信息</div>
            <div>
                <img id="loading" src="${pageContext.request.contextPath}/statics/style/images/loading.gif" style="display: none;"/>
            </div>
            <table>
                <tr>
                    <th>选择上传文件</th>
                    <td>
                        <input id="uploadFile" name="uploadFile" style="width:350px"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><label name="fileName" id="fileName"></label></td>
                </tr>
            </table>
            <div class="ftitle">
                请确保待上传的数据格式严格按模板表格做好的数据，在Excel中是第一个表格。
                <img src="${pageContext.request.contextPath}/statics/style/images/png/sy.png" width="560" height="180">
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
    var dataGrid;
    $(function () {
        //使用js生成datagrid
        dataGrid = $("#kcdg").datagrid({
            url:"sydata",
            queryParams:{"term":"${xq}","department":"${xyid}","kch":"${kch}","kxh":"${kxh}"},
            singleSelect:true,
            loadMsg: "数据加载中，请稍后...",
            remoteSort: false,
            rownumbers: true, //行号
            pagination:true,
            pageSize:20,
            pageList:[20,30,40,50],
            frozenColumns:[[
                {field:"name",title:"所属学院",width:120,
                    formatter: function(value,row,index){
                        if(row.name){
                            return row.name;
                        }else{
                            return "<span style='color:red;'>--</span>";
                        }
                    }
                },
                {field:"termname",title:"所属学期",width:100,
                    formatter: function(value,row,index){
                        if(row.termname){
                            return row.termname;
                        }else{
                            return "<span style='color:red;'>--</span>";
                        }
                    }
                },
                {field:"kch",title:"课程号",width:100},
                {field:"kxh",title:"课序号",width:50},
                {field:"kcm",title:"课程名",width:180},
                {field:"skls",title:"授课老师",width:80},
                {field:"xkrs",title:"选课人数",width:80},
                {field:"zxs",title:"总学时",width:60},
                {field:"skxs",title:"理论学时",width:60},
                {field:"syxs",title:"实验学时",width:60},
            ]],
            columns:[[
                {field:"fpcx",title:"分批次数",width:80},
                {field:"fpxs",title:"分批学时",width:80},
                {field:"fpgzl",title:"实验工作量",width:160},
                {field:"cwd",title:"正确性",width:100},
                {field:"jy",title:"校验",width:100}
            ]]
        });

        $("#uploadFile").filebox({
            buttonText:'选择',
            prompt:'请选择待待提交的文件',
            onChange:function (newValue,oldValue) {
                filecheck();
            }

        });
    });

    //查询
    function searchFun() {
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }

    //数据校验
    function datacheck() {
        //使用js生成datagrid
        dataGrid = $("#kcdg").datagrid({
            url:"checksycourse",
            queryParams:{"term":"${xq}","department":"${xyid}","kch":"${kch}","kxh":"${kxh}"},
            singleSelect:true,
            loadMsg: "数据加载中，请稍后...",
            remoteSort: false,
            rownumbers: true, //行号
            pagination:true,
            pageSize:20,
            pageList:[20,30,40,50],
            frozenColumns:[[
                {field:"name",title:"所属学院",width:120,
                    formatter: function(value,row,index){
                        if(row.name){
                            return row.name;
                        }else{
                            return "<span style='color:red;'>--</span>";
                        }
                    }
                },
                {field:"termname",title:"所属学期",width:100,
                    formatter: function(value,row,index){
                        if(row.termname){
                            return row.termname;
                        }else{
                            return "<span style='color:red;'>--</span>";
                        }
                    }
                },
                {field:"kch",title:"课程号",width:100},
                {field:"kxh",title:"课序号",width:50},
                {field:"kcm",title:"课程名",width:180},
                {field:"skls",title:"授课老师",width:80},
                {field:"xkrs",title:"选课人数",width:80},
                {field:"zxs",title:"总学时",width:60},
                {field:"skxs",title:"理论学时",width:60},
                {field:"syxs",title:"实验学时",width:60},
            ]],
            columns:[[
                {field:"fpcx",title:"分批次数",width:80},
                {field:"fpxs",title:"分批学时",width:80},
                {field:"fpgzl",title:"实验工作量",width:160},
                {field:"cwd",title:"正确性",width:100},
                {field:"jy",title:"校验",width:100},
                {field:"errmsg",title:"校验结果",width:100}
            ]]
        })
    }
    //清理所有数据
    function  removeAll() {
        parent.$.messager.confirm('询问', '您是否要删除实验环节的全部数据？', function (b) {
            if (b) {
                progressLoad();
                $.ajax({
                    type: "post",  //数据的提交方式：get和post
                    url: "deleteallsydata", //数据的提交路径
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

    //实验工作量统计
    function sygzlcal() {
        parent.$.messager.confirm('提示', '在完成实验工作量统计前，请确保所有分批次实验数据导入完毕。继续进行实验工作量统计吗？', function (b) {
            if (b) {
                progressLoad();
                $.ajax({
                    type: "post",  //数据的提交方式：get和post
                    url: "sygzltotal", //数据的提交路径
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

    //上传Excle数据文件
    function uploadFun() {
        $("#uploadFile").filebox("reset");
        $('#fileName').html("");
        $('#attachmentDialog').dialog({
            title: "课程实验环节分批情况数据表文件上传",
            //href:"attachement-upload.action",
            closed: false,
            buttons:[{
                text:'上传并导入',
                handler:function(){
                    if(filecheck()){
                        fileUploading();
                    }
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#attachmentDialog').dialog("close");
                }
            }]
        });
    }

    function filecheck() {
        //获取上传文件控件内容
        var file = document.getElementById('filebox_file_id_1').files[0];
        //判断控件中是否存在文件内容，如果不存在，弹出提示信息，阻止进一步操作
        if (file == null || file==undefined) {
            $('#fileName').html("<span style='color:red'>文件名不能为空</span>");
            return false;
        }
        //获取文件名称
        var fileName = file.name;
        //获取文件类型名称
        var file_typename = fileName.substring(fileName.lastIndexOf('.'), fileName.length);
        //这里限定上传文件文件类型，如果文件类型不符，提示错误信息
        var fileTypes = ['.xls', '.xlsx'];
        var flag = false;
        for (var i = 0; i < fileTypes.length; i++){
            if(fileTypes[i]==file_typename.toLowerCase()){
                flag = true;
                break;
            }
        }
        if (flag) {
            //计算文件大小
            var fileSize = 0;
            //如果文件大小大于1024字节X1024字节，则显示文件大小单位为MB，否则为KB
            if (file.size > 1024 * 1024) {
                fileSize = Math.round(file.size * 100 / (1024 * 1024)) / 100;
                if (fileSize > 10) {
                    $('#fileName').html("<span style='color:red'>错误，文件超过10MB，禁止上传！</span>");
                    return false;
                }
                fileSize = fileSize.toString() + 'MB';
            }
            else {
                fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
            }
            //将文件名和文件大小显示在前端label文本中
            $('#fileName').html("<span style='color:Blue'>文件名: " + file.name + ',大小: ' + fileSize + "</span>");

        }else{
            $('#fileName').html("<span style='color:red'>文件类型不对</span>");
            return false;
        }
        return true;
    }

    function fileUploading() {
        $.messager.confirm('提示', '你确定上传这个数据文件吗?', function(r){
            if (r){
                //获取form数据
                var formData = new FormData($("#attachmentForm")[0]);
                //调用apicontroller后台action方法，将form数据传递给后台处理。contentType必须设置为false,否则chrome和firefox不兼容
                $.ajax({
                    url: "syuploadfile",
                    type: 'POST',
                    data: formData,
                    async: true,
                    cache: false,
                    contentType: false,
                    processData: false,
                    dataType:"json",
                    beforeSend:function(){
                        $('#attachmentDialog').dialog("close");
                        progressLoad();
                    },
                    success: function (data) {
                        //$('#attachmentDialog').dialog("close");
                        progressClose();
                        var errtotal = data.total;
                        if (errtotal > 0) {
                            //上传成功后将控件内容清空，并显示上传成功信息
                            $.messager.alert('提示', "非法的数据有" + data.total + "条", 'info');
                            //把错误的数据呈现
                            $("#kcdg").datagrid("loadData", data.rows);
                            //数据有问题时下载对应的数据对比情况
                            window.location.href = "sydatacheck";
                        }else{
                            searchFun();//插叙满足条件的第一页的数据
                        }
                    },
                    error: function (data) {
                        progressClose();
                        //上传失败时显示上传失败信息
                        $.messager.alert('提示','文件上传出错'+data,'error');
                    }
                });
            }
        });
    }
</script>
</body>

</html>