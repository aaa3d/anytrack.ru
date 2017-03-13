<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
<head>
<title>ЛАБОРАНТ</title>

<%@include file="styles.jsp" %>
<%@include file="frameworks_scripts.jsp" %>

<script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>



<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>


</style>


<script>
   
   function status_change_button_clicked(){
        $.ajax({
		url : '/arm-taxi-operator/laborant_status_change',
		encoding: "UTF-8",
		method: 'GET'
	}).done(function (data) {
                $("#current_time_string").html(data.current_time_string );
              //  $("#status_change_time_string").html(data.status_change_time_string );
                $("#status_change_button").val(data.current_status_string + ' ' + data.status_change_time_string);
                
		                
	}).error(function (e) {
		// stub
	});
   }
   
   
   function refresh() {
        //returns laborant object as json object
        $.ajax({
		url : '/arm-taxi-operator/laborant_data_json',
		encoding: "UTF-8",
		method: 'GET'
	}).done(function (data) {
                $("#current_time_string").html(data.current_time_string );
              //  $("#status_change_time_string").html(data.status_change_time_string );
                $("#status_change_button").val(data.current_status_string  + ' ' + data.status_change_time_string);
		                
	}).error(function (e) {
		// stub
	});
        
        //обновление таблицы каждую секунду
        setTimeout(refresh , 1000);
    };
    
    function onLoadPage(){
        refresh()
    }
</script>

</head>
<body onload="onLoadPage()">


 <!--
 Текущее время
 Кнопка занят-свободен
 Таймер текущего состояния
 Номер ожидаемого пациента
 -->
    
 <div> 
     <label id="current_time_string"></label>
 </div>
 <div> 
     <input type="button" id="status_change_button" onclick="status_change_button_clicked()" />
 </div>
 
 <div> 
     <label id="status_change_time_string"></label>
 </div>
 
 <div> 
     <label>${current_patient_number}</label>
     <label>${current_patient_IO}</label>
 </div>

  

</body>
</html>
