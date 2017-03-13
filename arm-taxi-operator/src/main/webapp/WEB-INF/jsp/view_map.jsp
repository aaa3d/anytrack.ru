<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
<head>
<title>Карта</title>

<%@include file="styles.jsp" %>
<%@include file="frameworks_scripts.jsp" %>

<script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/view_map.js"/>" ></script>
<link rel="stylesheet" href="https://openlayers.org/en/v3.20.1/css/ol.css" type="text/css">
<!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
<script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
<script src="https://openlayers.org/en/v3.20.1/build/ol.js"></script>




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



<div id="map"
</div>
  

</body>
</html>
