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
    <form method="post"  action="Teacher!update">
    	教号:<input type="text" name="teaid" value="<s:property value="teacher.teaid"/>">
    	姓名：<input type="text" name="teaname"  value="<s:property value="teacher.teaname"/>"><br>
	   	性别：<select name="sex"   >  
				   <option value="男">男</option> 
				   <option value="女">女</option>
				  </select>  <br>
		院系：<input type="text" name="department" value="<s:property value="teacher.department"/>"><br>
    	<input type="submit"  value="提交"/>
    </form>
  </body>
</html>
