var _app_path_ = '/arm-taxi-operator/';

hidden_sort_column_index="";
        hidden_sort_column_direction="";
    
    	function openOrder(orderid){
            
            window.open(_app_path_+"order/open?orderid="+orderid, "_blank", 'width=600,height=500');
            /*$.ajax({
		url : '/arm-taxi-operator/order/new',
		encoding: "UTF-8",
		method: 'GET'
	}).done(function (data) {
            
                alert("загружен заказ");
		
	}).error(function (e) {
		// stub
	});
            */
		
	}	
        
        function switchSortColumn(columnIndex){
            if (columnIndex===hidden_sort_column_index){
                if (hidden_sort_column_direction==="asc")
                    hidden_sort_column_direction="desc"
                else
                    hidden_sort_column_direction="asc";
            }
            else{
                hidden_sort_column_index = columnIndex;
                hidden_sort_column_direction="asc";
            }
            
           // refresh();
        }
    
    function refresh() {
        $('#work_orders_table').datagrid('reload'); 
      
        //обновление таблицы каждую секунду
        setTimeout(refresh , 1000);
    };
    
    function onLoadPage(){
        
        
        $('#work_orders_table').datagrid({
    url:_app_path_+'order/work_orders_json',
    method: 'get',
    singleSelect: true,
    loadMsg: '',
    title: 'Заказы в работе',
    fit: true,
    showFooter: true,
    rownumbers: true,
    idField: 'ID',  
    columns:[[
        {field:'ID',title:'ID',width:100},
        {field:'AddrFrom',title:'AddrFrom',width:100},
        {field:'AddrTo',title:'AddrTo',width:100},
        {field:'Phone',title:'Phone',width:100},
        {field:'Time',title:'Time',width:100},
        {field:'CarName',title:'CarName',width:100}
    ]]
    });
    $('#work_orders_table').datagrid({
    toolbar: [{
                iconCls: 'icon-edit',
                handler: function(){alert('edit')}
        },'-',{
                iconCls: 'icon-help',
                handler: function(){alert('help')}
        }]
    });
        
        
        
        var selected_row_id;
        
        
        
        
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
        
        
        
        
        
        $('#work_orders_table').datagrid({
	onDblClickCell: function(index,field,value){
            
            window.open(_app_path_+'order/open_dialog/'+selected_row_id, "_blank", 'width=600,height=500');
            
           /* $('#dialog_edit_order').dialog({
                closed:false,
		width: 700,
                iconCls:'icon-list-m1-edit',
                title:'Заказ',
                href:_app_path_+'order/open_dialog/'+selected_row_id,
                onLoad:function(){
                   //после загрузки окна - поменять обработчик submit
                $("#form_submit_button" ).on( "click", function( event ){
                //$("#form_edit_order" ).on( "submit", function( event ) {

                    event.preventDefault ? event.preventDefault() : (event.returnValue=false);

                    console.log( $("#dialog_edit_form").serialize() );

                    

                    $.post( _app_path_+'order/save', 
                            $("#dialog_edit_form" ).serialize())
                    .done(function( data ) {
                    alert( "Data Loaded: " + data );
                      })
                    .fail(function(data) {
                      alert( "error "+data );
                    })
                    .always(function(data) {
                      alert( "finished "+data );
                    });
                  

                });
                
                
                $("#form_submit_merge_button" ).on( "click", function( event ){
                    event.preventDefault ? event.preventDefault() : (event.returnValue=false);
                    console.log( $("#dialog_edit_form").serialize() );
                    $.post( _app_path_+'order/merge', 
                            $("#dialog_edit_form" ).serialize());
                });
                }
                
        });
        
        */
	}
        });
        
        
        
        $('#work_orders_table').datagrid({
	onRowContextMenu: function(e,index,row){
		
	}
        });        
        
        
        
        
        $('#work_orders_table').datagrid({
                onLoadSuccess:function(data){
                    
                    rows = $('#work_orders_table').datagrid('getRows');
                    top_row_index = $('#work_orders_table').datagrid('getRowIndex', rows[0]);
                    
                    if (rows != null){
                        
                    }
                    
                    
                    $('#work_orders_table').datagrid('selectRecord', selected_row_id);
                    
                    $('#work_orders_table').datagrid('scrollTo', top_row_index);
                }
        });
        
        
        
        
        
     
    }