<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    <form method="post"  action="User!delete">
    	�û�id:<input type="text" name="userid">
 <!--    	�û�����<input type="text"  name="account"><br>
    	���룺<input type="password" name="password"><br>
	   �Ա�<select name="sex" >  
				   <option value="��">��</option> 
				   <option value="Ů">Ů</option>
				  </select>  <br>
    	�û����ͣ�<select name="type" >  
				   <option value="1">ѧ��</option> 
				   <option value="2">��ʦ</option>
				   <option value="3">����Ա</option>
				  </select>  <br>
    	�û�״̬��<select name="status" >  
				   <option value="1">����</option> 
				   <option value="2">�쳣</option>
				   <option value="3">��¼</option>
				   <option value="4">����</option>
				  </select>  <br>
    	�û�Ȩ�ޣ�<select name="permissions" >  
				   <option value="1">��ͨ�û�</option> 
				   <option value="2">�����û�</option>
				  </select>  <br>
    	�������кţ�<input type="text"  name="ekey"><br> -->


    	<input type="submit"  value="�ύ"/>
    </form>
    <s:debug></s:debug>
  </body>
</html>
