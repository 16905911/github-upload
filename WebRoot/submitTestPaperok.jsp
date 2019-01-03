<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!--  
	考生提交试卷跳转到登陆页面
-->
<html>
<head>
<title>操作成功!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<script language="javascript">
	alert("<%=request.getAttribute("submitTestPaperok")%>");
	window.open('../default.jsp','','toolbar,menubar,scrollbars,resizable,status,location,directories,copyhistory,height=768,width=1366');
	window.close();
</script>		
</body>
</html>