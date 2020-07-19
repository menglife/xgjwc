/**
 *
 * @requires jQuery
 *
 * 当页面加载完毕关闭加载进度
 * **/
$(window).load(function(){
    $("#loading").fadeOut();
});

/**
 * 使panel和datagrid在加载时提示
 *
 * @requires jQuery,EasyUI
 *
 */
$.fn.panel.defaults.loadingMessage = '加载中....';
$.fn.datagrid.defaults.loadMsg = '加载中....';

/**
 * @requires jQuery,EasyUI
 *
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 */
$.fn.panel.defaults.onBeforeDestroy = function() {
    var frame = $('iframe', this);
    try {
        if (frame.length > 0) {
            for ( var i = 0; i < frame.length; i++) {
                frame[i].src = '';
                frame[i].contentWindow.document.write('');
                frame[i].contentWindow.close();
            }
            frame.remove();
            if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
                try {
                    CollectGarbage();
                } catch (e) {
                }
            }
        }
    } catch (e) {
    }
};

$.fn.contextMenus=function(){
    var $tabs=$(this);

    var temphtml='<div id="tabs-contextmenuparent"><div id="tabs-contextmenu" class="easyui-menu" style="width:150px">'+
        '<div id="mm-tabclose">关闭</div>'+
        '<div id="mm-tabcloseall">关闭全部</div>'+
        '<div id="mm-tabcloseother">关闭其他</div>'+
        '<div class="menu-sep"></div>'+
        '<div id="mm-tabcloseright">关闭右侧标签</div>'+
        '<div id="mm-tabcloseleft">关闭左侧标签</div>'+
        '</div></div>';
    $("body").append(temphtml);
    $.parser.parse($('#tabs-contextmenuparent'));
    var $menus=$("#tabs-contextmenu");
    $(document).on("dblclick",".tabs-inner",function(){
        var currtab_title = $(this).children("span").text();
        var $link=$(".tabs-title:contains("+currtab_title+")",$tabs);
        if($link.is('.tabs-closable')){
            $tabs.tabs('close',currtab_title);
        }
    });
    $(document).on("contextmenu",".tabs-inner",function(e){

        $menus.menu('show', {
            left: e.pageX,
            top: e.pageY
        });
        var subtitle =$(this).children("span").text();
        $menus.data("currtab",subtitle);
        return false;

    });
    //关闭当前
    $('#mm-tabclose',$menus).click(function() {
        var currtab_title = $menus.data("currtab");
        var $link=$(".tabs-title:contains("+currtab_title+")",$tabs);

        if ($link.is('.tabs-closable')) {
            $tabs.tabs('close', currtab_title);
        }
    });
    //全部关闭
    $('#mm-tabcloseall',$menus).click(function() {
        $('.tabs-inner span',$tabs).each(function(i, n) {
            if ($(this).is('.tabs-closable')) {
                var t = $(n).text();
                $tabs.tabs('close', t);
            }
        });
    });
    //关闭除当前之外的TAB
    $('#mm-tabcloseother',$menus).click(function() {
        var currtab_title = $menus.data("currtab");
        $('.tabs-inner span').each(function(i, n) {
            if ($(this).is('.tabs-closable')) {
                var t = $(n).text();
                if (t != currtab_title)
                    $tabs.tabs('close', t);
            }
        });
    });
    //关闭当前右侧的TAB
    $('#mm-tabcloseright',$menus).click(function() {
        var currtab_title = $menus.data("currtab");
        var $li=$(".tabs-title:contains("+currtab_title+")",$tabs).parent().parent();

        var nextall = $li.nextAll();
        if (nextall.length == 0) {
            parent.$.messager.alert('提示','已经是最后一个了!','warning');
            return false;
        }
        nextall.each(function(i, n) {
            if ($('a.tabs-close', $(n)).length > 0) {
                var t = $('a:eq(0) span', $(n)).text();
                $tabs.tabs('close', t);
            }
        });
        return false;
    });
    //关闭当前左侧的TAB
    $('#mm-tabcloseleft',$menus).click(function() {
        var currtab_title = $menus.data("currtab");
        var $li=$(".tabs-title:contains("+currtab_title+")",$tabs).parent().parent();

        var prevall =$li.prevAll();
        if (prevall.length == 1) {
            parent.$.messager.alert('提示','已经是第一个了!','warning');
            return false;
        }
        prevall.each(function(i, n) {
            if ($('a.tabs-close', $(n)).length > 0) {
                var t = $('a:eq(0) span', $(n)).text();
                $tabs.tabs('close', t);
            }
        });
        return false;
    });
};



