<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!-- 
	����Ա������������ʾҳ�� 
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- 
	xmlns ����������xml namespace���Եġ�
	xmlns ������ XHTML ���Ǳ���ġ�������ʹ��� XHTML �ĵ�û��ʹ�ô����ԣ�W3C ����֤��Ҳ���ᱨ��
	��Ϊ "xmlns=http://www.w3.org/1999/xhtml" ��һ���̶�ֵ�����ԣ���ʹ��û�а���������ֵҲ�ᱻ��ӵ� <html> ��ǩ�С�
 -->
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>������ʾ</title>
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="../Images/errorback.jpg">
  <tr>
    <td align="center"><table width="350" height="192" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" background="../Images/error.jpg">&nbsp;&nbsp;<strong>������ʾ��Ϣ�� ${error}</strong> <br>
              <br><br>
              <input name="Submit" type="submit" class="btn_grey" value="�� ��" onClick="window.close()"></td>
      </tr>
    </table></td>
  </tr>
</table>
<center>
</center>
</body>
</html>
