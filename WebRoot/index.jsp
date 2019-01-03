<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!--  
	考生登陆主页面
-->
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<head>
<title>在线考试系统</title>

<script language="javascript">
function check(form){
	if (form.ID.value==""){
		alert("请输入准考证号!");form.ID.focus();return false;
	}
	if (form.pwd.value==""){
		alert("请输入登陆密码!");form.pwd.focus();return false;
	}
}
</script>
</head>
<body background="Images/background.jpg">
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><table width="464" height="294" border="0" align="center"
					cellpadding="0" cellspacing="0" background="Images/s_login.jpg">
					<tr>
						<td width="157" height="140">&nbsp;</td>
						<td width="307">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td valign="top">
							<html:form action="manage/student.do?action=login" method="post" focus="ID" onsubmit="return check(studentForm)">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6">
									<tr>
										<td width="35%" height="30">准考证号：</td>
										<td width="74%"><html:text property="ID" size="23" />
										</td>
									</tr>
									<tr>
										<td height="35">登陆密码：</td>
										<td><html:password property="pwd" size="24" /></td>
									</tr>
									<tr>
										<td height="75" colspan="2" align="center">
											&nbsp;&nbsp;&nbsp;
											<html:submit styleClass="btn_grey" value="登 陆" /> 
											<html:reset value="重 置" styleClass="btn_grey" />
											<html:button property="button" styleClass="btn_grey" value="注 册" onclick="window.location.href='register.jsp'"/>
											<html:button property="button" styleClass="btn_grey" value="帮 助" onclick="window.location.href='seekPwd.jsp'"/>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<!--<html:link page="/manage/login.jsp"  style="text-decoration:none;color: #FF2400"><strong>管理员登陆</strong></html:link>-->
											<a href="manage/login.jsp" ><img src="Images/mblogin.jpg" style="border:0"></img></a>
										</td>
									</tr>
								</table>
							</html:form>														
						</td>
					</tr>
				</table>
				<table  border="0" align="center" >
					<tr>
						<td>
							<strong><font color="#FF0000">* 温馨提示：忘记准考试或密码请点击帮助找回！</font></strong>
						</td>
					</tr>
				</table>
			</td>				
		</tr>
	</table>
</body>
</html>
