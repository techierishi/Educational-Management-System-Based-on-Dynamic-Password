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
<title>教务管理系统后台页面</title>
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
				html : '<iframe width=100% height=100% src=' + btn.id + ' />',
				//autoLoad : '',
				closable : 'true'
			});
			tabPanel.setActiveTab(n);
		};
		var btindex_list =  new Ext.Button({
				id : 'News!list',
				text : '公告列表',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
				
		var btindex_insert =  new Ext.Button({
				id : 'writenews.jsp',
				text : '发布公告',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
				
		var btstu_list = new Ext.Button({
				id : 'Student!list',
				text : '学生查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btstu_update = new Ext.Button({
				id : 'studentupdate.jsp',
				text : '学生信息修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btstu_delete = new Ext.Button({
				id : 'studentdelete.jsp',
				text : '学生信息删除',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var bttea_list = new Ext.Button({
				id : 'Teacher!list',
				text : '教师查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var bttea_update = new Ext.Button({
				id : 'teacherupdate.jsp',
				text : '教师信息修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var bttea_delete = new Ext.Button({
				id : 'teacherdelete.jsp',
				text : '教师删除',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btcourse_list = new Ext.Button({
				id : 'Course!list',
				text : '课程查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btcourse_update = new Ext.Button({
				id : 'courseadd.jsp',
				text : '课程添加',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btcourse_delete = new Ext.Button({
				id : 'coursedelete.jsp',
				text : '课程删除',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btscore_add = new Ext.Button({
				id : 'scoreadd.jsp',
				text : '分数添加',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btscore_find = new Ext.Button({
				id : 'scorefind.jsp',
				text : '分数查询',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btscore_me = new Ext.Button({
				id : 'Score!me',
				text : '我的分数',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});		
		var btuser_list = new Ext.Button({
				id : 'User!list',
				text : '用户列表',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_register = new Ext.Button({
				id : 'register.jsp',
				text : '用户注册',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_largeregister = new Ext.Button({
				id : 'registerlarge.jsp',
				text : '批量用户注册',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});
		var btuser_updatepwd = new Ext.Button({
				id : 'userupdatepwd.jsp',
				text : '密码修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});	
		var btuser_updateekey = new Ext.Button({
				id : 'userupdateekey.jsp',
				text : '动态密码修改',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});			
		var btuser_delete = new Ext.Button({
				id : 'userdelete.jsp',
				text : '用户删除',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});					
		var btuser_logout = new Ext.Button({
				id : 'newsdelete.jsp',
				text : '公告删除',
				width : '100%',
				listeners : {
				click : addPanel
					}
				});									
		var item1 = new Ext.Panel( {
			title : '首页',
			
			cls : 'empty',
			items : [ btindex_list]
		});

		var item4 = new Ext.Panel( {
			title : '课程管理',
			
			cls : 'empty',
			items : [ btscore_me]
		});
		var item5 = new Ext.Panel( {
			title : '用户信息维护',
			
			cls : 'empty',
			items : [btuser_updatepwd,btuser_updateekey]
		});
		
		var accordion = new Ext.Panel( {
			region : 'west',
			margins : '5 0 5 5',
			split : true,
			width : 210,
			layout : 'accordion',
			items : [ item1, item4, item5 ]
		});

		var tabPanel = new Ext.TabPanel( {
			region : 'center',
			enableTabScroll : true,
			deferredRender : false,
			activeTab : 0,
			items : [ {

				title : 'index',

				html : '<p>您好：${user.account}<br/> </p>   <form  method="post"  action="User!logout">    	确定要退出么?<br> <input type="submit"  value="确定退出" onclick="count()"/></form>	 	'	
				
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
