# 仿12306JAVAEE-JSP项目 

项目所用技术：Servlet、单例模式

项目中所遇bug：

1. HTTP Status 404 - /my12306/top.jsp

![](WebContent/images/bug_1.png)

**错误原因：**
index.jsp的framest下的frame的top.jsp路径不对
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>
<frameset rows="130,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame">
  <frameset rows="*" cols="247,*" framespacing="0" frameborder="no" border="0">
    <frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame">
    <frame src="main.jsp" name="mainFrame" id="mainFrame" title="mainFrame">
  </frameset>
</frameset>
<noframes>
<body>
</body>
</noframes></html>
```
**解决方法：** 将路径重新配置正确
```
<frame src="<%=request.getContextPath() %>/user/top.jsp" name="topFrame" scrolling="No"
 noresize="noresize" id="topFrame" title="topFrame">
  <frameset rows="*" cols="247,*" framespacing="0" frameborder="no" border="0">
    <frame src="<%=request.getContextPath() %>/user/left.jsp" name="leftFrame" 
    scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame">
    <frame src="<%=request.getContextPath() %>/user/main.jsp" name="mainFrame"
     id="mainFrame" title="mainFrame">
```
 2. HTTP Status 500 - Unable to compile class for JSP: 
 ![](WebContent/images/bug_2.png)

 **原因：包名路径导入错误**
 ```
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Users" %>
 ```
**解决方法：** 将路径重新配置正确
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.ptcs.my12306.entity.Users" %>
```
3. HTTP Status 500 - java.lang.NullPointerException
![](WebContent/images/bug_3.png)
**原因：此点击跳转的路径未正确设置，必须先经过Servlet而后跳转**
```
  <tr>
    <td align="right"><img src="<%=request.getContextPath()%>/
    images/ny_arrow1.gif" width="24" height="13"></td>
    <td height="35"><a href="<%=request.getContextPath()%>/user/
    userinfo_display.jsp" target="mainFrame"class="cray">查看个人信
    息</a></td>
  </tr>
```
**解决方法：** 将路径重新配置正确
```

```