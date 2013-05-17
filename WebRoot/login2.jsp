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
<!--	<link rel="stylesheet" type="text/css" href="styles.css">	-->	
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/csdn.css">
<style>
select{position:relative;left:-2px;top:-2px;width:118px;line-height:14px;border:0px;color:#3366CC;}
.box{position:relative;border:1px solid #cccccc;width:118px;height:20px;clip:rect(0px,89px,18px,0px);overflow:hidden;}
.box2{border:1px solid #F4F4F4;width:118px;height:18px;clip:rect(0px,88px,18px,0px);overflow:hidden;}
.style1 {color: #1A50B8}

</style>


</head>
<body>
    <div id="logingif">
    <table><tr>
    <td background="images/BgLoginA.gif" width="710"></td>
    <td><img src="images/BgLogin.png" /></td>
    </tr>    </table>
    </div>
    <div align="center" id="login"  align="right">
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
            <th></th>
            <th align="center"><input type="submit"  value="登录" align="middle"/></th>
        </form>
    </table>
    </div>
     <br>
</body>
</html>
