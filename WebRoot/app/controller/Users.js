Ext.define('AM.controller.Users', {
	//控制器
    extend: 'Ext.app.Controller',
	stores: ['Users'],
	models: ['User'],
	views: [
        'user.List',
		
	//	'user.Edit'
    ],
    init: function() {
        this.control({
           'userlist': {
                itemdblclick: this.editUser
            },
/*		    'useredit button[action=save]': {
                click: this.updateUser
            }
*/
        });
    },
	
	//用户更新
/*	updateUser: function(button) {
        var win    = button.up('window'),
        form   = win.down('form'),
        record = form.getRecord(),
        values = form.getValues();

	    record.set(values);
    	win.close();
		this.getUsersStore().sync();
    },
	
	//行编辑函数
    editUser: function(grid, record) {
        var view = Ext.widget('useredit');

        view.down('form').loadRecord(record);

    },*/

 /*   onPanelRendered: function() {
        console.log('The panel was rendered');
    },
*/
});
