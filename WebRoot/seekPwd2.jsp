<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!--  
	考生忘记准考证或者密码，成功找回准考证或密码页面
-->
<html>
<head>
<title>广东海洋大学在线考试系统</title>
<html:base/>
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript">

	function doufucopy() {
		textRange = test.createTextRange();
		textRange.execCommand("Copy");
		alert("准考证号复制到剪粘板成功！");
	}
	function doufupaste() {
		textRange = taCode.createTextRange();
		textRange.execCommand("Paste");
	}
</script>
</head>

<body>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="131" background="Images/top_bg.jpg">&nbsp;</td>
  </tr>
</table>
<table width="778" border="0" align="center" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="778" height="480"  border="0" cellpadding="0" cellspacing="0" align="center" background="Images/background1.jpg">
      <tr>
        <td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="word_grey">&nbsp;<img src="Images/f_ico.gif" width="8" height="8"> 当前位置：→ <span class="word_darkGrey">找回准考证或密码 &gt;&gt;&gt;</span></td>
			  <td align="right"><img src="Images/m_ico1.gif" width="5" height="9">&nbsp;<html:link page="/index.jsp" >返回首页</html:link>&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      <tr>
        <td height="257" align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table> 
 <table width="57%" height="69" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td width="20%"><img src="Images/step3.jpg" width="73" height="30"></td>
     <td width="80%" ><strong>恭喜您，成功找回准考证或密码，请牢记</strong></td>
   </tr>
 </table>
 <table width="57%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
    <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">准考证号：</td>
    <td width="80%" align="left">
		<input type="text" id="test" size="40" disabled="disabled" value="${seekPwd3.ID}"/> <span class="word_orange1"><strong> （只读）</strong></span></td>
    </tr>
    <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">登陆密码：</td>
    <td width="80%" align="left">   
      	<input type="text" size="40" disabled="disabled" value="${seekPwd3.pwd}"/><span class="word_orange1"><strong> （只读）</strong></span>	</td>
    </tr>	
    <tr>
      <td height="65" align="left" style="padding:5px;">&nbsp;</td>
      <td>
      	<input type=button value="复制准考证" class="btn_grey" onclick="doufucopy();"> &nbsp;
		<input type="button" value="返回" class="btn_grey" onClick="window.location.href='<html:rewrite page="/index.jsp"/>'"/>
	  </td>
    </tr>
    
</table>
</td>
      </tr>
      <tr>
      </tr>
    </table>
</td>
  </tr>
</table>
<%@ include file="copyright.jsp"%>
</body>
</html>
