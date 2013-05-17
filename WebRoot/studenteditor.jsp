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
    <form method="post"  action="Student!update">
    	学号:<input type="text" name="stuid" value="<s:property value="student.stuid"/>">
    	姓名：<input type="text" name="stuname"  value="<s:property value="student.stuname"/>"><br>
	   	性别：<select name="sex"   >  
				   <option value="男">男</option> 
				   <option value="女">女</option>
				  </select>  <br>
		院系：<input type="text" name="department" value="<s:property value="student.department"/>"><br>
		专业：<input type="text" name="major" value="<s:property value="student.major"/>"><br>
		班级：<input type="text" name="stuclass" value="<s:property value="student.stuclass"/>"><br>
		民族：<input type="text" name="national" value="<s:property value="student.national"/>"><br>
		生日：<input type="text" name="birdata" value="<s:property value="student.birdata"/>"><br>


    	<input type="submit"  value="提交"/>
    </form>

    <s:debug></s:debug>
  </body>
</html>
