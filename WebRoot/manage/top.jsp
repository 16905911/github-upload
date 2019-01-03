<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!-- 此页面用于管理员登陆成功保存管理员信息 -->
<%
//验证用户是否登录

if (session.getAttribute("manager")==null || "".equals(session.getAttribute("manager"))){
	response.sendRedirect("login.jsp");
	return;
}

	/*
		在管理员第一登陆就会保存管理员的信息，在后台Manager.java里面的管理员登陆里面
		session.setAttribute("manager", managerForm.getName());
		Jsp页面中设置这个session后就可以实现所有页面共享
	*/
%>

<table width="778" height="99" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../Images/m_top.jpg">&nbsp;</td>
  </tr>
</table>