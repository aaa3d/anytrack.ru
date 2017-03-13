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
        <title>Выбор из справочника</title>

        <%@include file="styles.jsp" %>

        <script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/datagrid-groupview.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/dialogSelectDictionaryElement.js"/>" ></script>





    </head>
    <body onload="onLoadPage()">



        <c:url var="data_url"  value='/Dictionary/ListForSelect/${dictionaryModelName}' />        



        <div class="easyui-panel" style="width:auto;height:100%;">
            <div class="easyui-layout" data-options="fit:true">


                <div data-options="region:'center'" >
                    <table id="dictionary_list_table"   class="easyui-datagrid" style="width:auto;height:100%"
                           data-options="singleSelect:true,url:'${data_url}',method:'get'" >


                        <thead>
                            <tr>
                                <th data-options="field:'id',width:80">ID</th>
                                <th data-options="field:'StringDescr'">Название</th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div data-options="region:'south'" style="height:30px;" >
                    <input type="button" id ="form_OK_button"  value="OK">
                </div>
            </div>
        </div>







    </body>
</html>
