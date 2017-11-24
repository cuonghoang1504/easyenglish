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
</head>
<body>
<div class = "container-fluid bg-primary" style = height:100%>
<div class = "row">
<div class = "col-sm-4"></div>
<div class = "col-sm-4"><div class = "h4 text-center">Welcome to management site!</div></div>
<div class = "col-sm-4"></div>
</div>
<div class = "row bg-info" style = height:90%>
<center style = "padding-top: 20%; padding-left:0%"> 
<form:form action = "user/login" method = "POST">
<div class = "form-group form-inline">
<label>Username: </label>
<input type = "text" value = "${username}" name = "username" id = "username" class = "form-control">
</div>
<div class = "form-group form-inline">
<label>Password: </label>
<input type = "password" name = "password" id = "password" class = "form-control">
<button type = "submit">Login</button>
</div>

</form:form>
</center>
<center class = "text-warning">${errorMessage}</center>
</div>	
</div>
</body>
</html>