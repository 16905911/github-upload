<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
	管理员操作，考生成绩查询主页面
-->
<html>
<head>
<title>在线考试系统后台管理</title>
<link href="../CSS/style.css" rel="stylesheet">
</head>
<script language="javascript">
	/*将成绩单导出到excel表格*/
	function AutomateExcel() {
		var oXL = new ActiveXObject("Excel.Application");
		var oWB = oXL.Workbooks.Add();
		var oSheet = oWB.ActiveSheet;
		var table = document.all.data;
		var hang = table.rows.length;
		var lie = table.rows(0).cells.length;
		for (i = 0; i < hang; i++) {
			for (j = 0; j < lie; j++) {
				oSheet.Cells(i + 1, j + 1).value = table.rows(i).cells(j).innerText;
			}
		}
		oXL.Visible = true;
		oXL.UserControl = true;
	}
</script>

<body>
	<%@ include file="top.jsp"%>
	<table width="778" border="0" align="center" cellspacing="0"
		cellpadding="0" >
		<tr>
			<td width="176" align="center" valign="top" bgcolor="#FFFFFF"><%@ include
					file="left.jsp"%></td>
			<td width="602" valign="top" bgcolor="#FFFFFF"><table
					width="99%" height="570" border="0" cellpadding="0" cellspacing="0"
					align="right">
					<tr>
						<td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="78%" class="word_grey">&nbsp;当前位置：<span
										class="word_darkGrey">考生成绩查询 &gt;&gt;&gt;</span></td>
									<td align="right"><img src="../Images/m_ico1.gif"
										width="5" height="9">&nbsp;当前管理员：<%=session.getAttribute("manager")%>&nbsp;</td>
								</tr>
							</table></td>
					</tr>
					<tr>
					<tr>
						<td align="center" valign="top">
							<table width="100%" height="40" border="0" cellpadding="0"
								cellspacing="0">
								<html:form
									action="/manage/queryResultIf.do?action=stuResultQuery&page=1"
									method="post">
									<tr>
										<td align="left" valign="middle">
								   &nbsp;查询条件： <html:select property="queryIf">
													<html:option value="stuId">准考证号</html:option>
													<html:option value="whichLesson">考试科目</html:option>
											    </html:select> 
									&nbsp;关键字： <html:text value="" property="key" /> &nbsp;&nbsp; 
											<html:submit  property="submit" styleClass="btn_grey" value="查询" />&nbsp;&nbsp;
											<input type="button" name="out_excel" styleClass="btn_grey"
											onclick="AutomateExcel();" value="导出到Excel表格"
											class="notPrint"></td>
									</tr>
								</html:form>
							</table>

							<table width="98%" border="1" cellpadding="0" cellspacing="0"
								bordercolor="#FFFFFF" bordercolordark="#FFFFFF"
								bordercolorlight="#67A8DB" id="data">
								<tr align="center">
									<td width="18%" height="27" bgcolor="#B2D6F1">准考证号</td>
									<td width="9%" bgcolor="#B2D6F1">姓名</td>
									<td width="7%" bgcolor="#B2D6F1">性别</td>
									<td width="12%" bgcolor="#B2D6F1">专业</td>
									<td width="20%" bgcolor="#B2D6F1">考试科目</td>
									<td width="25%" bgcolor="#B2D6F1">考试时间</td>
									<td width="7%" bgcolor="#B2D6F1">考试考场</td>
								</tr>
								<logic:iterate id="stuResult" name="stuResultQuery"
									type="com.oes.actionForm.StuResultForm" scope="request">
									<tr>
										<td style="padding:5px;"><bean:write name="stuResult"
												property="stuId" filter="true" /></td>
										<td align="center"><bean:write name="stuResult"
												property="name" filter="true" /></td>
										<td align="center"><bean:write name="stuResult"
												property="sex" filter="true" /></td>
										<td align="center"><bean:write name="stuResult"
												property="profession" filter="true" /></td>
										<td align="center" style="padding:5px;"><bean:write name="stuResult"
												property="whichLesson" filter="true" /></td>
										<td align="center"><bean:write name="stuResult"
												property="joinTime" format="yyyy-MM-dd HH:mm:ss"
												filter="true" /></td>
										<td align="center"><bean:write name="stuResult"
												property="resSingle" filter="true" /></td>
									</tr>
								</logic:iterate>
								
							</table>
							<br>
							<div id="pages" align="center" style="padding:5px;">
									<c:choose>
										<c:when test="${page>1}">
											<a href="stuResult.do?action=stuResultQuery&page=${page-1}">
											<strong><font color="#007FFF">上一页</font></strong>&nbsp;</a>
										</c:when>
										<c:otherwise>
                								上一页&nbsp;
               							</c:otherwise>
									</c:choose>

									<c:forEach var="p" begin="1" end="${totalPages}">
										<c:choose>
											<c:when test="${p==page}">
												<a class="current_page">${p}</a>
											</c:when>
											<c:otherwise>
												<a href="stuResult.do?action=stuResultQuery&page=${p}"><strong><font color="#007FFF">${p}</font></strong></a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${page<totalPages}">
											<a href="stuResult.do?action=stuResultQuery&page=${page+1}">&nbsp;
											<strong><font color="#007FFF">下一页</font></strong></a>
										</c:when>
										<c:otherwise>
                							&nbsp;下一页
                					</c:otherwise>
									</c:choose>

								</div>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
