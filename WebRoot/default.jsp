<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" import="java.util.*" import="java.text.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!--  
	考生登陆成功显示的主页面，包括在线考试，成绩查询，信息修改，注销登陆四大功能
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<html:base />
<!-- 
	  通常情况下，浏览器会从当前文档的 URL 中提取相应的元素来填写相对 URL 中的空白。
 	  使用 <base> 标签可以改变这一点。浏览器随后将不再使用当前文档的 URL，而使用指定的基本 URL 来解析所有的相对 URL。
 	  通常情况下，浏览器会从当前文档的 URL 中提取相应的元素来填写相对 URL 中的空白。 
-->
<title>广东海洋大学在线考试系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body >
<table width="830" height="670" border="0" align="center" background="Images/background3.jpg">
	<tr><td>
	<br><br><br><br>
	<table width="550"  border="0" align="center" width="100%">
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
		<tr>
			<td width="8%"></td>		
			<td width="41%"><a href="examRule.jsp" ><img src="Images/1.png" style="border:0"></img></a></td>
			<td width="41%"><a href="manage/stuResult.do?action=stuResultQueryS&ID=${student}&page=1" ><img src="Images/2.png" style="border:0"></img></a></td>
		
		</tr>
		<tr>
			<td height="30"><td>
		</tr>
		<tr>
			<td></td>		
			<td><a href="manage/student.do?action=modifyQuery&ID=${student}" ><img src="Images/3.png" style="border:0"></img></a></td>
			<td><a href="logout.jsp" ><img src="Images/4.png" style="border:0"></img></a></td>
				
		</tr>
	</table>
	<table width="420"  border="0" align="center" width="100%">
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
		<tr>
			<td>
				<font size="3" color="#0000FF"><strong>
					登陆成功,欢迎您,登录时间为：<%=(new java.util.Date()).toLocaleString()%>
				</strong></font>
			</td>			
		</tr>
	</table>
	</td></tr>
</table>
</body>
</html>
