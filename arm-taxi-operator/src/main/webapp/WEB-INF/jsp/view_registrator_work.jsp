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
        //refresh()
    }
</script>

</head>
<body onload="onLoadPage()">


 <!--
 Текущее время
 
 3 таблицы с талонами: текущая, + 1 период, +2 периода.
 в них : обработаные талоны, выданные, выданные не по времени, свободные (серые, зеленые, белые)
 внизу: кнопки: выдать "по времени", выдать "пришел не ко времени" (раньше-позже - неважно, в следующий период но не более +2 в период)
 
 Кнопка занят-свободен
 Таймер текущего состояния
 Номер ожидаемого пациента
 
 структура талонов:
 
 id
 tm
 time
 number
 status (on_time, not_on_time, closed)
 laborant_id
 
 
 
 
 
 
 -->
    
 <div id="top_panel"> 
     Дата и время текущего окна расписания
     
 </div>
 <div> 
     Таблица с таймслотами
     
    <c:forEach var="timeslot_name" items="${timeslots}">
                <input type="button" value="${timeslot_name}"/>
    </c:forEach>
     
     <table border="1" cellpadding="10px" cellspacing="50px">
         
        <% for(int r = 0; r < 3; r+=1) { %> 
        <tr>      
            <% for(int i = 1; i < 11; i+=1) { %>
            <td width="50px" align="center"><%=i+r*3%></td>
            <% } %>
        </tr>
        <% } %>
        
      
     </table>
 </div>
 
 <div> 
     <td><input type="button" value="Выдать талон № <%=7%>"/></td>
 </div>
 
 <div> 
     <label>${current_patient_number}</label>
     <label>${current_patient_IO}</label>
 </div>

  

</body>
</html>
