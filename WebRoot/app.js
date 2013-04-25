Ext.Loader.setConfig({enabled: true});        //开启动态加载
Ext.application({
    name:'et',            //呵呵，就是ExtTest
    autoCreateViewport: true,
    appFolder:'app',    //指定根目录
    controllers:[        
        'KitchenSink.view.grid.CellEditing'//在这里引入菜单，下次将详细介绍如何实现菜单加载
    ]
});