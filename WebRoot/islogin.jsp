<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%

 if(session.getAttribute("user")==null)
{
%>
     <script>
          alert("请登录!");
         window.location.href="login2.jsp";<!--这里是你的登录页面 -->
     </script>
     <%
}
%>
