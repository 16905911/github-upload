<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!-- 
	����Ա��������Ŀ��Ϣ��ӳɹ�ҳ�� 
-->
<html>
<head>
<title>�����ɹ�!</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
	<%
		int para = Integer.parseInt(request.getParameter("para"));
		switch (para) {
			case 1 :
	%>
	<script language="javascript">
		alert("��Ŀ��Ϣ��ӳɹ�!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
			case 2 :
	%>
	<script language="javascript">
		alert("��Ŀ��Ϣ�޸ĳɹ�!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
			case 3 :
	%>
	<script language="javascript">
		alert("��Ŀ��Ϣɾ���ɹ�!");
		window.location.href = "lesson.do?action=lessonQuery";
	</script>
	<%
		break;
		}
	%>
</body>
</html>