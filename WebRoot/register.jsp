<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户注册</title>
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
    <form method="post"  action="User!register">
    	用户名：<input type="text"  name="account"><br>
    	密码：<input type="password" name="password"><br>
    	确认密码：<input type="password" name="password2"><br>
	    姓名：<input type="text"  name="username"><br>
	   性别：<select name="sex" >  
				   <option value="男">男</option> 
				   <option value="女">女</option>
				  </select>  <br>
    	用户类型：<select name="type" >  
				   <option value="1">学生</option> 
				   <option value="2">教师</option>
				   <option value="3">管理员</option>
				  </select>  <br>
    	用户状态：<select name="status" >  
				   <option value="1">激活</option> 
				   <option value="2">异常</option>
				   <option value="3">登录</option>
				   <option value="4">其他</option>
				  </select>  <br>
    	用户权限：<select name="permissions" >  
				   <option value="1">普通用户</option> 
				   <option value="2">管理用户</option>
				  </select>  <br>
    	加密序列号：<input type="text"  name="ekey"><br>


    	<input type="submit"  value="提交"/>
    </form>
     <br>
</body>
</html>