/**
 *
 *
 * @requires jQuery,EasyUI
 *
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
    var l = left;
    var t = top;
    if (l < 1) {
        l = 1;
    }
    if (t < 1) {
        t = 1;
    }
    var width = parseInt($(this).parent().css('width')) + 14;
    var height = parseInt($(this).parent().css('height')) + 14;
    var right = l + width;
    var buttom = t + height;
    var browserWidth = $(window).width();
    var browserHeight = $(window).height();
    if (right > browserWidth) {
        l = browserWidth - width;
    }
    if (buttom > browserHeight) {
        t = browserHeight - height;
    }
    $(this).parent().css({/* 修正面板位置 */
        left : l,
        top : t
    });
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

/**
 *
 *
 * @requires jQuery,EasyUI
 *
 * 通用错误提示
 *
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 */
var easyuiErrorFunction = function(XMLHttpRequest) {
    parent.$.messager.alert('错误', XMLHttpRequest.responseText);
};
$.fn.datagrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.treegrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.tree.defaults.onLoadError = easyuiErrorFunction;
$.fn.combogrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.combobox.defaults.onLoadError = easyuiErrorFunction;
$.fn.form.defaults.onLoadError = easyuiErrorFunction;

/**
 *
 *
 * @requires jQuery,EasyUI
 *
 * 为datagrid、treegrid增加表头菜单，用于显示或隐藏列，注意：冻结列不在此菜单中
 */
