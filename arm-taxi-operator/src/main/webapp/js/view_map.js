var _app_path_ = '/arm-taxi-operator/';
var map;

hidden_sort_column_index = "";
hidden_sort_column_direction = "";


function refresh() {
    $('#work_orders_table').datagrid('reload');

    //обновление таблицы каждую секунду
    setTimeout(refresh, 1000);
}
;

function requestUpdate(){
        $.ajax({
		url : _app_path_+'/map/get_json_objects',
		encoding: "UTF-8",
		method: 'GET'
	}).done(function (data) {
            //data = json array of cars
            result = data;
            update(result);
               // $("#current_time_string").html(data.current_time_string );
              //  $("#status_change_time_string").html(data.status_change_time_string );
               // $("#status_change_button").val(data.current_status_string  + ' ' + data.status_change_time_string);
		                
	}).error(function (e) {
		// stub
	});
}


function update (object_array){
    
  //  for(var k in object_array) {
   //     console.info(object_array[k]);
    //}
    
    var iconStyle = new ol.style.Style({
        image: new ol.style.Icon( ({
			src: 'https://openlayers.org/en/v3.20.1/examples/data/icon.png'
        }))
      });
	
	
	
	 var vectorSource = new ol.source.Vector({
       // features: [iconFeature]
      });
	  n = 0;
	  for(var k in object_array) {
   //     console.info(object_array[k]);
    //
		
		
			//var coord = [object_array[k].lat, object_array[k].lon];
			if (object_array[k].lon>0 ){
			n = n+1;
			var coord = ol.proj.transform([object_array[k].lon/1000000, object_array[k].lat/1000000], 'EPSG:4326', 'EPSG:3857');
			//var coord = ol.proj.transform([37, 57], 'EPSG:4326', 'EPSG:3857');
			var iconFeature = new ol.Feature({
			
			
				geometry: new ol.geom.Point(coord),
				name: object_array[k].Name,
				speed: object_array[k].speed,
				ID: object_array[k].ID,
				style: iconStyle
			  });

	  
	  
	   iconFeature.setStyle(iconStyle);
	   vectorSource.addFeature(iconFeature);
	   }
	   }

     
	  
	   var vectorLayer = new ol.layer.Vector({
        source: vectorSource
      });

	  map.addLayer(vectorLayer);
}

function onLoadPage() {

    map = new ol.Map({
        view: new ol.View({
            center: ol.proj.transform([39.841789, 57.585533], 'EPSG:4326', 'EPSG:3857'),
            zoom: 10
        }),
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
        ],
        target: 'map'
    });
    
    requestUpdate();
	
	
	  
}
;





