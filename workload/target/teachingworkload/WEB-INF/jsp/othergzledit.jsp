<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function () {
        $("#xyid").val('${not empty otherwl?otherwl.xyid:0}');
        $("#xq").val('${not empty otherwl?otherwl.xq:0}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="othergzlEditForm">
            <table class="grid" width="100%">
                <tr>
                    <td align="right">所属学院:</td>
                    <td>
                        <select id="xyid" name="xyid" class="easyui-combobox"
                                data-options="width:240,height:29,editable:false,panelHeight:240,required:true">
                            <c:forEach items="${colleges}" var="college">
                                <option value="${college.collid}">${college.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="right">所属学期:</td>
                    <td>
                        <select id="xq" name="xq" class="easyui-combobox"
                                data-options="width:200,height:29,editable:false,panelHeight:'auto',required:true">
                            <c:forEach items="${terms}" var="term">
                                <option value="${term.termid}">${term.termname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">补贴工作量名称:</td>
                    <td><input name="gzlmc" type="text" placeholder="请输入工作量名称" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${otherwl.gzlmc}" /></td>
                    <td align="right">补贴工作量学时数:</td>
                    <td><input name="gzl" value="${otherwl.gzl}" class="easyui-numberspinner"
                               style="width:200px; height: 29px;" required="required" data-options="min:-100000,precision:2">
                    </td>
                </tr>
                <tr>
                    <td align="right">说明:</td>
                    <td colspan="3">
                        <input id="brief" name="brief" class="easyui-textbox"
                               data-options="multiline:true,width:400,height:50" prompt="请输入课时补贴描述"
                               value="${otherwl.brief}">
                        <!--其它补贴id:不为空则是修改，否则是新增-->
                        <input type="hidden" name="otherid" value="${otherwl.otherid}"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>