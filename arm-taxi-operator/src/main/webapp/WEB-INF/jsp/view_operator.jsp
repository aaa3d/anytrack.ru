<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="ru">
    <head>
        <title>Оператор</title>

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



    <p>Оператор</p>


    <c:url var="post_url"  value="/dictionary/save/operator/" />
    <form:form method="GET" commandName="operator" modelAttribute="operator" action="${post_url}" >
        <form:hidden path="Id"/>
        <table>
            <tr><td>ФИО:</td><td><form:input path="Fio"/></td></tr>
            <tr><td>Телефон:</td><td><form:input path="Phone"/></td></tr>
            <tr><td>Пароль:</td><td><form:input path="Password"/></td></tr>
        </table>
        <input type="submit" value="Сохранить"></td>
    </form:form>



    <label id="submit_result"></label>



    <script type="text/javascript">

        var form = $('#operator');
        form.submit(function () {

            $('#submit_result').html('Сохранение...');
            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: form.serialize(),
                success: function (data) {
                    var result = data;
                    $('#submit_result').html(result.resultDescription);

                }
            });

            return false;
        });


    </script>
</body>
</html>
