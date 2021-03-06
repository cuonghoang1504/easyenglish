<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>SPEAKING</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body class = "container bg-warning">
<div class = "col-lg-1 col-sm-1"><a title="Click to go back the main menu"
 href="#" onclick="home();return false;"><i>Menu</i></a></div>
<div class = "col-lg-10 col-sm-10 bg-warning" style = "width:100%">
<center><h2>SPEAKING</h2></center>
<div class = "row bg-danger" style="padding:10px"><b><i><u>QUESTION:</u></i></b> <div id = "question">${question.question}</div>
<div style = "float:right; margin-top:10px"><button class = "btn-info" onClick = "nextQuestion('2')">NEXT</button></div>
</div>

<div class = "row bg-success" style = "margin-top: 5px;padding:10px"><i><u>Useful vocabulary:</u></i> ${question.usefulVocab} </div>

<div class = "row bg-primary" style = "margin-top: 5px; padding:10px;"><i><u>ANSWER:</u></i>

<br>
<div class = "form-group">
<textarea id = "answer" style = "min-height:250px" class="form-control" placeholder ="Type your answer here or take some note...">${question.answer}</textarea>
<input style = "visibility:hidden; height:0px; width:0px" type = "text" id = "questionId" value = "${question.questionId}">
<textarea  style = "visibility:hidden; height:0px; width:0px" id = "oldAnswer">${question.answer}</textarea>	
</div>
</div>

</div>
<div class = "col-lg-1 col-sm-1"></div>	
</body>
</html>