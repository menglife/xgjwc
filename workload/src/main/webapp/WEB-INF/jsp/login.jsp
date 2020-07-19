<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登陆</title>
    <%@ include file="/commons/basejs.jsp" %>
    <!--引用echart-->
    <script type="text/javascript" src="${staticPath }/echarts/echarts.js" charset="utf-8"></script>
</head>
<body style="background: #e4e4e4">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center">
            <table width="452" height="290" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td style="background: rgba(27,233,216,0.12) ">
                        <table width="452" height="290" border="0" cellpadding="0" cellspacing="0">

                            <tr>
                                <td align="center" >
                                    <form  name="form1" action="/logindata" method="post" >
                                        <table border="0" align="center" cellpadding="2" cellspacing="0">
                                            <tr align="center">
                                                <td height="30" colspan="2" style="border-bottom: 1px dotted #cccccc">
                                                    <strong style="font-size: 20px;">徐州工程学院教学工作量统计系统</strong>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height="30" nowrap>
                                                    <strong>用户名：</strong>
                                                </td>
                                                <td>
                                                    <input type="text" name="username" style="width: 160px;" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td height="30" nowrap>
                                                    <strong>密&nbsp;码：  </strong>
                                                </td>
                                                <td>
                                                    <input type="password" name="password"  style="width: 160px;"/>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td height="30" nowrap colspan="2">
                                                    <strong><font color="red"></font> </strong>
                                                </td>
                                            </tr>
                                        </table>
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <input type="submit" name="submit" value="登陆" class="buttoninput" />
                                                &nbsp;&nbsp;&nbsp;
                                                <input type="reset" name="reset" value="清空" class="buttoninput"/>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<%--<div class="easyui-panel" title="用户登录" style="width: 350px;height: 300px;" data-options="region:'center',split:true">--%>
        <%--<h2 style="border-bottom: 1px dotted #cccccc">欢迎使用教务处教学工作量统计</h2>--%>

        <%--<form action="logindata" method="post" style="position: center">--%>
            <%--<tr>--%>
                <%--用户名：<input type="text" name="username" >--%>
            <%--</tr></br>--%>

            <%--<tr>--%>
                <%--密&nbsp;&nbsp;&nbsp;码： <input type="password" name="password" >--%>
            <%--</tr></br>--%>
            <%--<tr>--%>
                <%--<input type="submit" value="登陆" ></input>--%>
                <%--<input type="reset" value="取消" ></input>--%>
            <%--</tr></br>--%>

        <%--</form>--%>


<%--</div>--%>

</body>
</html>
