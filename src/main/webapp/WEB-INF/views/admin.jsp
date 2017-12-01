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

</script>
</head>
<body class = "container bg-fluid bg-warning">
<div class = "col-lg-1 col-sm-1"></div>
<div class = "col-lg-10 col-sm-10 bg-danger">
	<div class = "row" style = ""><center><h4>Administration</h4></center></div>
	<div class = "row" style = "margin:5px">
		<button id = "tab1" onclick = "ajaxHandler('1')" class = "btn btn-primary">SPEAKING</button>
		<button id = "tab2" onclick = "ajaxHandler('2')" class = "btn btn-primary">WRITING</button>
		<button id = "tab3" onclick = "ajaxHandler('3')" class = "btn btn-primary">VOCABULARY</button>
		<button id = "tab4" onclick = "ajaxHandler('4')" class = "btn btn-primary">CATEGORY</button>
	</div>
<div class = "row bg-info" style = "padding: 5px; margin:5px; min-height:300px">
	<div id = "mainZone">haha</div>
</div>
	
</div>
<div class = "col-lg-1 col-sm-1"></div>
</body>
</html>