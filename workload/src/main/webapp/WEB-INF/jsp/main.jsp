<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>教务处教学工作量统计</title>
    <%@ include file="/commons/basejs.jsp" %>
    <!--引用echart-->
    <script type="text/javascript" src="${staticPath }/echarts/echarts.js" charset="utf-8"></script>
</head>
<body>
<div id="loading"
     style="position: fixed;top: -50%;left: -50%;width: 200%;height: 200%;background: #fff;z-index: 100;overflow: hidden;">
    <img src="${staticPath }/style/images/ajax-loader.gif"
         style="position: absolute;top: 0;left: 0;right: 0;bottom: 0;margin: auto;"/>
</div>
<div id="index_layout">
    <div data-options="region:'north',border:false"
         style=" overflow: hidden; background-color:rgb(242,242,242);">
        <div style="height:46px;line-height:46px;">
            <h2 style="margin:0;padding:0;color:black;">徐州工程学院教学工作量核算(教务处)</h2>
        </div>
        <div class="easyui-panel" title="教学工作量核算操作" data-options="border:false,iconCls:'icon-chart-line'"
             style="height:150px; overflow: hidden;">
            <div style="margin:30px 0px 0px 20px;padding:2px;float:left;">

                <a href="javascript:void(0);" class="easyui-linkbutton"
                   data-options="iconCls:'icon-large-smartart',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(1);">课程清单数据导入</a>

                <a href="javascript:void(0);" class="easyui-linkbutton"
                   data-options="iconCls:'icon-large-excel',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(2);">课程实验数据导入</a>

                <a href="javascript:void(0);" class="easyui-linkbutton"
                   data-options="iconCls:'icon-image-edit',iconAlign:'top',size:'large',plain:true" onclick="jxgzldr(3);">其它补贴数据录入</a>


                <a href="javascript:void(0);" class="easyui-linkbutton"
                   data-options="iconCls:'icon-large-shapes',iconAlign:'top',size:'large',plain:true" onclick="calgzl();">教学工作量一键统计</a>

            </div>
            <div style="margin-top:5px;padding:2px;float:left;">
                <p style="margin:2px;padding:0px;">
                    <strong>教学工作量统计说明:</strong>
                </p>
                <p style="margin:2px;padding:0px;text-indent:2em;">
                    <strong>第1步:</strong> 请按教学实施情况，完成本学年(两学期)课程清单的导入。点击左右菜单[实施课程清单数据导入]
                </p>
                <p style="margin:2px;padding:0px;text-indent:2em;">
                    <strong>第2步:</strong> 请按教学实施情况，完成本学年(两学期)分批次实验课程数据的导入。点击左右菜单[课程实验环节数据导入]
                </p>
                <p style="margin:2px;padding:0px;text-indent:2em;">
                    <strong>第3步:</strong> 请按教学实施情况，完成本学年(两学期)补助给各学院的课时数据。点击左右菜单[其它工作量补贴录入]
                </p>
                <p style="margin:2px;padding:0px;text-indent:2em;">
                    <strong>第4步:</strong> 执行右侧按钮<strong>[教学工作量一键统计]</strong>完成各学院教学工作量统计功能。
                </p>
                <p style="margin:2px;padding:0px;text-indent:2em;">
                    <strong>第5步:</strong> 完成数据的查询和导出。
                </p>
            </div>
        </div>
    </div>
    <!--
    <div data-options="region:'west',split:false" title="菜单"
         style="width:200px; overflow: hidden;overflow-y:auto; padding:0px">
        <ul class="easyui-tree">
            <li>
                <span>教学工作量核算</span>
                <ul>
                    <li>
                        <span>数据导入</span>
                        <ul>
                            <li>
                                <span><a href="javascript:void(0);" onclick="jxgzldr(1)">实施课程清单数据导入</a></span>
                            </li>
                            <li>
                                <span><a href="javascript:void(0);" onclick="jxgzldr(2)">课程实验环节数据导入</a></span>
                            </li>
                            <li>
                                <span><a href="javascript:void(0);" onclick="jxgzldr(3)">其它工作量补贴录入</a></span>
                            </li>
                        </ul>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
    -->
    <div data-options="region:'center'" style="overflow: hidden;">
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
    <div data-options="region:'south',border:false"
         style="height: 30px;line-height:30px; overflow: hidden;text-align: center;background-color: #eee">Copyright ©
        <script>
            var now = new Date();
            var year = now.getFullYear();
            document.write(year);
        </script> power by <a href="http://www.xzit.edu.cn/" target="_blank">徐州工程学院</a></div>
</div>

<script type="text/javascript">
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
                url:"dataimport"
            };
        }else if(num==2){
            params = {
                title:"分批实验数据导入",
                iconCls:"icon-application-xp",
                url:"sjdataimport"
            };
        }else if(num==3){
            params = {
                title:"其它工作量录入",
                iconCls:"icon-application-add",
                url:"othergzlindex"
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
    }
</script>

</body>
</html>