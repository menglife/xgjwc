<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false"  style="overflow: hidden;padding: 3px;">
        <form id="sygzlEditForm"  style="height: 500px">
            <table class="grid" width="100%">
                <tr>
                    <td align="right">学院:</td>
                    <td><input name="xyid" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${syworkload.college.name}" /></td>
                    <td align="right">学期:</td>
                    <td><input id="idxq" name="xq" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.term.termname}" /></td>
                </tr>
                <tr>

                    <td align="right">课程号:</td>
                    <td><input id="idkch" name="kch" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.kch}" /></td>
                    <td align="right">课序号:</td>
                    <td><input id="idkxh" name="kxh" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.kxh}" /></td>
                </tr>
                <tr>
                    <td align="right">实验总学时:</td>
                    <td><input id="idsyzxs" name="syzxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.syzxs}" /></td>
                    <td align="right">分批次序:</td>
                    <td><input id="idfpcx" name="fpcx" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.fpcx}" /></td>
                </tr>
                <tr>
                    <td align="right">分批学时:</td>
                    <td><input id="idfpxs" name="fpxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.fpxs}" /></td>
                    <td align="right">分批工作量:</td>
                    <td><input id="idfpgzl" name="fpgzl" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.fpgzl}" /></td>
                </tr>

                <tr>
                    <td align="right">错误点:</td>
                    <td><input name="cwd" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${syworkload.cwd}" /></td>
                    <td align="right">校验:</td>
                    <td><input name="jy" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${syworkload.jy}" /></td>
                </tr>
                <tr>
                    <td align="right">编号:</td>
                    <td><input id="idsyid"  name="syid" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${syworkload.syid}" /></td>

                    <td align="right">校验信息:</td>
                    <td><input name="errmsg" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${syworkload.errmsg}" /></td>
                </tr>
                <tr>
                    <%--<p id="idp" style="background-color:#E9E9E4"></p>--%>
                <%--</tr>--%>

            </table>
        </form>
    </div>
</div>