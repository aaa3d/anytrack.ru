var _app_path_ = '/anytrack.ru/';


function mergeWorkpoints(){
    checked_rows = $('#work_orders_table').datagrid('getChecked');
    var ids = [];
    for (var i = 0; i < checked_rows.length; i++) {
        ids[i] = checked_rows[i].ID;
    }
    
    
    
    
    ids = JSON.stringify(ids);
    
    $.ajax({
		url : _app_path_+'Workpoint/Merge',
		encoding: "UTF-8",
		data: ids,
		method: 'POST',
                contentType: "application/json; charset=utf-8",
	}).done(function (data) {
		
	}).error(function (e) {
		// stub
	});

  
}


function SetWorker(step, worker_id){
    
    //1. show Dialog
    //2. send command to server? onOK - reload
    
    if (step === 1){
        
        $('#dialog_select_worker').dialog({
                closed:false,
		width: 700,
                height: 400,
                iconCls:'icon-list-m1-edit',
                title:'Выбор исполнителя',
                href:_app_path_+'Workpoint/DialogSelectWorker/',
                onLoad:function(){
                   //после загрузки окна - поменять обработчик submit
                $("#form_OK_button" ).on( "click", function( event ){
                //$("#form_edit_order" ).on( "submit", function( event ) {
                
                selected_row = $('#dictionary_list_table').datagrid('getSelected');
                if (selected_row !== null){
                    selected_row_id = selected_row.id;
                
                    SetWorker(2, selected_row_id);
                }
                });
                }
            });
        }
    
    if (step === 2){
    checked_rows = $('#work_orders_table').datagrid('getChecked');
    var ids = [];
    
    ids[0] = worker_id;
    
    for (var i = 0; i < checked_rows.length; i++) {
        ids[i+1] = checked_rows[i].ID;
    }
    
    ids = JSON.stringify(ids);
    
    
    
    $.ajax({
		url : _app_path_+'Workpoint/SetWorker',
		encoding: "UTF-8",
		data: ids,
		method: 'POST',
                contentType: "application/json; charset=utf-8",
	}).done(function (data) {
            
            ReloadGridData();
            
	}).error(function (e) {
		// stub
	});
    }
}




function ReloadGridData(){
    $('#work_orders_table').datagrid('load',_app_path_+'Workpoint/ListJson');
    /*$.ajax({
		url : _app_path_+'Workpoint/ListJson',
		encoding: "UTF-8",
		method: 'GET'
	}).done(function (data) {
            
            $('#work_orders_table').datagrid('reload',_app_path_+'Workpoint/ListJson');
           
        })
	.error(function (e) {
		// stub
	});
        */
}



function onLoadPage(){
        
        
   
        
        
        
    $('#work_orders_table').datagrid({
    //url:_'app_path_+'Workpoint/ListJson'',
    url:'',
    method: 'get',
    singleSelect: false,
    loadMsg: '',
    title: 'Заказы в работе',
    fill: true,
    fit: false,
    showFooter: true,
    rownumbers: true,
    idField: 'ID',  
    view:groupview,
    groupField:'ChainId',
    groupFormatter:function(value,rows){
                    return value + ' - [ ' + rows.length + ' ]';
                },
/*    rowStyler: function(index,row){
                    
                        return 'background-color:#6293BB;color:#fff;font-weight:bold;';
                    
                },
*/                
    columns:[[
        {field:'ID',title:'ID',width:100, hidden: true},
        {field:'ChainId',title:'ChainId',width:100, hidden: true},
        {field:'ChainOrder',title:'ChainOrder',width:100, hidden: false},
        
        
        {field:'checkbox', checkbox:true, title:'',width:100},
        {field:'ChainAction',title:' ', width:150},
        {field:'NewDate',title:'Дата создания',width:100},
        {field:'PlanDate',title:'На дату',width:100},
        {field:'Phone',title:'Телефон',width:100},
        {field:'Address',title:'Адрес',width:100},
        {field:'Description',title:'Примечание',width:100},
        {field:'Action',title:'Действие'},
        
        
    ]]
    });
    /*
    
    $('#work_orders_table').datagrid({
    toolbar: [{
                iconCls: 'icon-edit',
                handler: function(){alert('edit')}
        },'-',{
                iconCls: 'icon-help',
                handler: function(){alert('help')}
        }]
    });
   
   */
        
        var selected_row_id;
        
        
        
        /*
        $('#work_orders_table').datagrid({
                onClickRow:function(index,row){
                    if (row != null){
                    selected_row_id = row.ID;
                    }
                }
        });
        
        
        $('#work_orders_table').datagrid({
                onBeforeLoad:function(query_params){
                    selected_row = $('#work_orders_table').datagrid('getSelected');
                    if (selected_row != null){
                    selected_row_id = selected_row.ID;
                    }
                    
                }
        });
        */
       /*
        $('#work_orders_table').datagrid({
                onLoadSuccess:function(data){
                    
     
                 //   $(this).datagrid('getPanel').find('.datagrid-row').css('height', '24px')
   
                    
                    rows = $('#work_orders_table').datagrid('getRows');
                    top_row_index = $('#work_orders_table').datagrid('getRowIndex', rows[0]);
                    
                    if (rows != null){
                        
                    }
                    
                    
                    $('#work_orders_table').datagrid('selectRecord', selected_row_id);
                    
                    $('#work_orders_table').datagrid('scrollTo', top_row_index);
                }
        });*/
       
   
   
   
        ReloadGridData();
   
    }