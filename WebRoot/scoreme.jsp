<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
	<div  align="center">
	<table border="1">
		<tr>
			<th>姓名</th>
			<th>课程</th>
			<th>任课教师</th>
			<th>院系</th>
			<th>专业</th>
			<th>班级</th>
			<th>平时成绩</th>
			<th>卷面成绩</th>
			<th>总成绩</th>
						
		</tr>
		<s:iterator value="scores">
		<tr>
			<td><s:property value="student.stuname"/></td>
			<td><s:property value="course.couname"/></td>
			<td><s:property value="course.teacher.teaname"/></td>
			<td><s:property value="student.department"/></td>
			<td><s:property value="student.major"/></td>
			<td><s:property value="student.stuclass"/></td>
			<td><s:property value="usuallyscore"/></td>
			<td><s:property value="paperscore"/></td>
			<td><s:property value="sumscore"/></td>
		</tr>
		</s:iterator>
	</table>
	</div>
    <s:debug></s:debug>
  </body>
</html>
