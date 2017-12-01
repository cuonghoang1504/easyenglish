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
function getVocab(){
	location.href = document.location + "vocab";
}

function getSpeaking(){
	location.href = document.location + "speaking";
}

function getWriting(){
	location.href = document.location + "writing";
}
</script>
</head>
<body class = "container-fluid bg-success" >
<div class = "row" style = "height: 30%">
</div>
	<div class = "col-sm-4"></div>
  	<div class = "col-sm-4">
<div class="row" style = "height: 40%; width: 100%">
  	
	<button onclick="getVocab();" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">VOCABULARY</button> 
	<button onclick="getSpeaking();" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">SPEAKING</button>
	<button onclick="getWriting();" class = "row btn-primary" style = "width: 100%; height: 25%; margin: 5px">WRITING</button>  
	
  </div>
  </div>
    <div class = "col-sm-4"></div>
</div>


</body>
</html>