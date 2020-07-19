<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(document).ready(function(){
        $("#idp").mouseenter(function(){

            $("#idp").css("background-color","red");
        });
        $("#idp").mouseleave(function(){
            $("#idp").css("background-color","yellow");
        });
        $("#idxkrs").mouseleave(function() {
            if ($("#idxkrs").val() <= 50) {
                $("#idrsxs").val(1);
            } else if ($("#idxkrs").val() > 50 && $("#idxkrs").val() <= 60) {
                $("#idrsxs").val(1.1);
            } else if ($("#idxkrs").val() > 60 && $("#idxkrs").val() <= 90) {
                $("#idrsxs").val(1.2)
            }else if ($("#idxkrs").val() > 90 && $("#idxkrs").val() <= 120) {
                $("#idrsxs").val(1.4)
            }else if ($("#idxkrs").val() > 121) {
                $("#idrsxs").val(1.5)
            }
            $("#idrsxs").css("background-color","yellow");
            $("#idlljxgzl").val($("#idzxs").val()* $("#idrsxs").val()* $("#idrsxs").val())
            $("#idlljxgzl").css("background-color","yellow");
            $("#idzumgzl").val($("#idzxs").val()* $("#idrsxs").val()* $("#idrsxs").val())
            $("#idzumgzl").css("background-color","yellow");

        })

        $("#idzxs").mouseleave(function() {
            if ($("#idsjxs").val()==0) {
                $("#idskxs").val($("#idzxs").val());
            }
            $("#idskxs").css("background-color","yellow");
            $("#idlljxgzl").val($("#idzxs").val()* $("#idrsxs").val()* $("#idrsxs").val())
            $("#idlljxgzl").css("background-color","yellow");
            $("#idzumgzl").val($("#idzxs").val()* $("#idrsxs").val()* $("#idrsxs").val())
            $("#idzumgzl").css("background-color","yellow");

        })

      });










</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false"  style="overflow: hidden;padding: 3px;">
        <form id="gzlEditForm"  style="height: 500px">
            <table class="grid" width="100%">
                <tr>
                    <td align="right">课程名:</td>
                    <td><input  name="kcm" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kcm}" /></td>
                    <td align="right">课程号:</td>
                    <td><input name="kch" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kch}" /></td>
                </tr>
                <tr>

                    <td align="right">课序号:</td>
                    <td><input name="kxh" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kxh}" /></td>
                    <td align="right">选课人数:</td>
                    <td><input id="idxkrs" name="xkrs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.xkrs}" /></td>
                </tr>
                <tr>
                    <td align="right">总学时:</td>
                    <td><input id="idzxs" name="zxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.zxs}" /></td>
                    <td align="right">理论学时:</td>
                    <td><input id="idskxs" name="skxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.skxs}" /></td>
                </tr>
                <tr>
                    <td align="right">上机学时:</td>
                    <td><input id="idsjxs" name="sjxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.sjxs}" /></td>
                    <td align="right">实验学时:</td>
                    <td><input id="idsyxs" name="syxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.syxs}" /></td>
                </tr>
                <tr>
                    <td align="right">授课老师:</td>
                    <td><input name="skls" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.skls}" /></td>
                    <td align="right">学分:</td>
                    <td><input id="idxf" name="xf" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.xf}" /></td>
                </tr>
                <tr>
                    <td align="right">职称:</td>
                    <td><input name="lszc" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.lszc}" /></td>
                    <td align="right">课程属性:</td>
                    <td><input name="kcsx" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kcsx}" /></td>
                </tr>
                <tr>
                    <td align="right">班级名称:</td>
                    <td><input name="bjmc" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${curworkload.bjmc}" /></td>
                    <td align="right">课程类型:</td>
                    <td><input name="kclx" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kclx}" />


                    </td>
                </tr>

                <tr>
                    <td align="right">课程系数:</td>
                    <td><input id="idkcxs" name="kcxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.kcxs}" /></td>
                    <td align="right">人数系数:</td>
                    <td><input id="idrsxs" name="rsxs" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.rsxs}" /></td>
                </tr>
                <tr>
                    <td align="right">理论教学工作量:</td>
                    <td><input id="idlljxgzl" name="lljxgzl" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.lljxgzl}" /></td>
                    <td align="right">实践教学工作量:</td>
                    <td><input id="idsjjxgzl" name="sjjxgzl" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.sjjxgzl}" /></td>
                </tr>
                <tr>
                    <td align="right">编号:</td>
                    <td><input name="id" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.id}" /></td>
                    <td align="right">总工作量:</td>
                    <td><input id="idzumgzl" name="sumgzl" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;" required="required" value="${curworkload.sumgzl}" /></td>
                </tr>
                <tr>
                    <td align="right">错误点:</td>
                    <td><input name="cwd" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${curworkload.cwd}" /></td>
                    <td align="right">校验:</td>
                    <td><input name="jy" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${curworkload.jy}" /></td>
                </tr>
                <tr>
                    <td align="right">学院:</td>
                    <td><input name="yxid" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${curworkload.yxid}" /></td>
                    <td align="right">校验信息:</td>
                    <td><input name="errmsg" type="text" placeholder="请输入" class="easyui-validatebox textbox"
                               style="width:240px; height: 29px;"  value="${curworkload.errmsg}" /></td>
                </tr>
                <tr>
                    <p id="idp" style="background-color:#E9E9E4"></p>
                </tr>

            </table>
        </form>
    </div>
</div>