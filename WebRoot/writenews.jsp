<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>文章发布</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		-->
	<script src="sample.js" type="text/javascript" ></script>
	<script src="ckeditor.js" type="text/javascript"></script>
	<link  href="css/sample.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <form method="post"  action="News!write">
    	标题：<input type="text"  name="newstitle"><br>
	    文章内容：<textarea  class="ckeditor"  cols="80" rows="10"  id="editor1" name="newscontent"></textarea><br>

    	<input type="submit"  value="提交"/>
    </form>
     <br>
</body>
</html>
