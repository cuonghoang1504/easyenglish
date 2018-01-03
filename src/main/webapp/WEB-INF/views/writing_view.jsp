<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>WRITING</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

</head>
<body class = "container bg-fluid bg-success">
<div class = "col-lg-1 col-sm-1"><a title="Click to go back the main menu"
 href="#" onclick="home();return false;"><i>Menu</i></a></div>
	<h2><center>WRITING PRACTICE</center></h2>
	<div class = "row" style = "height: 10px"></div>
	<div class = "row">
	<div class = "col-sm-1"></div>
	<div class = "col-sm-10">
	<div class = "row bg-primary" style = "border: 1px; padding:10px">
	<b><i><u>QUESTION: </u></i></b> ${question.question}
	<div style = "float:right; margin-top:10px"><button class = "btn-warning" onClick = "nextQuestion('3')">NEXT</button></div>
	</div>
	</div>
	</div>
	
	<div class = "row" style = "margin-top: 10px">
	<div class = "col-sm-1"></div>
	<div class = "col-sm-10">
	<div class = "row bg-info" style = "border: 1px; padding:10px">
	<i>Useful Vocabulary: </i> ${question.usefulVocab}
	</div>
	</div>
	</div>
	
	<!-- This is the main textfield 
	 -->
	<div class = "row" style = "margin-top: 10px;">
	<div class = "col-sm-1"></div>
	<div class = "col-sm-10">
	<div class = "row bg-warning" style = "border: 1px; padding:10px">
	<b>ANSWER:</b>
	<textarea id = "answer" style = "width: 100%; height: 60%; margin-top: 5px; padding: 5px">${question.answer}</textarea>
	<input style = "visibility:hidden; height:0px; width:0px" type = "text" id = "questionId" value = "${question.questionId}">
	<textarea  style = "visibility:hidden; height:0px; width:0px" id = "oldAnswer">${question.answer}</textarea>
	</div>
	</div>
	</div>
</body>
</html>