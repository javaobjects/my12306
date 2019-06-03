<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12306购票系统</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
</style>
<script language="javascript">
	function UserRegistration(){
	
	
	window.navigate("user_register.jsp");
	
	}
</script>
<script language="javascript">
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
</style></head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
 <form name="form1" method="post" action="<%=request.getContextPath()%>/LoginServlet" id="loginForm">
   <table width="933" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:120px;">
  <tr>
    <td height="412" valign="top" background="<%=request.getContextPath()%>/images/bg_img1.jpg"><table height="300" border="0" cellspacing="0">
      <tr>
        <td width="538">&nbsp;</td>
        <td height="130" colspan="6">&nbsp;</td>
        </tr>
      <tr>
        <td rowspan="9">&nbsp;</td>
        <td width="98" height="20" align="right"><img src="<%=request.getContextPath()%>/images/text_yh.gif" width="60" height="18"></td>
        <td width="16">&nbsp;</td>
        <td width="136"><input name="textfield" type="text" id="textfield" size="18" /></td>
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
        <td height="20" align="right"><img src="<%=request.getContextPath()%>/images/text_password.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="textfield2" type="text" id="textfield2" size="18" /></td>
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
        <td height="20" align="right"><img src="<%=request.getContextPath()%>/images/text_yzm.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="textfield3" type="text" id="textfield3" size="18" /></td>
        <td><span class="text_cray1"><img src="<%=request.getContextPath()%>/images/bg_img2.gif" alt="" height="20" /></span></td>
        <td><img src="<%=request.getContextPath()%>/images/text_sx.gif" width="32" height="18"></td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="bottom"><table width="100%" border="0" cellspacing="0">
          <tr>
            <td width="26" align="left"><input name="checkbox" type="checkbox" value="checkbox" style=" margin:0 auto;"/></td>
            <td width="170"><img src="<%=request.getContextPath()%>/images/text_zddl.gif" width="60" height="18"></td>
          </tr>
        </table></td>
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
