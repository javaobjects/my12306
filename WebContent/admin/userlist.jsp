<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户管理</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function UserAdd(){
	
	
	window.navigate("UserInfo_Add.html");
	
	}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var userids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == false){
        userids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }else{
        userids[i].checked = true;
       }
      }
     }
    }
   }  
}
</script>
</head>
<body class="write_bg">
 <form name="form1" method="post" action="">

<table width="1107" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"></td>
  </tr>
</table>
<table width="850" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="13" height="30" align="left" valign="top"  ></td>
    <td width="822" align="left" valign="top"  class="text_blod_title">用户管理</td>
  </tr>
  <tr>
    <td height="15" colspan="2" align="center" ><img src="<%=request.getContextPath()%>/images/line.jpg" width="850" height="6"></td>
  </tr>
  <tr>
    <td height="15" colspan="2"  ></td>
  </tr>
</table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="835" background="../images/wb_01 (3).jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="5"></td>
        <td width="4%" height="25" align="left" class="text_cray1">姓名</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="textfield" type="text" class="text_cray" style="width:80px">
        </label></td>
        <td width="6%" align="center" class="text_cray1">性别</td>
        <td width="6%" align="left" class="text_cray1"><label>
          <select name="select" class="text_cray">
            <option value="N">男</option>
            <option value="M">女</option>
          </select>
        </label></td>
        <td width="9%" align="center" class="text_cray1">证件类型</td>
        <td width="13%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="loginUserDTO.id_type_code" id="cardType">
            <option value="1">二代身份证</option>
            <option value="C">港澳通行证 </option>
            <option value="G">台湾通行证</option>
            <option value="B">护照</option>
          </select>
        </label></td>
        <td width="8%" align="center" class="text_cray1">证件号码</td>
        <td width="13%" align="left" class="text_cray1"><label>
          <input name="textfield2" type="text" class="text_cray" style="width:100px">
        </label></td>
        <td width="8%" align="center" class="text_cray1">旅客类型</td>
        <td width="13%" align="left" class="text_blod"><label>
          <select class="text_cray" id="passengerType" name="passenger_type" style="width:100px">
            <option value="1">成人</option>
            <option value="2">儿童</option>
            <option value="3">学生</option>
            <option value="4">残疾军人、伤残人民警察</option>
          </select>
        </label></td>
        <td width="8%" align="center" valign="middle" class="text_craybold"><label>
          <input name="Submit" type="submit" class="butcx" value="">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" colspan="11" align="center">&nbsp;</td>
      </tr>
    </table>
        <table width="553" border="1" align="center" cellpadding="0" cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
          <tr align="center">
            <td width="44" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">选择</td>
            <td width="98" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">姓名</td>
            <td width="80" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">性别</td>
            <td width="132" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">证件类型</td>
            <td width="247" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">证件号码</td>
            <td width="82" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">旅客类型</td>
            <td width="89" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>
          </tr>
          <tr align="center">
            <td height="15" colspan="7" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1"><img src="../images/line1.jpg" width="790" height="6"></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="1">            </td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">用户1</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">男</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF"  class="text_cray1">220198112081022</td>
            <td width="82" bordercolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center" bgcolor="#F5F5F5">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="2"></td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">用户2</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">男</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF"  class="text_cray1">23621519701208101x</td>
            <td width="82" bordercolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="3"></td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">用户3</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">男</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF"  class="text_cray1">221251197112081021</td>
            <td width="82" bordercolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#F5F5F5"   class="text_cray1"><input type="checkbox" name="checkbox" value="4"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">用户4</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">女</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="5"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">用户5</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">女</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#F5F5F5"   class="text_cray1"><input type="checkbox" name="checkbox" value="6"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">用户6</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">男</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="7"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">用户7</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">女</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#F5F5F5"   class="text_cray1"><input type="checkbox" name="checkbox" value="8"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">用户8</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">女</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="9"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">用户9</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">男</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
          <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#F5F5F5"   class="text_cray1"><input type="checkbox" name="checkbox" value="10"></td>
            <td width="98" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">用户10</td>
            <td width="80" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">女</td>
            <td width="132" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">二代身份证</td>
            <td width="247" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">210211197012081019</td>
            <td width="82" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1">成人</td>
            <td width="89" bordercolor="#FFFFFF" bgcolor="#F5F5F5"  class="text_cray1"><a href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
          </tr>
        </table>
      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="102" align="left"  class="text_cray1"><a href="#">
              <label></label>
              <label></label>
              <label>
              <input type="checkbox" name="checkbox2" value="11"  onclick="selectAllNullorReserve('checkbox','反选');" ><span class="text_blue">全选</span></label>
            </a></td>
            <td width="525" align="right"  class="text_cray1"><a href="#">
              <!--<input type="button" name="Submit23" value="新增" onClick="UserAdd()"> -->
            </a></td>
            <td width="55" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="button" class="butsc" value="">
            </a></td>
            <td width="91" align="right"  class="text_cray1"><label>
              <input name="Submit3" type="submit" class="butdc" value="">
            </label></td>
          </tr>
        </table>
      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center" style="width:60%">
            <td width="335" align="center"  class="text_cray">&nbsp;</td>
            <td width="284" align="center"  class="text_cray">>> 1 2 3 4 5 6 7 8 &lt;&lt; </td>
            <td width="154" align="right"  class="text_cray1" style="width:20%"><label class="text_cray"> 每页显示
                <select name="select2">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                  </select>
            条信息</label></td>
          </tr>
        </table>
      <br></td>
  </tr>
  <tr>
    <td height="20"></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="2" background="<%=request.getContextPath()%>/images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="<%=request.getContextPath()%>/images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>
</body>
</html>