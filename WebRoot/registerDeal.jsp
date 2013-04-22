<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String account = request.getParameter("account");
System.out.println(account);
String password = request.getParameter("password");
String password2 = request.getParameter("password2");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school","root","root"); 

String sqlQuery = "select count(*) from user where account = ?";
PreparedStatement psQuery = conn.prepareStatement(sqlQuery);
psQuery.setString(1, account);
ResultSet rs = psQuery.executeQuery();
rs.next();
int count = rs.getInt(1);
if(count >0){
		response.sendRedirect("registerFail.jsp");
		psQuery.close();
		conn.close();
		return ;
}

String sql = "insert into user values(null,?,?,null,null,null)";
PreparedStatement ps = conn.prepareStatement(sql); 
ps.setString(1, account);
ps.setString(2, password);
ps.executeUpdate();
ps.close();
conn.close();

response.sendRedirect("registerSuccess.jsp");
%> 
 
 