<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!--  
	考试注册成功跳回到登陆页面
-->
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<script language="javascript">
	alert("<%=request.getAttribute("ret")%>");
	window.location.href="../index.jsp";
</script>		
</body>
</html>