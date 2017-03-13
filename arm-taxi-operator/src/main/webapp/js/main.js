// Поиск льготных рецептов
var seriesInput=$('#series')[0];
var numberInput=$('#number')[0];		
var snilsInput=$('#snils')[0];
var statusInput=$('#status')[0];
var patientFioInput=$('#patientFio')[0];

$(document).ajaxSend(function(event, request, settings) {
	$('#pleaseWaitDialog').modal({ keyboard: false });
});

$(document).ajaxComplete(function(event, request, settings) {
	$('#pleaseWaitDialog').modal('hide');
});

$(document).ajaxError(function(event, request, settings) {
	$('#pleaseWaitDialog').modal('hide');
});

function showModalError(error) {
    $('#modalShowError').modal({ keyboard: false });
    $('#textErrorMessage').text(error);
}
	
var currentProgress = 0;
var working = false
var _startProgressAnimation = function(start){
	working = start;
	$('.progress-bar').width(100/15*currentProgress + '%');
	
	if (currentProgress<=15 && working){
		setTimeout(function(){
			currentProgress++;
			_startProgressAnimation(working);
		},1000);
	} else {
		$('.progress-bar').width('100%');
	}
};
	
var _stopProgressAnimation = function(){
		working = false;
};
	
function showModalSuccess(message) {
    $('#modalShowSuccess').modal({ keyboard: false });
    $('#textSuccessMessage').text(message);
}
	
function clearStatus() {
	statusInput.value = "";
	patientFioInput.value = "";
}
 function checkRecipe(){
	$('#modalMessage').text("Пожалуйста, подождите, идёт поиск рецепта...");

	clearStatus();
	
	$.ajax({
		url : 'recipe/get',
		data: {
			series:seriesInput.value,
			number:numberInput.value,
			snils:snilsInput.value.replace(/[^\d]/g,"")
		}
	}).done(function (data) {
		if (data.status) {
			statusInput.value = data.status;
			patientFioInput.value = data.patientFio;
			//console.log("Рецепт не найден");
		}
		else {
			//console.log(data);
			statusInput.value = "Рецепт не найден."
			patientFioInput.value = ""; 
		}
		numberInput.focus();
	}).error(function () {
		statusInput.value = "Не удалось получить статус рецепта. Повторите попытку позднее.";
		patientFioInput.value = "";
	});
};

function saveTap(){
	$('#modalMessage').text("Пожалуйста, подождите, идёт сохранение талона...");
	
	$.ajax({
		url : 'ajax_verify',
		encoding: "UTF-8",
		data: $('#TapData').serialize(),
		method: 'GET'
	}).done(function (data) {
		$('#RequestResult').html( data.surname );
	}).error(function (e) {
		// stub
	});
};
		
$('#TapData').validator().on('submit', function (e) {
	if (e.isDefaultPrevented()) {
			// handle the invalid form...
	} else {
		//checkRecipe();
		saveTap();
		e.preventDefault();
	}
});