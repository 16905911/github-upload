<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!--  
	考试规则显示页面
-->
<%
	if (session.getAttribute("student") == null) {
		response.sendRedirect("../index.jsp");
	}
%>
<html>
<head>
<title>广东海洋大学在线考试系统</title>
<html:base />
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>

<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="131" background="Images/top_bg.jpg">&nbsp;</td>
  </tr>
</table>
<table width="778" border="0" align="center" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="778" height="480"  border="0" cellpadding="0" cellspacing="0" align="center" background="Images/background1.jpg">
      <tr>
        <td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="76%" class="word_grey">&nbsp;<img src="Images/f_ico.gif" width="8" height="8"> 当前位置：→ <span class="word_darkGrey">在线考试 → 考试规则 &gt;&gt;&gt;</span></td>
			  <td width="24%" align="right"><img src="Images/m_ico1.gif" width="5" height="9">
			    <html:link page="/default.jsp" >返回首页</html:link>&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      <tr>
        <td align="center" valign="top">
<html:form action="/manage/lesson.do?action=selectLesson" method="post">
 <table width="100%" height="253"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="90" colspan="3" align="center" ><font size=3 color="#3232CD" style="font-weight: bold;font-style: italic;">欢迎使用广东海洋大学在线考试系统，请仔细浏览下面的考试规则</font></td>
</tr>
  <tr>
    <td width="12%">&nbsp;</td>
    <td width="77%" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;
 <strong>在线考试系统不允许对网页进行刷新、后退等操作，否则后果自负。如果在规定的考试时间内没有<br><br>交卷，系统将自动提交试卷。每位考生同一个科目只能考一次，请考生遵守相关考试事宜。</strong>
 <br><br>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <strong>只有同意以上规则才可以进行考试。如果考试过程中出现问题或者未找到相关的考试科目，请及时<br><br>与系统管理员联系。</strong>	</td>
    <td width="11%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center" valign="top"><html:submit property="submit" styleClass="btn_grey" value="同 意"/></td>
    <td>&nbsp;</td>
  </tr>
</table> 
</html:form>
        </td>
      </tr>
    </table>
</td>
  </tr>
</table>
<%@ include file="copyright.jsp"%>
</body>
</html>
