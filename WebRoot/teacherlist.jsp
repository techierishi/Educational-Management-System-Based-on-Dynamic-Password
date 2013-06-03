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
		<form method="post" action="Teacher!listexample">
		    	教号精确查找 :<input type="text" name="teaid" ><br>
		    	条件查找:姓名：<input type="text" name="teaname" >
			   	性别：<select name="sex"   >  
						   <option value="">不限</option> 
						   <option value="男">男</option> 
						   <option value="女">女</option>
						  </select>  
				院系：<input type="text" name="department" ><br>
			<input type="submit" value="查询" />
		</form>
	</div>
    <div align="center">
    	<table border="1">
		<tr>
			<th>教号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>院系</th>
		</tr>
		<tr>
			<td><s:property value="teacher.teaid"/></td>
			<td><s:property value="teacher.teaname"/></td>
			<td><s:property value="teacher.sex"/></td>
			<td><s:property value="teacher.department"/></td>

		</tr>
		<s:iterator value="teachers">
		<tr>
			<td><s:property value="teaid"/></td>
			<td><s:property value="teaname"/></td>
			<td><s:property value="sex"/></td>
			<td><s:property value="department"/></td>
		</tr>
		</s:iterator>
	</table>
	</div>
    <s:debug></s:debug>
  </body>
</html>
