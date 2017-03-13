<%-- 
    Document   : edit_people
    Created on : 22.02.2017, 13:35:38
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="styles.jsp" %>
        
        <script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>
    </head>
    <body>
        <%@include file="main_menu.jspf" %>
        <h1>Редактирование адреса:  ${dictionary_edited_object.toString()}</h1>
        
        
        <c:url var="form_action_url"  value='/Dictionary/Save/${dictionaryModelName}' />
        
        
        
        <form:form id='people_edit_form' method='POST'  modelAttribute='dictionary_edited_object' action="${form_action_url}" >
            <table>
                <tr><td>Название:</td><td><form:input path="AddressName" class="easyui-textbox" data-options="" style="width:250px" /></td></tr> 
                <tr><td>Регион:</td><td><form:input path="Region" class="easyui-textbox" data-options="" style="width:250px"/></td></tr> 
                <tr><td>Город/поселок:</td><td><form:input path="CityVillage"  class="easyui-textbox" data-options="" style="width:250px"/> </td></tr> 
                <tr><td>Улица:</td><td><form:input path="Street"  class="easyui-textbox" data-options="" style="width:250px"/> </td></tr> 
                <tr><td>Дом:</td><td><form:input path="House"  class="easyui-textbox" data-options="" style="width:250px"/> </td></tr> 
                <tr><td>LAT:</td><td><form:input path="Coordinate.Lat"  class="easyui-textbox" data-options="" style="width:250px"/> </td></tr> 
                <tr><td>LON:</td><td><form:input path="Coordinate.Lon"  class="easyui-textbox" data-options="" style="width:250px"/> </td></tr> 

                
                <tr><td><input type="submit"  value="Сохранить"></td></td><td></tr> 
            </table>
        </form:form>

    </body>
</html>
