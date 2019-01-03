<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!-- 
	管理员操作，选择试卷页面
-->
<html:select property="taoTiId" name="questionsForm">
<html:options collection="taoTiList" property="ID" labelProperty="name"/>
</html:select>