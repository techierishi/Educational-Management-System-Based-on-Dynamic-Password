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

  	<ul class="circle">
    
    <s:iterator value="newslist"  status="st">
    	<li>
    	<a href="News!look?newsid=<s:property value="newsid"/>">  <s:property value="newstitle"/> </a>
    	<div align="right"><s:property value="newsdate"/></div>
      	</li>
    </s:iterator> 

    </ul>
  
  </body>
</html>
