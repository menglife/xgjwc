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
    <title>教学工作量核算</title>
    <%@ include file="/commons/basejs.jsp" %>
    <script type="text/javascript">
        var url;

        //查询
        function searchFun() {
            dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
        }

    </script>
</head>
<body class="easyui-layout" style="margin:0 1px;background-color:#f5f5f5 !important;">
<div data-options="region:'north',split:true" style="height:80px; background:#19aa8d;color:#f5f5f5;" id="xyy_header; ">
    <div class="easyui-layout" data-options="fit:true">
        <div style="float:left;width:40%;padding:18px 0 0 15px;">
            <h2 style="margin:0;padding:0;color:black;">徐州工程学院教学工作量核算<a style="color: aquamarine">${requestScope.user.college.nick}</a></h2>
        </div>
        <div style="float:right;width:56%;">
            <div class="xyy_tool">
                <ul style="float:right;position: relative;right:0;margin:0;">
                    <li ><a href="#" ><i class="xyy-hello" style="position: absolute;display:block;width: 16px;height: 16px;top: 50%;margin: -8px 12px;"></i>${requestScope.user.name}</a></li>
                    <li  onclick="openpanel()" ><a ><i class="xyy-mima" style="position: absolute;display:block;width: 16px;height: 16px;top: 50%;margin: -8px 12px;"></i>修改密码</a></li>

                    <li ><a href="/loginpage"><i class="xyy-tuichu" style="position: absolute;display:block;width: 16px;height: 16px;top: 50%;margin: -8px 12px;"></i>退出登录</a></li>
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
                            <h1 style="margin:0 0 10px 0;">  欢迎您</h1>
                            <ul style="list-style-type:none;padding:0;">

                                <li style="margin-bottom:10px;"><a href="#" style="text-decoration:none;font-size:16px;color:#2f4050;"><i class="xyy-time" style="display:block;width: 16px;height:16px;float:left;margin:2px 3px;"></i>现在是：<span id="timer" style="color:#19aa8d;font:16px tahoma;height:17px;"><script>setInterval("timeStr=new Date().toLocaleString();timer.innerText=timeStr;",1000)</script></span></a>
                                </li>
                            </ul>
                        </div>
                        <div data-options="region:'center',border:false" style="padding-left:30px;">
                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-large-smartart',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(1);">课程清单数据</a>

                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-large-excel',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(2);">课程实验数据</a>

                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-image-edit',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(3);">其它补贴数据</a>


                            <a href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-large-shapes',iconAlign:'top',size:'large',plain:true" onclick="calgzl();">教学工作量一键统计</a>

                        <%--<div class="jiankong" data-options="region:'center',border:false">--%>
                                <%--<div class="juxing"><a href="#">数据校验</a></div>--%>
                            <%--</div>--%>
                        </div>

                    </div>
                </div>
                <div data-options="region:'center',border:false">

                    <div id="index_tabs" style="overflow: hidden;">
                        <div title="工作量核算首页" data-options="border:false" style="overflow: auto;">
                            <div class="easyui-tabs" style="width:100%;height:450px">
                                <div title="统计图表" style="padding:10px">
                                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                                    <div id="main" style="width:90%;height:360px;background-color:white;text-align:left;"></div>
                                </div>
                                <div title="统计数据">
                                    <!--统计数据显示区域-->
                                    <table id="gzlsumtbl" class="easyui-datagrid" title="各学院工作量统计数据表"
                                           style="width:100%;height:100%"> </table>
                                </div>
                            </div>
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

<div data-options="region:'south',border:false"
     style="height: 30px;line-height:30px; overflow: hidden;text-align: center;background-color: #eee">Copyright ©
    <script>
        var now = new Date();
        var year = now.getFullYear();
        document.write(year);
    </script> power by <a href="http://www.xzit.edu.cn/" target="_blank">徐州工程学院</a></div>
<%--修改密码面板--%>
<div id="dialog" modal="true" title="修改密码" draggable="false" closed="true" class="easyui-dialog" style="width: 300px ;height: 300px">
    <form id="myForm">
        <table>
            <tr>
                <input type="hidden" name="id" value=""/>
                <td>用户名：</td>
                <td><input name="username" type="text"  class="easyui-validatebox" value="${requestScope.user.name}"
                           style="height:25px;margin:0;padding:0 2px;box-sizing:content-box;"
                           data-options="required:true" value="" missingMessage="用户名不能为空" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>旧密码：</td>
                <td><input name="password2" type="password" placeholder="请输入旧密码" class="easyui-passwordbox"
                           style="height:25px;margin:0;padding:0 2px;box-sizing:content-box;"
                           data-options="required:true" value="" missingMessage="旧密码不能为空">
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input id="password" name="password" validType="length[4,32]"
                           class="easyui-validatebox" required="true" type="password" value=""/>
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" name="repassword"
                           id="repassword" required="true" class="easyui-validatebox"
                           validType="equalTo['#password']" invalidMessage="两次输入密码不匹配"/>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <a class="easyui-linkbutton" id="submit">提交</a>&nbsp;&nbsp;
                    <a class="easyui-linkbutton" id="reset">取消</a>
                </td>
            </tr>
            </tr>
        </table>
    </form>
