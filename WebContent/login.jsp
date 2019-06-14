<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="net.ptcs.my12306.entity.Users" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12306购票系统</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
<script>
	function UserRegistration(){
		location.href = "<%=request.getContextPath()%>/ToRegisterViewServlet" ;
	}
</script>
<script>
	function UserLogin(){
		document.getElementById("loginForm").submit();
	}
</script>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_point.gif);
}
-->
</style>
</head>

<%
//如果用户前面登录时勾选了自动登录，那么访问登录页面时需要先获取cookie中的内容，如果有，就说明上次写cookie写成功了，
//那么根据cookie的内容自动跳转到对应的首页面
Cookie[] cookies=request.getCookies();
if(cookies!=null)
{
	String username=null;
	String password=null;
	String rule=null;
	Users user=null;
	for(Cookie c:cookies)
	{
		if("username".equals(c.getName()))
		{
			username=c.getValue();
		}
		if("password".equals(c.getName()))
		{
			password=c.getValue();
		}
		if("rule".equals(c.getName()))
		{
			rule=c.getValue();
		}
	}
	if(username!=null&&password!=null&&rule!=null&&!"".equals(username))
	{
		user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setRule(rule);
		
		session.setAttribute("user", user);
		
		//跳转到对应权限页面
		if("1".equals(rule))
		{
			response.sendRedirect("admin/index.jsp");
		}else if("2".equals(rule))
		{
			response.sendRedirect("user/index.jsp");
		}
	}
}
%>
<%
String message = (String) request.getAttribute("message");
if(message != null){
	%>
	<script>
	alert("<%=message%>");
	</script>
<% }%>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
 <form name="form1" method="post" action="<%=request.getContextPath()%>/LoginServlet" id="loginForm">
   <table width="933" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:120px;">
  <tr>
    <td height="412" valign="top" background="<%=request.getContextPath()%>/images/bg_img1.jpg">
    <table height="300" border="0" cellspacing="0">
      <tr>
        <td width="538">&nbsp;</td>
        <td height="130" colspan="6">&nbsp;</td>
        </tr>
      <tr>
        <td rowspan="9">&nbsp;</td>
        <td width="98" height="20" align="right">
        	<img src="<%=request.getContextPath()%>/images/text_yh.gif" width="60" height="18">
       	</td>
        <td width="16">&nbsp;</td>
        <td width="136">
        <input name="username" type="text" id="textfield" size="18" />
        <%-- <%  String login_message=(String)request.getAttribute("message");
        if(login_message!=null)
        {
        %>	
        <%=login_message%>
        <% }
        %> --%>
        <span class="text_red">${login_message}</span>
        </td>
        <td width="55">&nbsp;</td>
        <td width="44">&nbsp;</td>
        <td width="32">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">
        	<img src="<%=request.getContextPath()%>/images/text_password.gif" width="60" height="18">
       	</td>
        <td>&nbsp;</td>
        <td><input name="password" type="text" id="textfield2" size="18" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">
        	<img src="<%=request.getContextPath()%>/images/text_yzm.gif" width="60" height="18">
       	</td>
        <td>&nbsp;</td>
        <td><input name="code" type="text" id="textfield3" size="18" /></td>
        <td>
	        <span class="text_cray1">
	        	<img src="<%=request.getContextPath()%>/ValidateCodeServlet" alt="" height="20" id="login_image_code" onclick="refresh()"/>
	        </span>
        </td>
        <td>
        	<img src="<%=request.getContextPath()%>/images/text_sx.gif" width="32" height="18" onclick="refresh()" style="cursor:pointer;">
       	</td>
        <td align="left">&nbsp;</td>
      </tr>
      <script>
         function refresh(){
        	 document.querySelector("#login_image_code").src = "<%=request.getContextPath()%>/ValidateCodeServlet?data="+new Date();
         }
      </script>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="bottom"><table width="100%" border="0" cellspacing="0">
          <tr>
            <td width="26" align="left"><input name="auto_Login" type="checkbox" value="auto" style=" margin:0 auto;"/></td>
            <td width="170">
            	<img src="<%=request.getContextPath()%>/images/text_zddl.gif" width="60" height="18">
           	</td>
          </tr>
        </table>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2"><table width="200" border="0" cellspacing="0">
          <tr>
            <td width="78"><input name="button"  type="button"  class="butlogin" id="button" value="" onClick="UserLogin()"></td>
            <td>&nbsp;</td>
            <td width="78"><input name="button2"  type="button"  class="butzc" id="button2"value="" onClick="UserRegistration()"></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
 </form>
</body>
</html>
