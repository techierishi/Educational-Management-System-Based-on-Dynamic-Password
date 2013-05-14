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
<title>用户登录</title>
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
    
    <div align="center"  style="width:260px " >
<table  align="center" >
        <form method="post"  action="User!login" >
            <tr>
            	<th>用户名：</th>
            	<th><input type="text"  name="account" align="right"></th>
            </tr>
            <tr>
            	<th>密码：</th>
           		<th><input type="password" name="password" align="right"></th>
            </tr>
            <tr>
            <tr>
            <th>动态密码：</th>
            	<th><input type="text" name="ekey" align="right"></th>
            </tr>
            <th><input type="submit"  value="提交" align="middle"/></th>
        </form>
    </table>
    </div>
     <br>
     <s:debug></s:debug>
</body>
</html>
