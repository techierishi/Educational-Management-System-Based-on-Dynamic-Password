<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生教务管理后台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="extjs/resources/css/ext-all.css">
<script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="extjs/locale/ext-lang-zh_CN.js"></script>
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
				title : btn.id,
				html : '<iframe width=100% height=100% src=' + btn.id + ' />',
				//autoLoad : '',
				closable : 'true'
			});
			tabPanel.setActiveTab(n);
		};
		var bt1 = new Ext.Button({
					id : 'index',
					text : '首页',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var bt2 = new Ext.Button({
					id : 'test',
					text : '首页2',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var bt3 = new Ext.Button({
					id : 'select',
					text : '课程查询',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var bt4 = new Ext.Button({
					id : 'scselect',
					text : '分数查询',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var bt5 = new Ext.Button({
					id : 'user1',
					text : '个人账户管理',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var bt6 = new Ext.Button({
					id : 'user2',
					text : '账户信息维护',
					width : '100%',
					listeners : {
						click : addPanel
					}

				});
		var item1 = new Ext.Panel( {
			title : '首页',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [bt1,bt2]
		});
		
		var item2 = new Ext.Panel( {
			title : '课程维护',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [bt3,bt4	]
		});

		var item3 = new Ext.Panel( {
			title : '用户维护',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [bt5,bt6	]
		});

		var accordion = new Ext.Panel( {
			region : 'west',
			margins : '5 0 5 5',
			split : true,
			width : 210,
			layout : 'accordion',
			items : [ item1, item2, item3 ]
		});

		var tabPanel = new Ext.TabPanel( {
			region : 'center',
			enableTabScroll : true,
			deferredRender : false,
			activeTab : 0,
			items : [ {

				title : 'index',
				//html : 'aaaaaa'
				autoLoad : 'login.jsp'
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
