Ext.application({
    name: 'AM',

    appFolder: 'app',

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'userlist',
					buttons: [
					{
						text: 'Register',	
						formBind: true
						}
					],
					 
                }
            ],
			
        });
    },
	    
	controllers: ['Users']

});
