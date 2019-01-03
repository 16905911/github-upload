<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!--  
	考生信息修改页面
-->
<html>
<head>
<title>广东海洋大学在线考试系统</title>
<html:base />
<link href="CSS/style.css" rel="stylesheet">
</head>
<script language="javascript">
function checkForm(form){
	if(form.name.value==""){
		alert("请输入考生姓名!");form.name.focus();return false;
	}
	if(form.profession.value==""){
		alert("请输入考生专业!");form.profession.focus();return false;
	}
	if(form.oldpwd1.value==""){
		alert("请输入的原密码!");form.oldpwd1.focus();return false;
	}
	if(form.oldpwd1.value!=form.holdpwd.value){
		alert("您输入的原密码不正确，请重新输入!");form.oldpwd1.value="";
		form.oldpwd1.focus();return false;
	}
	if(form.newpwd.value==""){
		alert("请输入的新密码!");form.newpwd.focus();return false;
	}
	if(form.newpwd.value.length<6 || form.newpwd.value.length>20){
		alert("您输入的新密码不合法，密码必须大于6位，并且小于等20位!");form.newpwd.focus();return false;
	}	
	if(form.newpwd1.value==""){
		alert("请确认新密码!");form.newpwd1.focus();return false;
	}	
	if(form.newpwd.value!=form.newpwd1.value){
		alert("您两次输入的新密码不一致，请重新输入!");
		form.newpwd.value="";form.newpwd1.value="";
		form.newpwd.focus();return false;
	}
	if(form.question.value==""){
		alert("请输入提示问题!");form.question.focus();return false;
	}
	if(form.answer.value==""){
		alert("请输入问题答案!");form.answer.focus();return false;
	}
}
</script>
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
              <td class="word_grey">&nbsp;<img src="Images/f_ico.gif" width="8" height="8"> 当前位置：→ <span class="word_darkGrey">修改个人资料 &gt;&gt;&gt;</span></td>
			  <td align="right"><img src="Images/m_ico1.gif" width="5" height="9">&nbsp;<html:link page="/default.jsp" >返回首页</html:link>&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table> 
<html:form action="/manage/student.do?action=studentModify" method="post" onsubmit="return checkForm(studentForm)">
<bean:define id="studentID" name="modifyQuery" property="ID" type="String"/>
<bean:define id="studentPwd" name="modifyQuery" property="pwd" type="String"/>
  <table width="57%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
  <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">考生学号：</td>
    <td width="80%" align="left">
      <html:text property="cardNo" size="40" disabled="true" name="modifyQuery"/><font color="#FF0000"> （唯一，只读）</font> </td>
    </tr>
  <tr>
    <td height="30" align="left" style="padding:5px;">考生姓名：</td>
    <td align="left">
	<html:hidden property="ID" value="<%=studentID%>"/>
	 <html:text property="name" size="40" name="modifyQuery" /> <font color="#FF0000"> *</font></td>
    </tr>
    <tr>
    <td height="30" align="left" style="padding:5px;">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    <td align="left">
		<html:select property="sex" name="modifyQuery">
	 	<html:option value="男">男 </html:option>
		<html:option value="女">女 </html:option>
		</html:select>     </td>
    </tr>
    <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">专&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
    <td width="80%" align="left">
      <html:text property="profession" size="40" name="modifyQuery"/><font color="#FF0000"> *</font></td>
    </tr>
	    <tr>
    <td align="left" style="padding:5px;">原&nbsp;密&nbsp;码：</td>
    <td align="left"><html:password styleId="oldpwd1" property="oldpwd" size="40"/> <font color="#FF0000"> *</font>
      <html:hidden styleId="holdpwd" property="oldpwd" value="<%=studentPwd%>"/></td>
    </tr>
    <tr>
    <td height="30" align="left" style="padding:5px;">新&nbsp;密&nbsp;码：</td>
    <td align="left"><html:password styleId="newpwd" property="pwd" size="40"/><font color="#FF0000"> （至少6位）*</font></td>
    </tr>
  <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">确认新密码：</td>
    <td width="80%" align="left">
      <html:password styleId="newpwd1" property="pwd" size="40"/><font color="#FF0000"> （需同上）*</font>	  </td>
    <tr>
    	
    <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">提示问题：</td>
    <td width="80%" align="left">
      <html:text property="question" size="40" name="modifyQuery"/><font color="#FF0000"> （如我的爱好）*</font>	  </td>
    </tr>
	  <tr align="center">
    <td width="20%" height="30" align="left" style="padding:5px;">问题答案：</td>
    <td width="80%" align="left">
      <html:text property="answer" size="40" name="modifyQuery"/> <font color="#FF0000"> （如篮球）*</font></td>
    </tr>
	  
	
    <tr>
      <td height="65" align="left" style="padding:5px;">&nbsp;</td>
      <td><html:submit property="submit" styleClass="btn_grey" value="保存"/>
        &nbsp;
        <html:reset property="reset" styleClass="btn_grey" value="重置"/>
&nbsp;
		<html:button property="button" styleClass="btn_grey" value="返回" onclick="window.location.href='../default.jsp'"/>
		</td>
    </tr>
</table>
</html:form>
</td>
      </tr>
    </table>
</td>
  </tr>
</table>
<%@ include file="copyright.jsp"%>
</body>
</html>
