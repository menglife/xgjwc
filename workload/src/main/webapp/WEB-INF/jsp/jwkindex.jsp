<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/2
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <%@ include file="/commons/basejs.jsp" %>
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增');
            $('#fm').form('clear');
            url = '';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','编辑');
                $('#fm').form('load',row);
                url = '?id='+row.id;
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                        $('#dlg').dialog('close');		// close the dialog
                        $('#dg').datagrid('reload');	// reload the user data
                    } else {
                        $.messager.show({
                            title: 'Error',
                            msg: result.msg
                        });
                    }
                }
            });
        }
        function removeUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to remove info?',function(r){
                    if (r){
                        $.post('remove_user.php',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');	// reload the user data
                            } else {
                                $.messager.show({	// show error message
                                    title: 'Error',
                                    msg: result.msg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
</head>
<body  class="easyui-layout" style="margin:0 1px;background-color:#f5f5f5 !important;">
<div data-options="region:'north',split:true" style="height:80px; background:#19aa8d;color:#f5f5f5;" id="xyy_header; ">
    <div class="easyui-layout" data-options="fit:true">
        <div style="float:left;width:40%;padding:18px 0 0 15px;">
            <h2 style="margin:0;padding:0;color:black;">徐州工程学院<a ></a>教学工作量核算(教务科)</h2>
        </div>
        <div style="float:right;width:56%;">
            <div class="xyy_tool">
                <ul style="float:right;position: relative;right:0;margin:0;">
                    <li><a href="/login"><i class="xyy-tuichu" style="position: absolute;display:block;width: 16px;height: 16px;top: 50%;margin: -8px 12px;"></i>退出登录</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'west',title:'平台管理主菜单',split:true" style="width:200px;">
    <div id="menu" class="easyui-accordion" fit="true" border="ture">
        <div title="系统设置" data-options="iconCls:'icon-shezhi',selected:true" style="overflow:auto;padding:10px;">
            <ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
                <li>
                    <span>课程管理</span>
                    <ul>

                        <li>
                            <span><a href="#" onclick="addTab()">信息管理</a></span>
                        </li>
                    </ul>
                </li>
                <li>
                    <span>课程信息</span>
                    <ul>
                        <li>
                            <span><a href="#" onclick="addTab()">其他信息</a></span>
                        </li>

                    </ul>
                </li>
            </ul>
        </div>
        <div  data-options="iconCls:'icon-guanli'" style="padding:10px;">
            content2
        </div>
        <div  data-options="iconCls:'icon-shezhi'" style="overflow:auto;padding:10px;">
            content3
        </div>
        <div  data-options="iconCls:'icon-guanli'" style="padding:10px;">
            content2
        </div>
        <div data-options="iconCls:'icon-guanli'" style="overflow:auto;padding:10px;">
            content3
        </div>
        <div title="用户积分设置" data-options="iconCls:'icon-shezhi'" style="overflow:auto;padding:10px;">
            content3
        </div>
    </div>

</div>
<div data-options="region:'center'" style="background:#fff;border:0;">
    <div id="tb" class="easyui-tabs" data-options="tools:'#tab-tools',fit:true">
        <div title="我的主页" iconCls="icon-home" style="padding:15px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'north',border:false" style="height:130px;border-bottom:1px #a7b1c2 dashed;padding:5px;">
                    <div class="easyui-layout" data-options="fit:true">
                        <div data-options="region:'west',border:false" style="width:350px;height:150px;border-right:1px #a7b1c2 dashed;padding:5px;color:#2f4050;">
                            <h1 style="margin:0 0 10px 0;">    欢迎您</h1>
                            <ul style="list-style-type:none;padding:0;">
                                <li style="margin-bottom:10px;">
                                    <a href="#" style="text-decoration:none;font-size:16px;color:#2f4050;"><i class="xyy-hello" style="display:block;width: 16px;height:16px;float:left;margin:2px 3px;"></i>您好,<span class="tag" style="color:red;"><a ></a></span>!</a>
                                </li>
                                <li style="margin-bottom:10px;"><a href="#" style="text-decoration:none;font-size:16px;color:#2f4050;"><i class="xyy-time" style="display:block;width: 16px;height:16px;float:left;margin:2px 3px;"></i>现在是：<span id="timer" style="color:#19aa8d;font:16px tahoma;height:17px;"><script>setInterval("timeStr=new Date().toLocaleString();timer.innerText=timeStr;",1000)</script></span></a>
                                </li>
                            </ul>
                        </div>
                        <div data-options="region:'center',border:false" style="padding-left:30px;">
                            <div class="jiankong" data-options="region:'center',border:false">
                                <div class="juxing"><a href="#">课程清单数据</a></div>
                            </div>
                            <div class="jiankong" data-options="region:'center',border:false">
                                <div class="juxing"><a href="#">课程实验数据</a></div>
                            </div>
                            <div class="jiankong" data-options="region:'center',border:false">
                                <div class="juxing"><a href="#">其他补贴数据</a></div>
                            </div>
                            <div class="jiankong" data-options="region:'center',border:false">
                                <div class="juxing"><a href="#">数据校验</a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div data-options="region:'center',border:false">
                    <div data-options="region:'center',border:false" style="margin-top:20px;">
                        <table id="kcdg" title="数据清单" iconCls="icon-dingdan" class="easyui-datagrid" style="width:100%;height:400px;"
                               data-options="idField:'id',rownumbers:false,fitColumns:true,pagination:true,singleSelect:true,collapsible:true,toolbar:'#toolbar',url:'',method:'get',checkOnSelect:'true',selectOnCheck:'true'">

                        </table>
                        <div data-options="region:'center',border:false" style="margin-top:20px;">

                            <form id="searchForm">
                                <tr>

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
                                    <th>课程名称:</th>
                                    <td>
                                        <input id="kcm" name="kcm" class="easyui-validatebox textbox"
                                               style="width:150px; height:29px;" placeholder="课程名称(可以不输入)">
                                    </td>
                                    <th>课序号:</th>
                                    <td>
                                        <input id="kxh" name="kxh" class="easyui-validatebox textbox"
                                               style="width:150px; height:29px;" placeholder="课序号(可以不输入)">
                                    </td>
                                    <th>任课老师:</th>
                                    <td>
                                        <input id="skls" name="skls" class="easyui-validatebox textbox"
                                               style="width:150px; height:29px;" placeholder="授课老师(可以不输入)">

                                        <a href="javascript:void(0);" class="easyui-linkbutton"
                                           data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
                                    </td>

                                </tr>
                            </form>

                            <div id="toolbar">
                                <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新 增</a>
                                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编 辑</a>
                                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">移 除</a>
                                <a href="#" class="easyui-linkbutton" plain="true">
                                    <span>丨选择模式: </span>
                                    <select onchange="$('#dg').datagrid({singleSelect:(this.value==1)})">
                                        <option value="1">单选</option>
                                        <option value="0">全选</option>
                                    </select>
                                </a>

                            </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div id="tab-tools" style="background-color:#3c4656;">
        <a href="javascript:void(0)" onclick="removePanel()">关闭当前</a>
        <span>丨</span>
        <a href="javascript:void(0)" onclick="closeAll()">关闭全部</a>
    </div>
</div>
</div>
<div data-options="region:'south',split:true" style="height:40px;text-align:center;line-height:30px;background:#19aa8d;color:#f5f5f5"> <a href="http://www.xzit.edu.cn/" target="_blank">徐州工程学院</a></div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
    <div class="ftitle">课程信息</div>
    <form id="fm" method="post" novalidate>
        <div class="fitem">
            <label>学  期:</label>
            <input name="firstname" class="easyui-validatebox" required>
        </div>
        <div class="fitem">
            <label>课程号:</label>
            <input name="lastname" class="easyui-validatebox" required>
        </div>
        <div class="fitem">
            <label>课序号:</label>
            <input name="phone">
        </div>
        <div class="fitem">
            <label>课程名:</label>
            <input name="add" class="easyui-validatebox" validType="email">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
</div>

<script type="text/javascript">
    //关闭所有的tab
    function closeAll(){
        var tiles = new Array();
        var tabs = $('#tb').tabs('tabs');
        var len =  tabs.length;
        if(len>0){
            for(var j=0;j<len;j++){
                var a = tabs[j].panel('options').title;
                tiles.push(a);
            }
            for(var i=1;i<tiles.length;i++){
                $('#tb').tabs('close', tiles[i]);
            }
        }
    }
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
            pageSize:10,
            pageList:[10,20,30,40,50],
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

        });
    });
    //表格分页
    // var pager = $('#dg').datagrid('getPager');    // get the pager of datagrid
    // pager.pagination({,
    //     showPageList:false,
    //     buttons:[{
    //         iconCls:'icon-search',
    //         handler:function(){
    //             alert('search');
    //         }
    //     },{
    //         iconCls:'icon-add',
    //         handler:function(){
    //             alert('add');
    //         }
    //     },{
    //         iconCls:'icon-edit',
    //         handler:function(){
    //             alert('edit');
    //         }
    //     }],
    //     onBeforeRefresh:function(){
    //         alert('before refresh');
    //         return true;
    //     }
    // });

</script>
</body>
</html>