</div>
<%--end--%>
<script type="text/javascript">
    <%-- js生成数据清单--%>
    var index_layout;
    var index_tabs;
    var index_tabsMenu;
    var layout_west_tree;
    //echart图表选项
    var option;
    //echart图表对象
    var myChart;
    $(function () {
        index_layout = $('#index_layout').layout({
            fit: true
        });

        $("#index_tabs").contextMenus();

        index_tabs = $('#index_tabs').tabs({
            fit: true,
            border: false,
            tools: [{
                iconCls: 'icon-home',
                handler: function () {
                    index_tabs.tabs('select', 0);
                }
            }, {
                iconCls: 'icon-refresh',
                handler: function () {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    index_tabs.tabs('getTab', index).panel('open').panel('refresh');
                }
            }, {
                iconCls: 'icon-del',
                handler: function () {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    if (tab.panel('options').closable) {
                        index_tabs.tabs('close', index);
                    }
                }
            }]
        });
        //echart图表统计初始化
        echartinit();

        //统计数据表格显示
        $("#gzlsumtbl").datagrid({
            singleSelect:true,
            collapsible:false,
            pagination:true,
            pageSize:30,
            pageList:[30],
            singleSelect: true,
            rownumbers: true,
            showFooter: true,
            columns:[[
                {field:"nick",title:"所属学院",width:120},
                {field:"lljxgzl",title:"理论教学工作量",width:150},
                {field:"sjjxgzl",title:"实践教学工作量",width:150},
                {field:"kcsumgzl",title:"理论+实践教学工作量",width:150},
                {field:"othergzl",title:"其它补助工作量",width:150},
                {field:"totalgzl",title:"工作量小计",width:150},
                {field:"action",title:"操作",width:100,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="department-easyui-linkbutton-export"  data-options="plain:true,iconCls:\'icon-page-excel\'" onclick="dataexport(\'{0}\',\'{1}\');" >导出</a>', row.collid,row.totalgzl);
                        return str;
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $('.department-easyui-linkbutton-export').linkbutton({text: '导出', plain: true, iconCls: 'icon-page-excel'});
            }
        });
    });

    //数据导出
    function dataexport(collid,totalgzl) {
        //alert(collid);
        if(collid==undefined || totalgzl==undefined){

        }else if(collid==0){
            //Excel导出所有部门的统计表
            window.location.href="allgzlexport";
        }else if(collid>0){
            window.location.href="totalexport?xyid=" + collid;
        }
    }

    function addTab(params) {
        var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
        var t = $('#index_tabs');
        var opts = {
            title: params.title,
            closable: true,
            iconCls: params.iconCls,
            content: iframe,
            border: false,
            fit: true
        };
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
            var currentTab = $('#index_tabs').tabs('getSelected');
            RefreshTab(currentTab);
        } else {
            t.tabs('add', opts);
        }
    }

    //刷新当前标签Tabs
    function RefreshTab(currentTab) {
        var url = $(currentTab.panel('options')).attr('href');
        $('#index_tabs').tabs('update', {
            tab: currentTab,
            options: {
                href: url
            }
        });
        currentTab.panel('refresh');
    }

    //教学工作量录入
    function jxgzldr(num) {
        var params;
        if(num==1){
            params = {
                title:"所开课程数据导入",
                iconCls:"icon-application-view-gallery",
                url:"coursedataindex"
            };
        }else if(num==2){
            params = {
                title:"分批实验数据导入",
                iconCls:"icon-application-xp",
                url:"sydataindex"
            };
        }else if(num==3){
            params = {
                title:"其它工作量录入",
                iconCls:"icon-application-add",
                url:"othergzlindex2"
            };
        }

        addTab(params);
    }

    //图表工作初始化
    function echartinit() {
        myChart = echarts.init(document.getElementById('main'));
        //图表显示提示信息
        //图表显示提示信息
        myChart.showLoading();
        //定义图表options
        option = {
            title : {
                text: '徐州工程学院教学工作量统计图表',
                subtext: '各二级学院教学工作量统计'
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params){
                    return params[0].name + '<br/>'
                        + params[0].seriesName + ' : ' + params[0].value + '<br/>'
                        + params[1].seriesName + ' : ' + params[1].value +  '<br/>'
                        + params[2].seriesName + ' : ' + params[2].value +  '<br/>'
                        + "教学工作量之和:" + (params[2].value + params[1].value + params[0].value).toFixed(2);
                }
            },
            legend: {
                selectedMode:false,
                data:['理论教学工作量', '实践教学工作量','其它工作量']
            },
            xAxis : [
                {
                    type : 'category',
                    //待填充的x坐标上的数据，各个二级学院信息
                    data : ["学院名称"]
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    boundaryGap: [0, 0.1]
                }
            ],
            series : [
                {
                    name:'理论教学工作量',
                    type:'bar',
                    stack: 'sum',
                    barCategoryGap: '50%',
                    itemStyle: {
                        normal: {
                            color: 'tomato',
                            barBorderColor: 'tomato',
                            barBorderWidth: 6,
                            barBorderRadius:0,
                            label : {
                                show: true, position: 'insideTop'
                            }
                        }
                    },
                    //填充每个学院的理论教学工作量
                    data:[0]
                },
                {
                    name:'实践教学工作量',
                    type:'bar',
                    stack: 'sum',
                    barCategoryGap: '50%',
                    itemStyle: {
                        normal: {
                            color: '#00FFFF',
                            barBorderColor: 'tomato',
                            barBorderWidth: 6,
                            barBorderRadius:0,
                            label : {
                                show: true, position: 'insideTop'
                            }
                        }
                    },
                    //填充每个学院的实践教学工作量
                    data:[0]
                },
                {
                    name:'其它工作量',
                    type:'bar',
                    stack: 'sum',
                    itemStyle: {
                        normal: {
                            color: '#006400',
                            barBorderColor: 'tomato',
                            barBorderWidth: 6,
                            barBorderRadius:0,
                            label : {
                                show: true,
                                position: 'top',
                                formatter: function (params) {
                                    for (var i = 0, len = option.xAxis[0].data.length; i < len; i++) {
                                        //alert("len=" + len + "[" + option.xAxis[0].data + "],name=" + params.name + ",value=" + params.value);
                                        if (option.xAxis[0].data[i] == params.name) {
                                            return (option.series[0].data[i] + option.series[1].data[i] + params.value).toFixed(2);
                                        }
                                    }
                                },
                                textStyle: {
                                    color: 'tomato'
                                }
                            }
                        }
                    },
                    //填充每个学院其它教学工作量，包括补助
                    data:[0]
                }
            ]
        };
        myChart.hideLoading();
        myChart.setOption(option,true);
    }

    //工作量统计生成图表
    function calgzl() {
        //提示是否要进行数据统计，统计前需要确保课程信息和课程实践环节数据都已经导入完毕
        $.messager.confirm('提示', '在进行[工作量一键统计]功能前，请确保课程信息和课程实践环节数据都已经导入完毕，继续执行统计吗?', function(r) {
            if (r) {
                index_tabs.tabs('select', 0);
                //先进行实验数据的统计
                progressLoad();
                $.ajax({
                    type: "post",  //数据的提交方式：get和post
                    url: "sygzltotal", //数据的提交路径
                    cache:false,
                    async:true, //默认是true：异步，false：同步。是否支持异步刷新，默认是true
                    dataType: 'json',  //服务器返回数据的类型，例如xml,String,Json等
                    success: function(result){  //请求成功后的回调函数
                        if (result.success) {
                            //进行工作量统计
                            totalAndGeneratorbar(0);
                        }else {
                            progressClose();
                            parent.$.messager.alert('警告',"实验数据工作量统计出现错误。", 'warning');
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
    //统计总工作量并形成图表
    function totalAndGeneratorbar(termid){
        //通过Ajax获取数据
        $.ajax({
            type: "post",
            async: true, //同步执行
            url: "${path}/generatorBarEchartBar?termid=" + termid,
            dataType: "json", //返回数据形式为json
            success: function (result) {
                if (result) {
                    myChart.showLoading();
                    //将返回的category和series对象赋值给options对象内的category和series
                    //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                    option.xAxis[0].data = result.category;
                    option.series[0].data = result.llgzldata;
                    option.series[1].data = result.sjgzldata;
                    option.series[2].data = result.othergzldata;
                    myChart.hideLoading();
                    myChart.setOption(option,true);
                    $("#gzlsumtbl").datagrid("loadData", result.datagrid);
                }
            },
            error: function (errorMsg) {
                parent.$.messager.alert('错误', "图表请求数据失败！", 'error');
            }
        });
    };
    function openpanel() {
        $('#dialog').dialog('open');
    };
    $('#reset').click(function () {
        $('#dialog').dialog('close');
    });
    $('#submit').click(function () {
        if($('#myForm').form('validate')){
            $.ajax({
                method:'post',
                url:'updataInfo',
                cache:false,
                data:$('#myForm').serialize(),
                dataType:'json',
                success:function (result) {
                    $('#dialog').dialog('close');
                    $.messager.show({
                        title:result.status,
                        msg:result.message
                    });
                },
                error:function () {
                    alert("操作失败，请检查！");
                }
            })
        }
    });

</script>
</body>