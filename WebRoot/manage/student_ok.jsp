<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!-- 
	管理员操作，删除学生信息成功页面
-->
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<script language="javascript">
	alert("考生信息删除成功!");
	window.location.href="student.do?action=studentQuery";
</script>		
</body>
</html>