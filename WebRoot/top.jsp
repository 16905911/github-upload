<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!-- 此页面用于考生登陆成功保存考生信息，包括考生学号还有准考证！ -->
<%
	if (session.getAttribute("student") == null) {
		response.sendRedirect("../index.jsp");
	}
	/*
		在考生第一登陆就会保存考生的准考证，以备考生查询自己的成绩和修改自己的信息，在后台Student.java里面的考生登陆里面
		session.setAttribute("student", studentForm.getID());
		Jsp页面中设置这个session后就可以实现所有页面共享
	*/
%>

<!--  
		Struts提供了五个标签库，即：HTML、Bean、Logic、Template和Nested。
		HTML 标签：        		 用来创建能够和Struts 框架和其他相应的HTML 标签交互的HTML 输入表单
		Bean 标签：        		 在访问JavaBeans 及其属性，以及定义一个新的bean 时使用
		Logic 标签：       	 管理条件产生的输出和对象集产生的循环
		Template 标签：  	 随着Tiles框架包的出现，此标记已开始减少使用
		Nested 标签：      	增强对其他的Struts 标签的嵌套使用的能力
-->