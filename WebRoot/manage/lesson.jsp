<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!-- 
	����Ա��������Ŀ��Ϣ��ʾҳ�� 
-->
<html>
<head>
<title>���߿���ϵͳ��̨����</title>
<link href="../CSS/style.css" rel="stylesheet">
<script language="javascript">
function CheckAll(elementsA,elementsB){
	for(i=0;i<elementsA.length;i++){
		elementsA[i].checked = true;
	}
	if(elementsB.checked ==false){
		for(j=0;j<elementsA.length;j++){
			elementsA[j].checked = false;
		}
	}
}
//�ж��û��Ƿ�ѡ����Ҫɾ���ļ�¼������ǣ�����ʾ���Ƿ�ɾ������������ʾ����ѡ��Ҫɾ���ļ�¼��
function checkdel(delid,formname){
	var flag = false;
	for(i=0;i<delid.length;i++){
		if(delid[i].checked){
			flag = true;
			break;
		}
	}
	if(!flag){
		alert("��ѡ��Ҫɾ���ļ�¼��");
		return false;
	}else{
			if(confirm("ȷ��Ҫɾ����")){
				formname.submit();
		}
	}
}
</script>

</head>
<body>
<%@ include file="top.jsp"%>
<table width="778" border="0" align="center" cellspacing="0" cellpadding="0">
  <tr>
    <td width="176" align="center" valign="top" bgcolor="#FFFFFF"><%@ include file="left.jsp"%></td>
    <td width="602" valign="top" bgcolor="#FFFFFF"><table width="99%" height="570"  border="0" cellpadding="0" cellspacing="0" align="right">
      <tr>
        <td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="78%" class="word_grey">&nbsp;��ǰλ�ã�<span class="word_darkGrey">��Ŀ��Ϣ����  &gt;&gt;&gt;</span></td>
              <td align="right"><img src="../Images/m_ico1.gif" width="5" height="9">&nbsp;��ǰ����Ա��<%=session.getAttribute("manager")%>&nbsp;</td>
              </tr>
          </table></td>
        </tr>
      <tr>
        <td align="center" valign="top">
<table width="96%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="90%" height="27" align="right"><img src="../Images/add.gif" width="19" height="18">&nbsp;</td>
    <td width="10%"><html:link page="/manage/lesson.do?action=lessonAddQuery">��ӿ�Ŀ</html:link></td>
  </tr>
</table>
<table width="96%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#67A8DB">
<html:form action="/manage/lesson.do?action=lessonDel" method="post">
  <tr align="center" bgcolor="#A8D8FC">
  	<!--<td width="10%" bgcolor="#B2D6F1">���</td>-->
    <td width="40%" height="30" bgcolor="#B2D6F1">��Ŀ����</td>
    <td width="15%" bgcolor="#B2D6F1">����״̬</td>
	<td width="30%" bgcolor="#B2D6F1">����ʱ��</td>
	<td width="7%" bgcolor="#B2D6F1">�޸�</td>
	<td width="8%" bgcolor="#B2D6F1">ѡ��</td>
  </tr>
	<logic:iterate id="lesson" name="lessonQuery" type="com.oes.actionForm.LessonForm" scope="request">
  <tr>
  	<!--<td align="center"><bean:write name="lesson" property="xuhao" filter="true"/></td> -->
    <td style="padding:5px;" align="center"><bean:write name="lesson" property="name" filter="true"/></td>
    <td align="center"><html:button property="button" styleClass="btn_grey" value="�鿴" 
    onclick="window.open('startExam.do?action=showExam&id=${lesson.ID}','','width=786,height=768,scrollbars=1');"/></td>
	<td align="center"><bean:write name="lesson" property="joinTime" format="yyyy-MM-dd HH:mm:ss" filter="true"/></td>
	<td align="center"><html:link page="/manage/lesson.do?action=lessonModifyQuery" paramId="id" paramName="lesson" paramProperty="ID">�޸�</html:link></td>
    <td align="center"><html:multibox property="delIdArray" styleClass="noborder"><bean:write name="lesson" property="ID"/></html:multibox></td>
  </tr>
  </logic:iterate> 
</table>
<table width="94%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td width="70%" height="24" align="center"><font color=red>* ��ܰ��ʾ����ӿ��Կ�Ŀ��������Ծ���Ϣ����Ŀ��Ϣ���ܲ鿴�Ծ�</font></td>
	<td width="30%" align="right"><input name="checkbox" type="checkbox" class="noborder" onClick="CheckAll(lessonForm.delIdArray,lessonForm.checkbox)">
	  [ȫѡ/��ѡ] [<a style="color:red;cursor:hand;" onClick="checkdel(lessonForm.delIdArray,lessonForm)">ɾ��</a>]
	  <div id="ch">
		<input name="delid" type="checkbox" class="noborder" value="0">
	  </div></td>
	<!--��ch���ڷ������ص�checkbox�ؼ�����Ϊ������ֻ��һ��checkbox�ؼ�ʱ��Ӧ��javascript�����length����ֵΪundefine-->
	<script language="javascript">ch.style.display="none";</script>
  </tr>
  </html:form>
</table>
</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
