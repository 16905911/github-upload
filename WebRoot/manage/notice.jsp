<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!-- 
	管理员操作，登陆成功显示的主页面
-->
<html>
<head>
<title>在线考试系统后台管理</title>
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
									<td width="78%" class="word_grey">&nbsp;当前位置：<span
										class="word_darkGrey">操作提示说明&gt;&gt;&gt;</span>
									</td>
									<td align="right"><img src="../Images/m_ico1.gif"
										width="5" height="9">&nbsp;当前管理员：<%=session.getAttribute("manager")%>&nbsp;</td>
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
										color="#0000FF" style="font-weight: bold;">登陆成功，欢迎您：<%=session.getAttribute("manager")%>，请按下面的提示进行操作</font>
									</td>
								</tr>
								<tr>
									<td width="12%">&nbsp;</td>
									<td width="77%" valign="top">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 操作提示页面--查看在线考试系统的操作说明</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 管理员信息管理--增加，删除，修改,查询管理员信息</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 科目信息管理--增加，删除，修改,查询科目信息</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 试卷信息管理--增加，删除，修改,查询试卷信息</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 题目信息管理--增加，删除，修改,查询题目信息</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 考生信息管理--查询，删除考生信息</strong><br><br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 考生成绩查询--查询考生成绩信息（可导出Excel）</strong><br><br>										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>☆ 注销登陆--退出在线考试系统</strong><br><br>	 
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