var createGridHeaderContextMenu = function(e, field) {
    e.preventDefault();
    var grid = $(this);/* grid本身 */
    var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
    if (!headerContextMenu) {
        var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
        var fields = grid.datagrid('getColumnFields');
        for ( var i = 0; i < fields.length; i++) {
            var fildOption = grid.datagrid('getColumnOption', fields[i]);
            if (!fildOption.hidden) {
                $('<div iconCls="tick" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
            } else {
                $('<div iconCls="bullet_blue" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
            }
        }
        headerContextMenu = this.headerContextMenu = tmenu.menu({
            onClick : function(item) {
                var field = $(item.target).attr('field');
                if (item.iconCls == 'tick') {
                    grid.datagrid('hideColumn', field);
                    $(this).menu('setIcon', {
                        target : item.target,
                        iconCls : 'bullet_blue'
                    });
                } else {
                    grid.datagrid('showColumn', field);
                    $(this).menu('setIcon', {
                        target : item.target,
                        iconCls : 'tick'
                    });
                }
            }
        });
    }
    headerContextMenu.menu('show', {
        left : e.pageX,
        top : e.pageY
    });
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;

/**
 * grid tooltip参数
 *
 *
 */
var gridTooltipOptions = {
    tooltip : function(jq, fields) {
        return jq.each(function() {
            var panel = $(this).datagrid('getPanel');
            if (fields && typeof fields == 'object' && fields.sort) {
                $.each(fields, function() {
                    var field = this;
                    bindEvent($('.datagrid-body td[field=' + field + '] .datagrid-cell', panel));
                });
            } else {
                bindEvent($(".datagrid-body .datagrid-cell", panel));
            }
        });

        function bindEvent(jqs) {
            jqs.mouseover(function() {
                var content = $(this).text();
                if (content.replace(/(^\s*)|(\s*$)/g, '').length > 5) {
                    $(this).tooltip({
                        content : content,
                        trackMouse : true,
                        position : 'bottom',
                        onHide : function() {
                            $(this).tooltip('destroy');
                        },
                        onUpdate : function(p) {
                            var tip = $(this).tooltip('tip');
                            if (parseInt(tip.css('width')) > 500) {
                                tip.css('width', 500);
                            }
                        }
                    }).tooltip('show');
                }
            });
        }
    }
};
/**
 * Datagrid扩展方法tooltip 基于Easyui 1.3.3，可用于Easyui1.3.3+
 *
 * 简单实现，如需高级功能，可以自由修改
 *
 * 使用说明:
 *
 * 在easyui.min.js之后导入本js
 *
 * 代码案例:
 *
 * $("#dg").datagrid('tooltip'); 所有列
 *
 * $("#dg").datagrid('tooltip',['productid','listprice']); 指定列
 *
 *
 */
$.extend($.fn.datagrid.methods, gridTooltipOptions);

/**
 * Treegrid扩展方法tooltip 基于Easyui 1.3.3，可用于Easyui1.3.3+
 *
 * 简单实现，如需高级功能，可以自由修改
 *
 * 使用说明:
 *
 * 在easyui.min.js之后导入本js
 *
 * 代码案例:
 *
 * $("#dg").treegrid('tooltip'); 所有列
 *
 * $("#dg").treegrid('tooltip',['productid','listprice']); 指定列
 *
 *
 */
$.extend($.fn.treegrid.methods, gridTooltipOptions);

/**
 *
 *
 * @requires jQuery,EasyUI
 *
 * 扩展validatebox，添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
    lessthan: {  //小于
        validator: function(value,param){
            return value < $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    equals: {  //等于
        validator: function(value,param){
            return value == $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    notequalto: {  //不等于
        validator: function(value,param){
            return value != $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    greaterthan: {  //大于
        validator: function(value,param){
            return value > $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    greaterthanorequalto: {  //大于等于
        validator: function(value,param){
            return value >= $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    lessthanorequalto: {  //小于等于
        validator: function(value,param){
            return value <= $(param[0]).val();
        },
        message: '内容不匹配.'
    },
    eqPwd : {
        validator : function(value, param) {
            return value == $(param[0]).val();
        },
        message : '密码不一致！'
    },
    lessThanFunds: {  //金额不能大于等于可报销金额
        validator: function(value,param){
            return value < $(param[0]).val();
        },
        message: '报销金额不能大于剩余可报销金额！.'
    }
});

//扩展tree，使其可以获取实心节点
$.extend($.fn.tree.methods, {
    getCheckedExt : function(jq) {// 获取checked节点(包括实心)
        var checked = $(jq).tree("getChecked");
        var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
        $.each(checkbox2, function() {
            var node = $.extend({}, $.data(this, "tree-node"), {
                target : this
            });
            checked.push(node);
        });
        return checked;
    },
    getSolidExt : function(jq) {// 获取实心节点
        var checked = [];
        var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
        $.each(checkbox2, function() {
            var node = $.extend({}, $.data(this, "tree-node"), {
                target : this
            });
            checked.push(node);
        });
        return checked;
    }
});

//扩展tree，使其支持平滑数据格式
$.fn.tree.defaults.loadFilter = function(data, parent) {
    var opt = $(this).data().tree.options;
    var idFiled, textFiled, parentField;
    if (opt.parentField) {
        idFiled = opt.idFiled || 'id';
        textFiled = opt.textFiled || 'text';
        parentField = opt.parentField;
        var i, l, treeData = [], tmpMap = [];
        for (i = 0, l = data.length; i < l; i++) {
            tmpMap[data[i][idFiled]] = data[i];
        }
        for (i = 0, l = data.length; i < l; i++) {
            if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
                if (!tmpMap[data[i][parentField]]['children'])
                    tmpMap[data[i][parentField]]['children'] = [];
                data[i]['text'] = data[i][textFiled];
                tmpMap[data[i][parentField]]['children'].push(data[i]);
            } else {
                data[i]['text'] = data[i][textFiled];
                treeData.push(data[i]);
            }
        }
        return treeData;
    }
    return data;
};

// 扩展treegrid，使其支持平滑数据格式
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
    var opt = $(this).data().treegrid.options;
    var idFiled, textFiled, parentField;
    if (opt.parentField) {
        idFiled = opt.idFiled || 'id';
        textFiled = opt.textFiled || 'text';
        parentField = opt.parentField;
        var i, l, treeData = [], tmpMap = [];
        for (i = 0, l = data.length; i < l; i++) {
            tmpMap[data[i][idFiled]] = data[i];
        }
        for (i = 0, l = data.length; i < l; i++) {
            if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
                if (!tmpMap[data[i][parentField]]['children'])
                    tmpMap[data[i][parentField]]['children'] = [];
                data[i]['text'] = data[i][textFiled];
                tmpMap[data[i][parentField]]['children'].push(data[i]);
            } else {
                data[i]['text'] = data[i][textFiled];
                treeData.push(data[i]);
            }
        }
        return treeData;
    }
    return data;
};

// 扩展combotree，使其支持平滑数据格式
$.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;

/**
 *
 * @requires jQuery,EasyUI
 *
 * 创建一个模式化的dialog
 *
 * @returns $.modalDialog.handler 这个handler代表弹出的dialog句柄
 *
 * @returns $.modalDialog.xxx 这个xxx是可以自己定义名称，主要用在弹窗关闭时，刷新某些对象的操作，可以将xxx这个对象预定义好
 */
$.modalDialog = function(options) {
    if ($.modalDialog.handler == undefined) {// 避免重复弹出
        var opts = $.extend({
            title : '',
            width : 840,
            height : 680,
            modal : true,
            onClose : function() {
                $.modalDialog.handler = undefined;
                $(this).dialog('destroy');
            },
            onOpen : function() {
            }
        }, options);
        opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
        return $.modalDialog.handler = $('<div/>').dialog(opts);
    }
};

$.cookie = function(key, value, options) {
    if (arguments.length > 1 && (value === null || typeof value !== "object")) {
        options = $.extend({}, options);
        if (value === null) {
            options.expires = -1;
        }
        if (typeof options.expires === 'number') {
            var days = options.expires, t = options.expires = new Date();
            t.setDate(t.getDate() + days);
        }
        return (document.cookie = [ encodeURIComponent(key), '=', options.raw ? String(value) : encodeURIComponent(String(value)), options.expires ? '; expires=' + options.expires.toUTCString() : '', options.path ? '; path=' + options.path : '', options.domain ? '; domain=' + options.domain : '', options.secure ? '; secure' : '' ].join(''));
    }
    options = value || {};
    var result, decode = options.raw ? function(s) {
        return s;
    } : decodeURIComponent;
    return (result = new RegExp('(?:^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? decode(result[1]) : null;
};

/**
 *
 * @requires jQuery
 *
 * 将form表单元素的值序列化成对象
 *
 * @returns object
 */
$.serializeObject = function(form) {
    var o = {};
    $.each(form.serializeArray(), function(index) {
        if($.trim(this['value']) != '') {  //过滤掉空字符串
            if (o[this['name']]) {
                o[this['name']] = o[this['name']] + "," + this['value'];
            } else {
                o[this['name']] = this['value'];
            }
        }
    });
    return o;
};

/*表单转成json数据*/
/*过滤空字符串，空字符串的域不生成key-value对，减少网络负担和不必要错误*/
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if($.trim(this.value) != ''){  //过滤掉空字符串
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [ o[this.name] ];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        }
    });
    return o;
}

/**
 *
 * 增加formatString功能
 *
 * 使用方法：$.formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 *
 * @returns 格式化后的字符串
 */
$.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};

/**
 *
 * 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串
 *
 * @returns list
 */
$.stringToList = function(value) {
    if (value != undefined && value != '') {
        var values = [];
        var t = value.split(',');
        for ( var i = 0; i < t.length; i++) {
            values.push('' + t[i]);/* 避免他将ID当成数字 */
        }
        return values;
    } else {
        return [];
    }
};

/**
 *
 * @requires jQuery
 *
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
    type : 'POST',
    error : function(XMLHttpRequest, textStatus, errorThrown) {
        try {
            parent.$.messager.progress('close');
            parent.$.messager.alert('错误', XMLHttpRequest.responseText);
        } catch (e) {
            alert(XMLHttpRequest.responseText);
        }
    }
});


/**
 *
 * @requires jQuery
 *
 * 去掉空格
 * **/
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, '');
};
String.prototype.ltrim = function() {
    return this.replace(/(^\s*)/g, '');
};
String.prototype.rtrim = function() {
    return this.replace(/(\s*$)/g, '');
};

