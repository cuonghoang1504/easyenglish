<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>Management site</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
$(document).ready(function(){
  ajaxHandler(1);
});
function addQuestion(type){
	var qCate = "";
	$("[name='cbxCateName[]']:checked").each(function () {
		qCate = qCate + "#" + $(this).val();
	});
	if(qCate == ""){
		alert("Please choose at least one category, if no category appears, add one first!");
		return;
	}
	var part = document.querySelector('input[name="part"]:checked').value;
	if(type == '2')
		var module = document.querySelector('input[name="module"]:checked').value;
	var sQuestion = $('#sQuestion').val();
	var sHint = $('#sHint').val();
	if(sQuestion == ""){
		alert("Please input question before adding!");
		return;
	}
	 
	var url;
	if(type == '1')
		url = document.location + "/addSpeakingQuestion";
	else
		url = document.location + "/addWritingQuestion";
	$.ajax({
		method: 'POST',
		url : url,
		dataType : "html",
		data : {
			sQuestion : sQuestion,
			sHint	: sHint,
			qCate : qCate,
			part : part,
			module : module
		},
		success : function(responseText) {
			//document.getElementById("mainZone").innerHTML = responseText;
			ajaxHandler(type);
		},
        error: function(e) 
        {
            alert('Error: ' + e);
        }
	});
	}
function addCategory(){
	var cateName = document.getElementById("cateName").value;
	if(cateName.trim() == ""){
			alert("Please enter category name!");
			return;
		}
	var url = document.location + "/addCategory";
	$.ajax({
		method: 'POST',
		url : url,
		dataType : "html",
		data : {
			cateName : cateName
		},
		success : function(responseText) {
			//document.getElementById("mainZone").innerHTML = responseText;
			ajaxHandler(4);
		},
        error: function(e) 
        {
            alert('Error: ' + e);
        }
	});
	
}
function ajaxHandler(tab){
	var i = 0;
	for(i = 1 ; i < 5; i ++){
		var index = 'tab' + i;
		document.getElementById(index).disabled = false;			
	}
	document.getElementById('tab' + tab).disabled = true;	
	
	var url = document.location + "/ajax";
	$.ajax({
		method: 'POST',
		url : url,
		dataType : "html",
		data : {
			tab : tab
		},
		success : function(responseText) {
			document.getElementById("mainZone").innerHTML = responseText;
		},
        error: function(e) 
        {
            alert('Error: ' + e);
        }
	});
}
function addVocabulary(){
	alert("Add a vocab");
	var vocab = document.getElementById("vocab").value;
	var vocabMean = document.getElementById("vocabMean").value;
	var vocabExample = document.getElementById("vocabExample").value;
	var vocabSynonyms = document.getElementById("vocabSynonyms").value;
	if(vocab.trim() == ""){
			alert("Please enter new vocabulary!");
			return;
		}
	if(vocabMean.trim() == ""){
		alert("Vocabulary's meaning should not be empty!");
		return;
	}
	var vocabTypes = "";
	$("[name='type[]']:checked").each(function () {
		vocabTypes = vocabTypes + "" + $(this).val();
	});
	if(vocabTypes == ""){
		alert("Please select word type to continue...!");
		return;
	}
	var qCate = "";
	$("[name='cbxCateName[]']:checked").each(function () {
		qCate = qCate + "#" + $(this).val();
	});
	if(qCate == ""){
		alert("Please choose at least one category, if no category appears, add one first!");
		return;
	}
	var url = document.location + "/addVocabulary";
	alert(url);
	$.ajax({
		type: 'POST',
		url : url,
		dataType : "html",
		data : {
			qCate : qCate,
			vocab : vocab,
			vocabMean: vocabMean,
			vocabExample: vocabExample,
			vocabSynonyms : vocabSynonyms,
			vocabTypes : vocabTypes
		},
		success : function(responseText) {
			//document.getElementById("mainZone").innerHTML = responseText;
			ajaxHandler(3);
		},
        error: function(e) 
        {
            //alert('Error: ' + e);
        }
	});
	}
</script>
</head>
<body class = "container bg-fluid bg-warning">
<div class = "col-lg-1 col-sm-1"></div>
<div class = "col-lg-10 col-sm-10 bg-danger">
	<div class = "row" style = ""><center><h4>Administration</h4></center></div>
	<div class = "row" style = "margin:5px">
		<button style = "width: 110px" id = "tab1" onclick = "ajaxHandler('1')" class = "btn btn-primary">SPEAKING</button>
		<button style = "width: 110px" id = "tab2" onclick = "ajaxHandler('2')" class = "btn btn-primary">WRITING</button>
		<button style = "width: 110px" id = "tab3" onclick = "ajaxHandler('3')" class = "btn btn-primary">VOCABULARY</button>
		<button style = "width: 110px" id = "tab4" onclick = "ajaxHandler('4')" class = "btn btn-primary">CATEGORY</button>
	</div>
<div class = "row bg-info" style = "padding: 5px; margin:5px; min-height:300px">
	<div id = "mainZone">haha</div>
</div>
	
</div>
<div class = "col-lg-1 col-sm-1"></div>
</body>
</html>