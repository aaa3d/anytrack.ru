<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
<head>
<title>Системные справочники</title>


<link href="<c:url value="/css/jquery-ui.min.css"/> rel="stylesheet">
<link href="<c:url value="/css/bootstrap.css"/> rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css"/> rel="stylesheet">
<link href="<c:url value="/css/style.css"/> rel="stylesheet">
<link href="<c:url value="/css/bootstrap-datetimepicker.min.css"/> rel="stylesheet" />



<script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
<script>
    
   
</script>

</head>
<body >

<%@include file="page_header.jsp" %>
<a href="<c:url value="/dictionary/list/operator"/>">операторы</a><br>



</body>
</html>
