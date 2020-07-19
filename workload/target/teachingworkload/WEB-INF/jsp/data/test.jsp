<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/basejs.jsp" %>
<!DOCTYPE html>
<html>
<head>
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
<div data-options="region:'center'">
    <table id="kcdg" data-options="fit:true,border:false,toolbar:'#tb'"></table>
    <div id="tb">
        <span>&nbsp;|&nbsp;</span>
        <a href="javascript:void(0);" onclick="uploadFun();" class="easyui-linkbutton" iconCls="icon-add" plain="true">导入数据</a>
        <span>&nbsp;|&nbsp;</span>
        <!--
        <a href="javascript:void(0);" onclick="datacheck();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">数据校验</a>
        <span>&nbsp;|&nbsp;</span>
        --->
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:$('#kcdg').edatagrid()">编辑</a>
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="removeAll()">清理数据</a>

    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">Course Information</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>First Name:</label>
            <input name="firstname" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>Last Name:</label>
            <input name="lastname" class="easyui-validatebox" required="true">
        </div>

    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
<script type="text/javascript">
    $('#kcdg').datagrid({
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
            {field:"xkrs",title:"选课人数",width:50,},
            {field:"zxs",title:"总学时",width:50,},
            {field:"skxs",title:"理论学时",width:60,},
            {field:"sjxs",title:"上机学时",width:60,},
            {field:"syxs",title:"实验学时",width:60,},
            {field:"xf",title:"学分",width:50,},
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
            {field:"sumgzl",title:"总工作量",width:100}
        ]],
    })
    //查询
    function searchFun() {
    //    $('#kcdg').datagrid('load', $.serializeObject($('#searchForm')));
        $('#kcdg').datagrid('load', $('#searchForm').serializeObject());
    }
    /*
    //修改信息
    function editUser() {
        var row = $('#kcdg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('setTitle','Edit User');
            $('#fm').form('load',row);
            url = 'update_user.php?id='+row.id;//接口正确就可以保持你数据了
        }
    }*/

    var editIndex = undefined;
    function onClickRow(index){
        if (editIndex != index){
            if (endEditing()){
                $('#kcdg').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
                editIndex = index;
            } else {
                $('#kcdg').datagrid('selectRow', editIndex);
            }
        }
    }
</script>
</body>
</html>
