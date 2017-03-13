<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 

<html lang="ru">
<head>
    <title>Талон амбулаторного пациента</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link href="<c:url value="/css/jquery-ui.min.css"		/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap.css"			/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap-theme.min.css"	/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"				/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />

    <script type="text/javascript" src="<c:url value="/js/jquery-1.10.0.min.js"					/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui.min.js"						/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"						/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/inputmask/jquery.inputmask.bundle.js"	/>" ></script>
	<script type="text/javascript" src="<c:url value="/js/validator.min.js"						/>" ></script>
	
    <script type="text/javascript" src="<c:url value="/js/moment.js"							/>" ></script>
    <script type="text/javascript" src="<c:url value="/js/transition.js"						/>" ></script>
    <script type="text/javascript" src="<c:url value="/js/collapse.js"							/>" ></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap-datetimepicker.min.js"		/>" ></script>
    
</head>
<body>

 
<%@include file="page_header.jsp" %>

    <div class="container-fluid">
                <p class="lead text-center"></p>
        <p class="lead text-center">ТАЛОН АМБУЛАТОРНОГО ПАЦИЕНТА</p>
    </div>
    

                            

    <div class="row" id="main_form">
        <div class="container">

            <form class="form-horizontal" data-toggle="validator" id="TapData">
                            
                            <fieldset> 
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="NAK">Номер амбулаторной карты</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="NAK"
                                                        name="NAK"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Номер амбулаторной карты"
                                                        maxlength="3"
                                                        minlength="1"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div> 
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="VU">Врачебный участок</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="VU"
                                                        name="VU"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Врачебный участок"
                                                        maxlength="2"
                                                        minlength="1"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-7 control-label" for="KKL">Код категории льготы</label>
                                            <div class="col-sm-5">
                                                <input required
                                                        id="KKL"
                                                        name="KKL"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Код категории льготы"
                                                        maxlength="3"
                                                        minlength="3"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            
                            <fieldset>
                            <!-- Общие сведения -->
                                <legend>Пациент</legend>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="Surname">Фамилия</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="Surname"
                                                        name="Surname"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Фамилия"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>  
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="Name">Имя</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="Name"
                                                        name="Name"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Имя"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="SecondName">Отчество</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="SecondName"
                                                        name="SecondName"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Отчество"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group date col-sm-12" id="birthDateDiv">
                                                <label class="col-sm-3 control-label" for="birthDate">Дата рождения</label>
                                                <div class="col-sm-9">
                                                    <div class='input-group date' id='birthDate'>
                                                        <input  required
                                                                id="birthDate"
                                                                name="birthDate"
                                                                class="form-control"
                                                                type="text" 
                                                                />
                                                        <span class="input-group-addon">
                                                            <span class="glyphicon glyphicon-calendar"></span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="Sex">Пол</label>
                                            <div class="col-sm-6">
                                                
                                                
                                                <select required
                                                        id="Sex"
                                                        name="Sex"
                                                        class="form-control"
                                                        >
                                                     <c:forEach items="${dictionary_sex}" var="item">
                                                       <option>${item}</option>
                                                    </c:forEach>   
                                                </select>
                                                
                                                


                                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="Snils">СНИЛС</label>
                                            <div class="col-sm-6">
                                                <input required
                                                        id="Snils"
                                                        name="Snils"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="СНИЛС"
                                                        pattern="\d\d\d\d\d\d\d\d\d\d\d"
                                                        lenght="11"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            
                            <!-- Документ -->
                            <fieldset>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="Document">Документ</label>
                                            <div class="col-sm-9">
                                                <select required
                                                        id="Document"
                                                        name="Document"
                                                        class="form-control"
                                                        >
                                                    <option value="1">Паспорт РФ</option>
                                                    <option value="2">Прочее</option>
                                                </select>
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="DocSeries">Серия</label>
                                            <div class="col-sm-6">
                                                <input required
                                                        id="DocSeries"
                                                        name="DocSeries"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Серия"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="DocNumber">Номер</label>
                                            <div class="col-sm-6">
                                                <input required
                                                        id="DocNumber"
                                                        name="DocNumber"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Серия"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            
                            <!-- СМО -->
                            <fieldset>
                                <legend>Страховой полис</legend>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="SMO">СМО</label>
                                            <div class="col-sm-9">
                                                <select required
                                                        id="SMO"
                                                        name="SMO"
                                                        class="form-control"
                                                        >
                                                    <option value="1">Ресо-Мед</option>
                                                    <option value="2">Согаз мед</option>
                                                    <option value="2">Росгосстрах мед</option>
                                                </select>
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="SRegion">Регион страхования</label>
                                            <div class="col-sm-9">
                                                <select required
                                                        id="SRegion"
                                                        name="SRegion"
                                                        class="form-control"
                                                        >
                                                    <option value="1">77 Московская обл.</option>
                                                    <option value="2">76 Ярославская обл.</option>
                                                    <option value="2">44 Костромская обл.</option>
                                                </select>
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="SMOSeries">Серия</label>
                                            <div class="col-sm-6">
                                                <input required
                                                        id="SMOSeries"
                                                        name="SMOSeries"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Серия"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-6 control-label" for="SMONumber">Номер</label>
                                            <div class="col-sm-6">
                                                <input required
                                                        id="SMONumber"
                                                        name="SMONumber"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Серия"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            
                            <!-- Место регистрации -->
                            <fieldset>
                                <legend>Место регистрации</legend>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegCountry">Страна</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegCountry"
                                                        name="RegCountry"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Страна"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegRepublic">Республика, край, область</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegRepublic"
                                                        name="RegRepublic"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Республика, край, область"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegArea">Район</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegArea"
                                                        name="RegArea"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Район"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegCity">Город</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegCity"
                                                        name="RegCity"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Город"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegCommunity">Населенный пункт</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegCommunity"
                                                        name="RegCommunity"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Населенный пункт"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegStreet">Улица</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegStreet"
                                                        name="RegStreet"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Улица"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegHouse">Дом</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegHouse"
                                                        name="RegHouse"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Дом"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegApartment">Квартира</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegApartment"
                                                        name="RegApartment"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Квартира"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="RegPhone">Контактный телефон</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="RegPhone"
                                                        name="RegPhone"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Контактный телефон"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        
                                    </div>
                                </div>
                            </fieldset>
                            
                            <!-- Место проживания -->
                            <fieldset>
                                <legend>Место проживания</legend>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivCountry">Страна</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivCountry"
                                                        name="LivCountry"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Страна"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivRepublic">Республика, край, область</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivRepublic"
                                                        name="LivRepublic"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Республика, край, область"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivArea">Район</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivArea"
                                                        name="LivArea"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Район"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivCity">Город</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivCity"
                                                        name="LivCity"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Город"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivCommunity">Населенный пункт</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivCommunity"
                                                        name="LivCommunity"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Населенный пункт"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivStreet">Улица</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivStreet"
                                                        name="LivStreet"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Улица"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivHouse">Дом</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivHouse"
                                                        name="LivHouse"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Дом"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="LivApartment">Квартира</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="LivApartment"
                                                        name="LivApartment"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Квартира"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        
                                    </div>
                                </div>
                            </fieldset>
                            
                            <!-- Дополнительные сведения -->
                            <fieldset>
                                <legend>Дополнительные сведения</legend>
                                <div class="container">
                                    <div class="col-sm-8">
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="Location">Местность</label>
                                            <div class="col-sm-9">
                                                <input required
                                                        id="Location"
                                                        name="Location"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="Местность"
                                                        value=""
                                                        >
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group has-feedback">
                                            <label class="col-sm-3 control-label" for="SocCategory">Социальная категория</label>
                                            <div class="col-sm-9">
                                                <select required
                                                        id="SocCategory"
                                                        name="SocCategory"
                                                        class="form-control"
                                                        >
                                                    <c:forEach items="${dictionary_work_type}" var="item"  varStatus="loop">
                                                       <option value="${loop.count}">${loop.count} ${item}</option>
                                                    </c:forEach>       
                                                </select>
                                                <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            
                            <div class="container">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                                <div class="col-sm-12 text-right">
                                                        <button type="submit" class="btn btn-default" id="saveCard">Сохранить</button>
                                                </div>
                                    </div>
                                </div>
                            </div>

            </form>
        </div>
    </div>
    
    <div class="container-fluid">
        <p class="lead text-left" id="RequestResult">${request}</p>
    </div>

    <!-- Modal -->
    <div class="modal" id="pleaseWaitDialog" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="modalMessage">Поиск...</h4>
                </div>
                <div class="modal-body">
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped active"
                            role="progressbar" aria-valuenow="100" aria-valuemin="0"
                            aria-valuemax="100" style="width: 100%"></div>
                    </div>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

	
        
    <script type="text/javascript" src="<c:url value="/js/main.js"								/>" ></script>
        
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
