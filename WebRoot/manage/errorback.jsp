<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!-- 
	管理员操作，错误提示页面 
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- 
	xmlns 是用来定义xml namespace属性的。
	xmlns 属性在 XHTML 中是必需的。不过即使你的 XHTML 文档没有使用此属性，W3C 的验证器也不会报错。
	因为 "xmlns=http://www.w3.org/1999/xhtml" 是一个固定值，所以，即使你没有包含它，此值也会被添加到 <html> 标签中。
 -->
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>错误提示</title>
<link href="../CSS/style.css" rel="stylesheet">
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="../Images/errorback.jpg">
  <tr>
    <td align="center"><table width="350" height="192" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" background="../Images/error.jpg">&nbsp;&nbsp;<strong>错误提示信息： ${error}</strong> <br>
              <br><br>
              <input name="Submit" type="submit" class="btn_grey" value="关 闭" onClick="window.close()"></td>
      </tr>
    </table></td>
  </tr>
</table>
<center>
</center>
</body>
</html>
