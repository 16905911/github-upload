<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!-- 
	管理员操作，科目信息添加成功页面 
-->
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
	<%
		int para = Integer.parseInt(request.getParameter("para"));
		switch (para) {
			case 1 :
	%>
	<script language="javascript">
		alert("科目信息添加成功!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
			case 2 :
	%>
	<script language="javascript">
		alert("科目信息修改成功!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
			case 3 :
	%>
	<script language="javascript">
		alert("科目信息删除成功!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
		}
	%>
</body>
</html>