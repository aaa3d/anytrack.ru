<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 

<html lang="ru">
<head>
    <title>Заказ</title>
    
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
    
    ТУТ накидать полей заказа
    
    
    пока только осноные 
    
    <form:form method="GET" commandName="order-entity" modelAttribute="order-entity" action="/arm-taxi-operator/order/save">
        <form:hidden path="ID"/>
        <table>
            <tr>
                <td>Телефон:</td>
                <td><form:input path="Phone"/></td>
            </tr>
            <tr>
                <td>Откуда: Улица/Дом/кв:</td>
                <td><form:input path="AddrFrom"/></td>
                <td><form:input path="HouseFrom" /></td>
                <td><form:input path="FlatFrom"/></td>
            </tr>
            <tr>
                <td>Куда: Улица/Дом:</td>
                <td><form:input path="AddrTo"/></td>
                <td><form:input path="HouseTo"/></td>
            </tr>
            
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
