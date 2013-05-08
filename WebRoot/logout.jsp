<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登出</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		-->
<link rel="stylesheet" type="text/css" href="extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css">
<script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="extjs/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" ></script>
</head>

<body>
    <form  method="post"  action="User!logout">
    	确定要退出么?<br>
    	<input type="submit"  value="确定退出"  />
    </form>
     <br>
     <s:debug></s:debug>
</body>
</html>
