<%-- 
    Document   : people_list
    Created on : 21.02.2017, 17:14:58
    Author     : igor
--%>

<%@page import="ru.online76.anytrack_ru.Models.Models"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@include file="styles.jsp" %>

        <script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/datagrid-groupview.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/workpointList.js"/>" ></script>
        
        
        <style>
        .work_orders_table td{ height: 14px };    
        </style>
            

    </head>
    <body onload="onLoadPage()">
        <%@include file="main_menu.jspf" %>

        
        <a href="<c:url value="/Workpoint/New/${dictionaryModelName}"/>" >Новый элемент</a>
        

        
        <a href="<c:url value="/Workpoint/WorkpointList/"/>"  onclick ='mergeWorkpoints()'   >Объединить </a>
        
        <input type = "button" onclick ='ReloadGridData()' value="ReloadGridData "  ></input>
        
        <input type = "button" onclick ='SetWorker(1)' value="Назначить исполнителя"  ></input>
        
        
        
        <table id="work_orders_table" >

        </table>
        
        
        
        <div id="dialog_select_worker" class="easyui-dialog" style="width:425px;height:500px;padding:10px;" data-options="modal:true,closed:true,cache:false"></div>
        
        
      


    </body>
</html>
