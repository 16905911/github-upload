<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!-- ��ҳ�����ڹ���Ա��½�ɹ��������Ա��Ϣ -->
<%
//��֤�û��Ƿ��¼

if (session.getAttribute("manager")==null || "".equals(session.getAttribute("manager"))){
	response.sendRedirect("login.jsp");
	return;
}

	/*
		�ڹ���Ա��һ��½�ͻᱣ�����Ա����Ϣ���ں�̨Manager.java����Ĺ���Ա��½����
		session.setAttribute("manager", managerForm.getName());
		Jspҳ�����������session��Ϳ���ʵ������ҳ�湲��
	*/
%>

<table width="778" height="99" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../Images/m_top.jpg">&nbsp;</td>
  </tr>
</table>