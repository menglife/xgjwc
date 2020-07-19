<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<div  class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <div id="passlayout" class="easyui-dialog">
        <form  id="updatapass">
            <table class="grid" width="100%">
                <tr>

                    <td align="right">用户名:</td>
                    <td><input name="username" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${requestScope.user.name}" /></td>

                </tr>
                <tr>
                    <td align="right">密码:</td>
                    <td><input name="password" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  /></td>
                </tr>

            </table>
        </form>
        </div>
    </div>
</div>
