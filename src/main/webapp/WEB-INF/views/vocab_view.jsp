<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>VOCABULARY</title>
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
<center><h2>VOCABULARY</h2></center>
<div class = "row bg-danger" style="padding:10px; margin: 15px">
<center><h3><b class = "text-primary">${vocab.vocab}</b></h3></center>
<div style = "float:right; margin-top:10px"><button class = "btn-info" onClick = "getContent('1')">NEXT</button></div>

</div>


<div class = "row bg-success" style = "margin: 15px;padding:10px; height: 20%">
<b><i><u class = "text-primary">Defination:</u></i></b><br>
${vocab.meaning}</div>

<div class = "row bg-info" style = "margin: 15px; padding:10px; height: 20%">
<b><i><u class = "text-primary">Example:</u></i></b><br>
${vocab.example}
</div>

<div class = "row bg-danger" style = "margin: 15px; padding:10px;height:20%">
<b><i><u class = "text-primary">Synonyms:</u></i></b><br>
${vocab.synonyms}
</div>

</div>
<div class = "col-lg-1 col-sm-1"></div>	
</body>
</body>
</html>