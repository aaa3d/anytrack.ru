<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 

<html lang="ru">
<head>
    <title>Элемент справочника</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link href="<c:url value="/css/jquery-ui.min.css"		/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap.css"			/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap-theme.min.css"	/>" rel="stylesheet">
     <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />

    <script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"					/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui.min.js"						/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"						/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/inputmask/jquery.inputmask.bundle.js"	/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/validator.min.js"						/>" ></script>
	
</head>
<body>

 


    <div class="container-fluid">
                <p class="lead text-center"></p>
        <p class="lead text-center">Заказ</p>
    </div>
    
   
    
    <form:form method="GET" commandName="dictionary_element_command" modelAttribute="dictionary_element" action="/dictionary/save/${dictionaryElement.getEntityName()}/${dictionaryElement.getID()}">
       
        <table>
            <c:forEach var="field" items="${dictionary_element.getFields()}">
                <tr><td>${field.value}</td><td><form:input path="${field.key}"/></td>
                </tr> 
            </c:forEach>
        </table>
        <input type="submit" value="Сохранить"></td>
    </form:form>





	
    <script type="text/javascript">
        $(function () {
            $('#birthDateDiv').datetimepicker({
                locale: 'ru',
                keepOpen: false,
                format: 'DD.MM.YYYY'
            });
        });
    </script>
</body>
</html>
