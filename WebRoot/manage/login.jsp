<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!-- 
	����Ա��½ҳ��
-->
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<head>
<title>���߿���ϵͳ-����Ա��¼</title>

<script language="javascript">
function check(form){
	if (form.name.value==""){
		alert("���������Ա����!");form.name.focus();return false;
	}
	if (form.pwd.value==""){
		alert("����������!");form.pwd.focus();return false;
	}	
}
</script>
</head>
<body background="../Images/background.jpg">
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><table width="464" height="294" border="0" align="center"
					cellpadding="0" cellspacing="0" background="../Images/m_login.jpg">
					<tr>
						<td width="157" height="153">&nbsp;</td>
						<td width="307">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td valign="top"><html:form
								action="manage/manager.do?action=login" method="post"
								focus="name" onsubmit="return check(managerForm)">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6">
									<tr>
										<td width="35%" height="45">����Ա���ƣ�</td>
										<td width="74%"><html:text property="name" size="23" />
										</td>
									</tr>
									<tr>
										<td height="30">����Ա���룺</td>
										<td><html:password property="pwd" size="24" /></td>
									</tr>
									<tr>
										<td height="45" colspan="2" align="center">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <html:submit
												styleClass="btn_grey" value="�� ½" /> <html:reset
												value="�� ��" styleClass="btn_grey" /> <html:button
												property="button" styleClass="btn_grey" value="�� ��"
												onclick="window.location.href='/exam/index.jsp'" />
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
							<strong><font color="#FF0000">* ��ܰ��ʾ���������������������⣬����ϵϵͳ����Ա��</font></strong>
						</td>
					</tr>
				</table>
			</td>	
		</tr>
	</table>
</body>
</html>
