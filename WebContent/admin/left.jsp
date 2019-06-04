<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">

<style type="text/css">
<!--
body {
	background-image: url(../images/bg_point1.gif);
	margin-top: 0px;
}
-->
</style></head>

<body>
<table width="247" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="17" colspan="2" align="left" valign="bottom">&nbsp;</td>
  </tr>
  <tr>
    <td width="75">&nbsp;</td>
    <td width="165" height="35"><span class="text_blod">管理员</span></td>
  </tr>
  <tr>
    <td align="right"><img src="<%=request.getContextPath()%>/images/ny_arrow1.gif" width="24" height="13"></td>
    <td height="35"><a href="<%=request.getContextPath()%>/GetUserInfoServlet" target="mainFrame" class="cray">用户管理</a></td>
  </tr>
  <tr>
    <td align="right"><img src="../images/ny_arrow1.gif" width="24" height="13"></td>
    <td height="35"><a href="<%=request.getContextPath()%>/admin/userinfo_add.jsp" target="mainFrame" class="cray">新增用户</a></td>
  </tr>
</table>
</body>
</html>
