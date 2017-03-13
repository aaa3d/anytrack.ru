<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
<head>
<title>Справочник ${dictionary.getTitle()}</title>


<link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-theme.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet" />



<script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
<script>
    
   
</script>

</head>
<body >

    
    <p class="noselect">
    
<%@include file="page_header.jsp" %>

    </p>

<div class="no-copy">
    <p>
            You can't copy me.
<table class="noselect"
    <thead>
        <tr>
            <td>Код</td>
            <c:forEach var="field" items="${dictionary.getFields()}">
                <td>${field.value}</td>
            </c:forEach>
        </tr>
    </thead> 
    <c:forEach var="row" items="${dictionary.getRows()}">
        <tr >
            <td><a href="<c:url value="/dictionary/open/${dictionary.getEntityName()}/${row.key}"/>">${row.key}</a></td>
            <c:forEach var="value" items="${row.value}">
                <td>${value}</td> 
            </c:forEach>
        </tr>
    </c:forEach>
</table>
    
You can't copy me.    
    
</p>
</div>
    
<div class="no-copy">
    <p>You can't copy me.</p>
</div>

<div class="no-copy">
    .
    <p>But you can accidently copy me (in WebKit/Blink, but not Gecko) by selecting the periods around me.</p>
    .
</div>

<div class="all-copy">
  <p>One click selects all this.</p>
</div>
    
    
    
</body>
</html>
