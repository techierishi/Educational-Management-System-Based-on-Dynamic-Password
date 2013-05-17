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
	<style type="text/css">
    ul.circle {list-style-type:circle}
	a:link{ color:#f00;decoration:none ;text-decoration:none} 
	a:visited{color:#00F/;decoration:none; text-decoration:none} 
	a:hover{ color:#F00 ;text-decoration:none}
	a:active{ color:#F00;text-decoration:none}
    </style>
  </head>
  
  <body>
    	<table border="1" align="center">
		<tr>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>教师</th>
		</tr>
		
		 <s:iterator value="courselist">
		<tr>
			<td><s:property value="couid"/></td>
			<td><s:property value="couname"/></td>
			<td><s:property value="teacher.teaname"/></td>
		</tr>
		</s:iterator>
	</table>
  </body>
</html>