/**
 *
 * @requires jQuery
 *
 * 页面加载加载进度条启用
 * **/
function progressLoad(){
    $("<div class=\"datagrid-mask\" style=\"position:absolute;z-index: 9999;\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
    $("<div class=\"datagrid-mask-msg\" style=\"position:absolute;z-index: 9999;\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
}

/**
 *
 * @requires jQuery
 *
 * 页面加载加载进度条关闭
 * **/
function progressClose(){
    $(".datagrid-mask").remove();
    $(".datagrid-mask-msg").remove();
}

/**
 *
 * @requires jQuery
 *
 * 防止退格键导致页面回退
 */
$(document).keydown(function (e) {
    var doPrevent;
    if (e.keyCode == 8) {
        var d = e.srcElement || e.target;
        if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA') {
            doPrevent = d.readOnly || d.disabled;
        }else{
            doPrevent = true;
        }
    }else{
        doPrevent = false;
    }
    if (doPrevent)
        e.preventDefault();
});

//让window居中
var easyuiPanelOnOpen = function (left, top) {
    var iframeWidth = $(this).parent().parent().width();

    var iframeHeight = $(this).parent().parent().height();

    var windowWidth = $(this).parent().width();
    var windowHeight = $(this).parent().height();

    var setWidth = (iframeWidth - windowWidth) / 2;
    var setHeight = (iframeHeight - windowHeight) / 2;
    $(this).parent().css({/* 修正面板位置 */
        left: setWidth,
        top: setHeight
    });

    if (iframeHeight < windowHeight)
    {
        $(this).parent().css({/* 修正面板位置 */
            left: setWidth,
            top: 0
        });
    }
    $(".window-shadow").hide();
};
$.fn.window.defaults.onOpen = easyuiPanelOnOpen;

/* easyui datagrid 添加和删除按钮方法*/
$.fn.extend($.fn.datagrid.methods, {
    addToolbarItem: function(jq, items){
        return jq.each(function(){
            var toolbar = $(this).parent().prev("div.datagrid-toolbar");
            for(var i = 0;i<items.length;i++){
                var item = items[i];
                if(item === "-"){
                    toolbar.append('<div class="datagrid-btn-separator"></div>');
                }else{
                    var btn=$("<a href=\"javascript:void(0)\"></a>");
                    btn[0].onclick=eval(item.handler||function(){});
                    btn.css("float","left").appendTo(toolbar).linkbutton($.extend({},item,{plain:true}));
                }
            }
            toolbar = null;
        });
    },
    removeToolbarItem: function(jq, param){
        return jq.each(function(){
            var btns = $(this).parent().prev("div.datagrid-toolbar").children("a");
            var cbtn = null;
            if(typeof param == "number"){
                cbtn = btns.eq(param);
            }else if(typeof param == "string"){
                var text = null;
                btns.each(function(){
                    text = $(this).data().linkbutton.options.text;
                    if(text == param){
                        cbtn = $(this);
                        text = null;
                        return;
                    }
                });
            }
            if(cbtn){
                var prev = cbtn.prev()[0];
                var next = cbtn.next()[0];
                if(prev && next && prev.nodeName == "DIV" && prev.nodeName == next.nodeName){
                    $(prev).remove();
                }else if(next && next.nodeName == "DIV"){
                    $(next).remove();
                }else if(prev && prev.nodeName == "DIV"){
                    $(prev).remove();
                }
                cbtn.remove();
                cbtn= null;
            }
        });
    }
});


/*Json 工具类*/
$.fn.isJson=function(str){
    var obj = null;
    try{
        obj = $.paserJson(str);
    }catch(e){
        return false;
    }
    var result = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;
    return result;
};
$.paserJson=function(str){
    return eval("("+str+")");
};


/*弹出框*/
$.fn.alert=function(title, msg, icon, callback){
    $.messager.alert(title,msg,icon,callback);
};
/*弹出框*/
$.fn.confirm=function(title, msg,callback){
    $.messager.confirm(title,msg,callback);
};
$.fn.progress=function(title,msg){
    var win = $.messager.progress({
        title: title ||'请稍等...',
        msg: msg ||'正在加载数据...'
    });
};
$.fn.closeProgress=function(){
    $.messager.progress('close');
};
/*重新登录页面*/
$.getLogin=function(){
    window.top.location= urls['path']+"/login.html";
};
$.fn.checkLogin=function(data){//检查是否登录超时
    if(data.logoutFlag){
        $.closeProgress();
        $.alert('提示',"登录超时,点击确定重新登录.",'error',$.toLogin);
        return false;
    }
    return true;
};
$.fn.ajaxSubmit=function(form,option){
    form.ajaxSubmit(option);
};
$.fn.ajaxJson=function(url,option,callback){
    $.ajax(url,{
        type:'post',
        dataType:'json',
        data:option,
        success:function(data){
            //坚持登录
            if(!$.checkLogin(data)){
                return false;
            }
            if($.isFunction(callback)){
                callback(data);
            }
        },
        error:function(response, textStatus, errorThrown){
            try{
                $.closeProgress();
                var data = $.parseJSON(response.responseText);
                //检查登录
                if(!$.checkLogin(data)){
                    return false;
                }else{
                    $.alert('提示', data.msg || "请求出现异常,请联系管理员",'error');
                }
            }catch(e){
                alert(e);
                $.alert('提示',"请求出现异常,请联系管理员",'error');
            }
        },
        complete:function(){
        }
    });
};
$.fn.submitForm=function(form,callback,dataType){
    var option =
        {
            type:'post',
            dataType: dataType||'json',
            success:function(data){
                if($.isFunction(callback)){
                    callback(data);
                }
            },
            error:function(response, textStatus, errorThrown){
                try{
                    $.closeProgress();
                    var data = $.parseJSON(response.responseText);
                    //检查登录
                    if(!$.checkLogin(data)){
                        return false;
                    }else{
                        $.alert('提示', data.msg || "请求出现异常,请联系管理员",'error');
                    }
                }catch(e){
                    alert(e);
                    $.alert('提示',"请求出现异常,请联系管理员",'error');
                }
            },
            complete:function(){

            }
        }
    $.ajaxSubmit(form,option);
};
$.fn.saveForm=function(form,callback){
    if(form.form('validate')){
        usiu.progress('请等待','保存中...');
        //ajax提交form
        $.submitForm(form,function(data){
            $.closeProgress();
            if(data.success){
                if(callback){
                    callback(data);
                }else{
                    $.alert('提示','保存成功.','info');
                }
            }else{
                $.alert('提示',data.msg,'error');
            }
        });
    }
};
/**
 *
 * @param {} url
 * @param {} option {id:''}
 */
$.fn.getById=function(url,option,callback){
    $.progress();
    $.ajaxJson(url,option,function(data){
        $.closeProgress();
        if(data.success){
            if(callback){
                callback(data);
            }
        }else{
            $.alert('提示',data.msg,'error');
        }
    });
};
$.fn.deleteForm=function(url,option,callback){
    $.progress();
    $.ajaxJson(url,option,function(data){
        $.closeProgress();
        if(data.success){
            if(callback){
                callback(data);
            }
        }else{
            $.alert('提示',result.msg,'error');
        }
    });
};


//url：窗口调用地址 title:窗口标题 width:宽度，height:高度，shadow:是否显示背景阴影罩层
$.fn.showMessageDialog=function(url,title,width,height,shadow) {
    var content='<iframe src="'+url+'" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
    var boarddiv='<div id="msgwindow" title="'+title+'" style="overflow: hidden"></div>'; //可以去掉滚动条
    $(document.body).append(boarddiv);
    var win= $('#msgwindow').dialog({
        content: content,
        width:width,
        height:height,
        model:shadow,
        title:title,
        onClose:function(){
            $(this).dialog('destroy'); //后面可以关闭后的事件
        }
    });
    win.dialog('open');
}