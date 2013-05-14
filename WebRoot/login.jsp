<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登录页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page"> 
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css">
<script type="text/javascript" src="extjs/ext-all.js" ></script>
<script type="text/javascript" src="extjs/locale/ext-lang-zh_CN.js" ></script>
<script type="text/javascript">

Ext.define('LoginForm', {
    extend: 'Ext.form.Panel',
    xtype: 'login-form',
    baseParams : {create : true },  
    url: 'User!login2',
    title: '登录——华中科技大学武昌分校教务管理系统',
    frame:true,
    width: 320,
    bodyPadding: 10,
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
    },

    items: [
        {
            allowBlank: false,
            fieldLabel: '用户账号',
            name: 'account',
            emptyText: '在这输入您的账号'
        },
        {
            allowBlank: false,
            fieldLabel: '用户密码',
            name: 'password',
            emptyText: '在这输入您的密码',
            inputType: 'password'
        },
		{
            allowBlank: true,
            fieldLabel: '动态密码',
            name: 'ekey',
            emptyText: '如果没有可不填'
        },
        {
            xtype:'checkbox',
            fieldLabel: '记住我',
            name: 'remember'
        }
    ],
    
  
	buttons : [ {
			text : '登录',

			handler : function() {
			var form = this.up('form').getForm();
			 if (form.isValid()) {
                // Submit the Ajax request and handle the response
                form.submit({
                    success: function(form, action) {
                       Ext.window.location = "admin.jsp";
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('Failed', action.result ? action.result.message : 'No response');
                    }
                });
                }
			}
 			
		} ]
	});
	Ext.onReady(function() {
		var login = new LoginForm;
		var viewport = new Ext.Viewport({
			items : [ login ]
		});
	});
</script>
</head>

<body>
<div id="login">


</div>
</body>
</html>
