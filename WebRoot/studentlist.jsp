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
	<table border="1">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>院系</th>
			<th>专业</th>
			<th>班级</th>
			<th>民族</th>
			<th>生日</th>
			
		</tr>
		<s:iterator value="students">
    	
		<tr>
			<td><s:property value="stuid"/></td>
			<td><s:property value="stuname"/></td>
			<td><s:property value="sex"/></td>
			<td><s:property value="department"/></td>
			<td><s:property value="major"/></td>
			<td><s:property value="stuclass"/></td>
			<td><s:property value="national"/></td>
			<td><s:property value="birdata"/></td>
		</tr>
		</s:iterator>
	</table>

    <s:debug></s:debug>
  </body>
</html>
