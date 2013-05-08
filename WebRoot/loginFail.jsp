<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录失败</title>
    
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

    <form name="loading">

<p align="center"> 登录失败. <br>
    用户名或密码错误<br>
    正在跳转，请稍后...</p>
   
<p align="center"> 
<input type="text" name="bar" style="border-style:none; background-color:#D3E8D0; font-weight:bold" /> 
<input type="text" name="percentage"style="border-style:none; background-color:#FFFFFF; max-width:30px"/> 
</p>

<p align="center"> 
如果您的浏览器不支持跳转，请点击<a href="login2.jsp">这里</a>手动跳转 
</p>

<script language="javascript" type="text/javascript"> 
var percent=0; //百分比进度，显示在滚动条后面 
var element="||"; //滚动条单元竖线 
var elements="||"; //滚动条当前竖线 
count(); //开始调用循环

function count(){ 
percent=percent+10; //每次百分比加10 
elements =elements + element; //滚动条当前竖线增加一个滚动条单元竖线 
document.loading.bar.value=elements; //设置窗体loading表单中bar元素的当前值 
document.loading.percentage.value=percent+"%"; //设置窗体loading表单中percentage元素的当前值 
if (percent<99){ //percent小于99则继续循环 
setTimeout("count()",500); //每500ms进行一次count() 
} 
else{ 
window.location = "login2.jsp"; //percent达到100时跳转 
} 
} 
</script>

</form> 
  </body>
</html>
