<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
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
<script language="javascript" type="text/javascript">

	function count() {

			window.location = "login2.jsp"; 
		}	
</script>
<script type="text/javascript">
	Ext.onReady( function() {
		var addPanel = function(btn, event) {
			var n;
			n = tabPanel.getComponent(btn.id);
			if(n) {
				tabPanel.setActiveTab(n);
				return;
			}
			n = tabPanel.add( {
				id : btn.id,
				title : btn.text,
				html : '<iframe width=100% height=100% src=' + btn.id+'.jsp' + ' />',
				//autoLoad : '',
				closable : 'true'
			});
			tabPanel.setActiveTab(n);
		};
		var btindex_list =  new Ext.Button({
				id : 'news_list',
				text : '公告列表',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
				
		var btindex_insert =  new Ext.Button({
				id : 'news_insert',
				text : '发布公告',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
				
		var btstu_list = new Ext.Button({
				id : 'stu_list',
				text : '学生查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btstu_update = new Ext.Button({
				id : 'stu_update',
				text : '学生信息修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var bttea_list = new Ext.Button({
				id : 'tea_list',
				text : '教师查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var bttea_update = new Ext.Button({
				id : 'tea_update',
				text : '教师信息修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btcourse_list = new Ext.Button({
				id : 'course_list',
				text : '课程查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btcourse_update = new Ext.Button({
				id : 'course_update',
				text : '课程信息修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_list = new Ext.Button({
				id : 'user_list',
				text : '用户列表',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_register = new Ext.Button({
				id : 'register',
				text : '用户注册',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_largeregister = new Ext.Button({
				id : 'registerlarge',
				text : '批量用户注册',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_logout = new Ext.Button({
				id : 'logout',
				text : '用户登出',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});									
		var item1 = new Ext.Panel( {
			title : '首页',
			
			cls : 'empty',
			items : [ btindex_list,btindex_insert,btuser_logout]
		});

		var item2 = new Ext.Panel( {
			title : '学生信息管理',
			
			cls : 'empty',
			items : [ btstu_list,btstu_update]
		});

		var item3 = new Ext.Panel( {
			title : '教师信息管理',
			
			cls : 'empty',
			items : [ bttea_list,bttea_update]
		});
		var item4 = new Ext.Panel( {
			title : '课程管理',
			
			cls : 'empty',
			items : [ btcourse_list,btcourse_update]
		});
		var item5 = new Ext.Panel( {
			title : '用户信息维护',
			
			cls : 'empty',
			items : [ btuser_list,btuser_register,btuser_largeregister]
		});
		
		var accordion = new Ext.Panel( {
			region : 'west',
			margins : '5 0 5 5',
			split : true,
			width : 210,
			layout : 'accordion',
			items : [ item1, item2, item3, item4, item5 ]
		});

		var tabPanel = new Ext.TabPanel( {
			region : 'center',
			enableTabScroll : true,
			deferredRender : false,
			activeTab : 0,
			items : [ {

				title : 'index',

				html : '${user.account}<br/><s:property value="#session.user.account"/><br /><s:property value="#session.user.password" />    <form  method="post"  action="User!logout">    	确定要退出么?<br> <input type="submit"  value="确定退出" onclick="count()"/></form>	 	'	
				
				//autoLoad : 'login.jsp'
			} ]
		});

		var viewport = new Ext.Viewport( {
			layout : 'border',
			items : [ accordion, tabPanel ]
		});

	});
</script>
</head>
	
<body>

</body>
</html>