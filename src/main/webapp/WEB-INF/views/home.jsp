<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>English made easy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
var user_id = 1;

function updateAnswer(user_id, question_id, answer, index){
	//alert("Updating answer of user: " + user_id + " question: " + question_id + ". Answer: " + answer)
	var url = document.location + "updateAnswer";
	//alert(url);
	$.ajax({
		type: 'POST',
		url : url,
		data : {
			index : index,
			user_id : user_id,
			answer : answer,
			question_id : question_id
		},
		success : function(responseText) {
			//alert("Answer updated!");
		},
        error: function(e) 
        {
            //alert('Error: ' + e);
        }
	});
}

function editAnswer(){
	alert("Edit answer");
}
function saveAnswer(){
	alert("Save answer");
}
function nextQuestion(index){
	var oldAnswer = document.getElementById("oldAnswer").value;;
	var answer = document.getElementById("answer").value;
	var question_id = document.getElementById("questionId").value;
	if(answer !== oldAnswer){
		var text;
		if(oldAnswer == "")
			text = "Do you want to save your answer?";
		else
			text = "Answer modified, do you want to save these changes?";
		
		var r = confirm(text);
		if(r == true){
			updateAnswer(user_id, question_id, answer, index);
		}
	}
	//getContent(index);
}

function getContent(index){
	var url = document.location + "/mainContant";
	$.ajax({
		method: 'POST',
		url : url,
		dataType : "html",
		data : {
			index : index,
			user_id : user_id
		},
		success : function(responseText) {
			if(index !== "1"){
				//alert(responseText);
				//question_id = document.getElementById("questionId").text;
				//var oldAnswer = document.getElementById("oldAnswer").text;
				//alert(question_id);
			}
			document.getElementById("main").innerHTML = responseText;
		},
        error: function(e) 
        {
            alert('Error: ' + e);
        }
	});
}
function home(){
	//alert("Back home");
	window.location.href = window.location;
}
</script>
</head>
<body class = "container-fluid bg-success">
<div id = "main">
<div class = "row" style = "height: 30%">
</div>
	<div class = "col-sm-4"></div>
  	<div class = "col-sm-4">
<div class="row" style = "height: 40%; width: 100%">
  	
	<button onclick="getContent('1');" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">VOCABULARY</button> 
	<button onclick="getContent('2');" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">SPEAKING</button>
	<button onclick="getContent('3');" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">WRITING</button>  
	
  </div>
  </div>
 
</div>

</body>
</html>