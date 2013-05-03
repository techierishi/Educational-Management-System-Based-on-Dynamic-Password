Ext.define('et.view.Viewport',{ 
    extend: 'Ext.Viewport', 
    layout: 'fit', 
    hideBorders: true, 
    requires : [ 
        'KitchenSink.view.grid.CellEditing', 
    ], 
    initComponent : function(){ 
        var me = this; 
        Ext.apply(me, {                         //这里讲items加入当前类（即Viewport），其实直接配置Viewport的items效果一样
            items: [{ 
                id:'desk', 
                layout: 'fit',                 //这个是个重点，该布局实现“东西南北中”布局，具体细节可自己查找，网上一大堆
                items: [ 
                    Ext.create('KitchenSink.view.grid.CellEditing'),         //创建上侧头

                ] 
            }] 
        }); 
        me.callParent(arguments); 
    } 
});