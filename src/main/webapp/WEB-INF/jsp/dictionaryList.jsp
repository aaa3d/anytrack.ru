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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
        
        
        <a href="<c:url value="/Dictionary/New/${dictionaryModelName}"/>" >Новый элемент</a>
        
        
        
        <table class="easyui-datagrid" style="width:auto;height:auto;border:1px solid #ccc;" 
               data-options="fitColumns:true,singleSelect:true,  showFooter: true">
            <thead>
                <tr>
                    <c:forEach var="field" items="${dictionaryListFields}">
                    <th data-options="field:'${field.name}',width:200,fixed:true">${field.caption}</th>
                     </c:forEach>
                    <th data-options="field:'Action',width:100,fixed:true">Действие</th>
                </tr>
            </thead>
           
            
            
               
                    <%
                        
                        ArrayList rows = (ArrayList)request.getAttribute("dictionaryList"); 
                        ArrayList<Models.FieldDesc> dictionaryListFields = (ArrayList<Models.FieldDesc>)request.getAttribute("dictionaryListFields"); 
                        String modelName = (String)request.getAttribute("dictionaryModelName");
                        Class model = Class.forName( "ru.online76.anytrack_ru.Models." + modelName );
                        //out.println(dictionaryList);
                        
                            for(Object row: rows){
                        out.write("<tr>");
                        
                        for(Models.FieldDesc field: dictionaryListFields){
                            
                            
                            Method classMethod = model.getMethod( "get"+field.getName() );
                            out.write("<td>");
                            String value = String.valueOf(classMethod.invoke(row));
                            //if (value=="null")
//                                value = "";
                            
                            
                            out.print(value);
                            out.write("</td>");
                        }
                        out.write("<td>");
                        Method classMethod = model.getMethod( "getId" );
                        out.write("<a href='"+request.getContextPath()+"/Dictionary/Edit/"+modelName+"/");
                        out.print(String.valueOf(classMethod.invoke(row)));
                        out.write("'>Редактировать</a>");
                        
                        out.write("</td>");
                        out.println("</tr>");
                        }
                    %> 
                   

                   
            
            


        </table>


    </body>
</html>
