<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!-- 
	����Ա��������½�ɹ���ʾ����ҳ��
-->
<html>
<head>
<title>���߿���ϵͳ��̨����</title>
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body>
	<%@ include file="top.jsp"%>
	<table width="778" border="0" align="center" cellspacing="0"
		cellpadding="0">
		<tr>
			<td width="176" align="center" valign="top" bgcolor="#FFFFFF"><%@ include
					file="left.jsp"%></td>
			<td width="595" valign="top" bgcolor="#FFFFFF">
				<table width="100%" height="490" border="0" cellpadding="0"
					cellspacing="0" align="right" background="../Images/notice.jpg">
					<tr>
						<td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="78%" class="word_grey">&nbsp;��ǰλ�ã�<span
										class="word_darkGrey">������ʾ˵��&gt;&gt;&gt;</span>
									</td>
									<td align="right"><img src="../Images/m_ico1.gif"
										width="5" height="9">&nbsp;��ǰ����Ա��<%=session.getAttribute("manager")%>&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
					<tr>
						<td align="center" valign="top">
							<table width="100%" height="40" border="0" cellpadding="0"
								cellspacing="0" align="center" >
								<tr>
									<td height="90" colspan="3" align="center"><font size=3
										color="#0000FF" style="font-weight: bold;">��½�ɹ�����ӭ����<%=session.getAttribute("manager")%>���밴�������ʾ���в���</font>
									</td>
								</tr>
								<tr>
									<td width="12%">&nbsp;</td>
									<td width="77%" valign="top">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ������ʾҳ��--�鿴���߿���ϵͳ�Ĳ���˵��</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ����Ա��Ϣ����--���ӣ�ɾ�����޸�,��ѯ����Ա��Ϣ</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ��Ŀ��Ϣ����--���ӣ�ɾ�����޸�,��ѯ��Ŀ��Ϣ</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� �Ծ���Ϣ����--���ӣ�ɾ�����޸�,��ѯ�Ծ���Ϣ</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ��Ŀ��Ϣ����--���ӣ�ɾ�����޸�,��ѯ��Ŀ��Ϣ</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ������Ϣ����--��ѯ��ɾ��������Ϣ</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� �����ɼ���ѯ--��ѯ�����ɼ���Ϣ���ɵ���Excel��</strong><br><br>										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>�� ע����½--�˳����߿���ϵͳ</strong><br><br>	 
									</td>
									<td width="11%">&nbsp;</td>
								</tr>
							</table> <br></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
