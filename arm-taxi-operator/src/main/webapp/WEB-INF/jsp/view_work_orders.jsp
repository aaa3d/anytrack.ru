<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
<head>
<title>Общий журнал документов</title>

<%@include file="styles.jsp" %>
<%@include file="frameworks_scripts.jsp" %>

<script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/view_work_orders.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/dialog_edit_order.js"/>" ></script>




<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
fieldset {
	margin-top: 20px;
}

html, body {
    height: 100%;
  }


.divTable {
    height: 80%;
    background-color: #f5f5f5; 
    overflow:auto;
    
    border: 1px solid #000000; /* размер и цвет границы блока */
}


</style>


</head>
<body onload="onLoadPage()">

<%@include file="page_header.jsp" %>
      
<input type="button" onclick="refresh()" value="Автообновление"><br> 
___________________________________________________________________



<div class="easyui-layout" style="width:95%psx;height:80%;">
        <div data-options="region:'north'" style="height:50px"></div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'east',split:true" title="Машины" style="width:200px;"></div>
        <div data-options="region:'center',title:'Заказы',iconCls:'icon-ok'">
            <table id="work_orders_table" >

            </table>
        </div>
</div>


<div id="dialog_edit_order" class="easyui-dialog" style="width:425px;height:500px;padding:10px;" data-options="modal:true,closed:true,cache:false"></div>

  

</body>
</html>
