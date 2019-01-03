<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!-- 
	管理员操作，左边框功能页面，主要有管理员信息管理，科目信息管理 ，试卷信息管理，考试题目信息管理，考试信息管理，考生成绩查询，操作提示，注销登陆等功能
-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="29" bgcolor="#5898C8"><span class="word_white">&nbsp;&nbsp;&nbsp;<strong>报名考试系统后台管理</strong></span></td>
  </tr>
  <tr>
    <td height="4"></td>
  </tr>
</table>
<table width="100%" height="441" border="0" cellpadding="0" cellspacing="0" class="tableBorder">
  
  <tr>
      <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td height="31" colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/notice.jsp"><font color="#FF00FF"><strong>操作提示说明 </strong></font></html:link></td>
  </tr>
  <tr>
  
  <tr>
    <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td width="75%"  colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/manager.do?action=managerQuery"><strong>管理员信息管理</strong></html:link></td>
  </tr>
  
  <tr>
      <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td height="31" colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/lesson.do?action=lessonQuery"><strong>考试信息管理</strong></html:link></td>
  </tr>
  <tr>
      <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td height="31" colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/student.do?action=studentQuery"><strong>考生信息管理</strong></html:link></td>
  </tr>
  
  <tr>
      <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td height="31" colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/stuResult.do?action=stuResultQuery&page=1"><strong>考生考试查询</strong></html:link></td>
  </tr>
  
  <tr>
      <td width="25%" height="39" align="right" class="tableBorder_B">
    <img src="../Images/m_ico.gif" width="11" height="11" />&nbsp;</td>
    <td height="31" colspan="2" align="left" class="tableBorder_B"><html:link page="/manage/logout.jsp"><font color="#FF2400"><strong>注 销 登 录</strong></font></html:link></td>
  </tr>
 
  <tr>
    <td height="217" align="right">&nbsp;</td>
    <td height="217" colspan="2" align="left">&nbsp;</td>
  </tr>
</table>
