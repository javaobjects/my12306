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
  <tr>
    <td align="right"><img src="<%=request.getContextPath()%>/images/ny_arrow1.gif" width="24" height="13"></td>
    <td height="35"><a href="<%=request.getContextPath()%>/GetUserInfoServlet" target="mainFrame"class="cray">查看个人信息</a></td>
  </tr>
```
4. HTTP Status 500 - The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in eithe...

![](WebContent/images/bug_4.png)

**原因：** 在浏览器访问web项目的时候发现的，错误提示标签库没有在web.xml定义，同时其他jar包中也没有出现。

**解决方法：** 在tomcat下将jstl-1.2jar放入到lib文件夹下，重新启动tomcat即可！

5. eclipse提交git远程仓库成功而git远程仓库未显示有提交用gitBash提交显示如下错错误

![](WebContent/images/bug_5.png)

**原因：** 可能是因为某个文件不在本地代码目录中

**解决方法:**
```
1. git pull --rebase origin master//代码合并
2. git push origin master//提交代码
```
6. HTTP Status 500 - Servlet execution threw an exception

![](WebContent/images/bug_6.png)

**原因：** 命名未统一
![](WebContent/images/bug_6_yuanyin.png)
**解决方法：将其命名弄统一**