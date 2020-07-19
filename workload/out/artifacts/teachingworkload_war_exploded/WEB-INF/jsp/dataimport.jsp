<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <title>教学工作量数据导入</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div class="easyui-panel" title="教学工作量导入"
     data-options="region:'north',border:false,iconCls:'icon-home'"
     style="height:80px; overflow: hidden;">
    <div style="margin:0;padding:0;height:auto">
        <div>
            <form id="searchForm">
                <table>
                    <tr>
                        <th>部门名称:</th>
                        <td>
                            <select id="department" name="department" class="easyui-combobox"
                                    data-options="width:140,height:29,editable:false,panelHeight:240">
                                <option value="0">请选择部门名称</option>
                                <c:forEach items="${colleges}" var="college">
                                    <option value="${college.collid}">${college.name}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <th>所属学期:</th>
                        <td>
                            <select id="term" name="term" class="easyui-combobox"
                                    data-options="width:150,height:29,editable:false,panelHeight:300">
                                <option value="0">请选择学期</option>
                                <c:forEach items="${terms}" var="term">
                                    <option value="${term.termid}">${term.termname}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <th>课程类型:</th>
                        <td>
                            <select id="coursetype" name="coursetype" class="easyui-combobox"
                                    data-options="width:140,height:29,editable:false,panelHeight:200">
                                <option value="">请选择课程类型</option>
                                <option value="学科基础课">学科基础课</option>
                                <option value="专业核心课">专业核心课</option>
                                <option value="普通课">普通课</option>
                                <option value="双语课">双语课</option>
                                <option value="网络自主学习课">网络自主学习课</option>
                                <option value="课程设计">课程设计</option>
                                <option value="毕业设计">毕业设计</option>
                                <option value="学年论文">学年论文</option>
                                <option value="实习实训">实习实训</option>
                            </select>
                        </td>
                        <th>课程名称:</th>
                        <td>
                            <input id="kcm" name="kcm" class="easyui-validatebox textbox"
                                   style="width:150px; height:29px;" placeholder="课程名称(可以不输入)">
                        </td>
                        <th>任课老师:</th>
                        <td>
                            <input id="skls" name="skls" class="easyui-validatebox textbox"
                                   style="width:150px; height:29px;" placeholder="授课老师(可以不输入)">

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
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editInfo()">Edit</a>
        <!--
        <a href="javascript:void(0);" onclick="datacheck();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">数据校验</a>
        <span>&nbsp;|&nbsp;</span>
        --->
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="removeAll()">清理数据</a>

    </div>
</div>
<!--中央区域结束-->


<!--添加附件的对话框组件-->
<div id="attachmentDialog" class="easyui-dialog" style="width:650px;height:350px;"
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
        </div>
        <div class="ftitle">
            请确保待上传的数据格式严格按模板表格做好的数据，在Excel中是第一个表格。
            <img src="${pageContext.request.contextPath}/statics/style/images/png/kc.png" width="600" height="180">
        </div>
    </form>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">Course Informaton</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>First Name:</label>
            <input name="firstname" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>Last Name:</label>
            <input name="lastname" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>Phone:</label>
            <input name="phone">
        </div>
        <div class="fitem">
            <label>Email:</label>
            <input name="email" class="easyui-validatebox" validType="email">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
