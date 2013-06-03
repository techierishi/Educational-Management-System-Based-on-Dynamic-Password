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
		<form method="post" action="Score!find">
    		学生编号：<input type="text"  name="stuid"><br>
    		课程编号：<input type="text"  name="couid"><br>
    		课程名称：<input type="text"  name="couname"><br>
    		学生名称：<input type="text"  name="stuname"><br>
    		所在院系：<input type="text"  name="department"><br>
    		所在专业：<input type="text"  name="major"><br>
    		所在班级：<input type="text"  name="stuclass"><br>
			<input type="submit" value="查询" />
		</form>
	</div>


    <s:debug></s:debug>
  </body>
</html>
