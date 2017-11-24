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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  var isLoggedIn = "${loggedIn}";
  if(!isLoggedIn){
	 
  }
  	 // Show default view
  function showSpeaking(){
	  $('#mainDiv').html("sp");
	  //$('#mainDiv').load('/speaking_view.jsp');
  } 
  function showWriting(){
	  $('#mainDiv').load('/writing_view.jsp');
	  //document.getElementById("mainDiv").load("writing_view.jsp");
  }
  function showVocab(){
	  $('#mainDiv').load('/vocab_view.jsp');
	  //alert("Show vocab");
	  //document.getElementById("mainDiv").load("vocab_view.jsp");
  }
});
</script>

</head>
<body class = "container-fluid bg-success" style = "width:100%">
	<div class = "row" style = "height: 15%"></div>
	<div class = "row bg-warning" style = "height: 70%">
		<div class = "col-sm-2 bg-primary" style = "height:100%; border-right-width:5px; border-right-color:inherit">
			<table class = "table">
			<tr><td><button onclick = "showSpeaking()" class = "btn btn-success" style = "width:100%">Speaking</button></td></tr>
			<tr><td><button onclick = "showWriting()" class = "btn btn-success" style = "width:100%">Writing</button></td></tr>
			<tr><td><button onclick = "showVocab()" class = "btn btn-success" style = "width:100%">Voca</button></td></tr>
			</table>
		</div>
		<div id = "mainDiv" class = "col-sm-10" style = "height:100%; padding:10px;">
			<form class = "form" action = "">
				<div class="form-group">
    <label for="email">Question:</label>
    <textarea rows="5" class="form-control" id="question"></textarea>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
	<div class = "row" style = "height: 15%"></div>
</body>
</html>