<script type="text/javascript">
    var dataGrid;
    $(function () {
        //使用js生成datagrid
        dataGrid = $("#kcdg").datagrid({
            url:"findcourse",
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
                        if(row.college){
                            return row.college.name;
                        }else{
                            return "--";
                        }
                    }
                },
                {field:"termname",title:"学期",width:100,
                    formatter: function(value,row,index){
                        if(row.term){
                            return row.term.termname;
                        }else{
                            return "--";
                        }
                    }
                },
                {field:"kch",title:"课程号",width:80},
                {field:"kxh",title:"课序号",width:50},
                {field:"kcm",title:"课程名",width:160,
                    formatter:function(value,row,index){
                        return "<a href='#' title='" + row.errmsg+ "' class='easyui-tooltip'>"+value+"</a>";
                    }
                },
                {field:"xkrs",title:"选课人数",width:50},
                {field:"zxs",title:"总学时",width:50},
                {field:"skxs",title:"理论学时",width:60},
                {field:"sjxs",title:"上机学时",width:60},
                {field:"syxs",title:"实验学时",width:60},
                {field:"xf",title:"学分",width:50},
            ]],
            columns:[[
                {field:"skls",title:"授课老师",width:60},
                {field:"lszc",title:"职称",width:60},
                {field:"kcsx",title:"课程属性",width:80},
                {field:"bjmc",title:"班级名称",width:120},
                {field:"kclx",title:"课程类别",width:100},
                {field:"sfcxk",title:"核心课?",width:80,
                    formatter:function(value,row,index) {
                        if(row.sfcxk==1) return "<span style='color:red;'>是</span>"
                        else return "否"
                    }
                },
                {field:"bz",title:"备注(实习类型)",width:120},
                {field:"kclx1",title:"课程类型1",width:100},
                {field:"kclx2",title:"课程类型2",width:100},
                {field:"kcxs",title:"课程系数",width:60},
                {field:"rsxs",title:"人数系数",width:60},
                {field:"lljxgzl",title:"理论教学工作量",width:100},
                {field:"sjjxgzl",title:"实践教学工作量",width:100,
                    formatter:function (value,row,index) {
                        if(value==0){
                            return value;
                        }else{
                            return "<a href='javascript:void(0)' title='点击查看实验分批次情况'" +"" +
                                " onclick=sydetail("+row.xq+","+row.yxid+",'"+row.kch+"','"+row.kxh+"')>" + value + "</a>";
                        }
                    }
                },
                {field:"sumgzl",title:"总工作量",width:100},
                {field:"cwd",title:"错误点",width:100},
                {field:"jy",title:"校验",width:100},
                {field: 'action', title: '操作', width: 130,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="department-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-mini-edit\'" onclick="coursegzlwindow(\'{0}\');" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="department-easyui-linkbutton-delete" data-options="plain:true,iconCls:\'icon-delete\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }


            ]],
            onLoadSuccess: function (data) {
                $('.department-easyui-linkbutton-edit').linkbutton({text: '编辑', plain: true, iconCls: 'icon-mini-edit'});
                $('.department-easyui-linkbutton-delete').linkbutton({text: '删除', plain: true, iconCls: 'icon-delete'});
            },
            rowStyler:function(index,data){
                /*if(data.errmsg!=""){
                    return "background-color:#FAEBD7;";
                }*/
            }
        });

        $("#uploadFile").filebox({
            buttonText:'选择',
            prompt:'请选择待待提交的文件',
            onChange:function (newValue,oldValue) {
                filecheck();
            }

        });
    });

    //实验详细
    function sydetail(xq,xyid,kch,kxh) {
        //alert(xq+","+xyid+","+kch+","+kxh);
        var params = {
            title:"分批实验数据导入",
            iconCls:"icon-application-xp",
            url:"sjdataimport?term="+xq+"&department="+xyid+"&kch="+kch+"&kxh="+kxh
        };
        window.parent.addTab(params);
    }

    //查询
    function searchFun() {
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }

    //数据校验
    function datacheck() {
        parent.$.messager.alert('提示', "数据校验暂时不提供，请确保导入的数据正确即可", 'info');
    }

    //清理所有数据
    function  removeAll() {
        parent.$.messager.confirm('询问', '执行此操作将把课程清单以及实验分批情况的数据全部清除，您是否要继续执行此操作？', function (b) {
            if (b) {
                progressLoad();
                $.ajax({
                    type: "post",  //数据的提交方式：get和post
                    url: "deletecoursedata", //数据的提交路径
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
            title: "实施课程清单数据上传(Excel文件)",
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
                    url: "uploadfile",
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
                            window.location.href = "datacheck";
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
    function coursegzlwindow(id){
        //alert(otherid);

        var _title = "数据录入";
        if(id>0) _title = "数据修改";

        parent.$.modalDialog({
            title: _title,
            width: 800,
            height: 500,
            href: "findcoursegzlByid?id=" + id,
            buttons: [{
                text: '保存',
                iconCls:'icon-save',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = $("#kcdg");
                    var f = parent.$.modalDialog.handler.find('#gzlEditForm');
                    //表单必选项校验
                    var isValid = f.form('validate');
                    if(!isValid){
                        parent.$.messager.alert('提示', "信息不正确", 'info');
                        return;
                    }
                    progressLoad();
                    $.ajax({
                        url:"updatacourse?"+f.serialize(),
                        type: "post",
                        contentType: "application/json",
                        success: function (result) {
                            progressClose();
                            //result = $.parseJSON(result);
                            if (result.success) {
                                parent.$.messager.alert('提示', "保存成功", 'info');
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
                    url: "deletecourse", //数据的提交路径
                    cache:false,
                    async:true, //默认是true：异步，false：同步。是否支持异步刷新，默认是true
                    dataType: 'json',  //服务器返回数据的类型，例如xml,String,Json等
                    data:{"id": id},  //需要提交的数据
                    success: function(result){  //请求成功后的回调函数
                        if (result.success) {
                            parent.$.messager.alert('提示', "已经成功删除", 'info');
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

</script>
</body>

</html>