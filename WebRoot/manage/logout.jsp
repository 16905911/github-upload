<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!-- 
	管理员操作，注销返回登陆页面 
-->
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
	<%
		session.invalidate();
		out.println("<script language='javascript'>");
		out.println("window.location.href='../index.jsp'");
		out.println("</script>");
	%>


</body>
</html>
