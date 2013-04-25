Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '用户批量注册',
	xtype: 'cell-editing',
	requires: [
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'AM.model.User'
    ],
	frame: true,

    initComponent: function() {
		 
		//初始？
		this.cellEditing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 1
        });

		Ext.apply(this,{
			
		//添加new Ext.grid.plugin.CellEditing
		plugins: [this.cellEditing],		
		//store
		store : ['Users'],
		//对grid行列设置
		columns: [
				{
				header: '账号', 
				 dataIndex: 'account',  
				 flex: 2,
				 editor:{
					 allowBlank: false ,
					 xtype : 'textfield',
					 },
					 
				},
				{header: '密码', 
				dataIndex: 'password', 
				flex: 2,
				editor: {
						xtype: 'textfield',
						allowBlank: false,
					}
				},
				{header: '类型',  
				dataIndex: 'type',  
				flex: 1,
				editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    selectOnTab: true,
                    store: [
                        ['学生','学生'],
                        ['教师','教师'],
                        ['管理员','管理员'],
                    ],
                    lazyRender: true,
                    listClass: 'x-combo-list-small'
                })
				},
				{header: '状态',  dataIndex: 'status',  flex: 1,
				 editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    selectOnTab: true,
                    store: [
                        ['激活','激活'],
                        ['未激活','未激活'],
                        ['封停','封停'],
                    ],
                    lazyRender: true,
                    listClass: 'x-combo-list-small'
                })
				},
				{header: '权限',  dataIndex: 'permissions',  flex: 1,
				 editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    selectOnTab: true,
                    store: [
                        ['普通用户','普通用户'],
                        ['管理用户','管理用户'],
                    ],
                    lazyRender: true,
                    listClass: 'x-combo-list-small'
                })
				},
				//删除按钮
				{
					xtype: 'actioncolumn',
					width: 30,
					sortable: false,
					menuDisabled: true,
					items: [{
						icon: 'images/icons/fam/delete.gif',
						tooltip: 'Delete Plant',
						scope: this,
						handler: this.onRemoveClick
					}]
				}
				
				],
				
				//不懂
				selModel: { selType: 'cellmodel'
            },
				//顶端添加按钮Add
				tbar: [{
					text: '添加用户',
					scope: this,
					handler: this.onAddClick
				}],

		});//apply尾巴
		


        this.callParent(arguments);
		this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
    },
	
	
	//读取store
	loadStore: function() {
        this.getStore().load({
            // store loading is asynchronous, use a load listener or callback to handle results
            callback: this.onStoreLoad
        });
    },
    
 
//查询完成后弹出窗口提示  
	onStoreLoad: function(){
        Ext.Msg.show({
            title: 'Store Load Callback',
            msg: 'store was loaded, data available for processing',
            icon: Ext.Msg.INFO,
            buttons: Ext.Msg.OK
        });
    },

	
	//添加一行函数
	onAddClick: function(){
        // Create a model instance
        var rec = new AM.model.User({
            account: 'NEW ACCOUNT',
            password: '123456',
			type:'学生',
			status:'激活',
			permissions:'普通用户',
			
        });
        
        this.getStore().insert(0, rec);
        this.cellEditing.startEditByPosition({
            row: 0, 
            column: 0
        });
    },
	
	//删除行函数
	onRemoveClick: function(grid, rowIndex){
        this.getStore().removeAt(rowIndex);
    }
});
