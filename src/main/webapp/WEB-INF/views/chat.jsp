<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>English made easy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
</head>
<style>
.main-container{
	position: absolute;
  	left: 50%;
  	top: 50%;
  	-webkit-transform: translate(-50%, -50%);
  	transform: translate(-50%, -50%);
  	/* border-radius */
 	border-radius: 2px;
	/* box-shadow */
 	box-shadow: rgba(0,0,0,0.8) 0 0 10px;
 	border-collapse: collapse;
}
*{
	box-sizing: border-box;
}
.header{
	height: 50px;
	text-align: center;
	font-size: medium;
	padding-top: 15px;
	border-bottom: 1px solid #c0d680;
}
.chat-container{
	height: 450px;
}
.chat-session{
	height:100%;
}
.contact-list{
	height:100%;
}
.chat-windows{
	height: 85%;
}
.chat-input{
	height: 15%;
}
</style>
<body>
<div class = "col-sm-8 bg-warning main-container">
	<div class = "row">
		<div class = "col-sm-12 header"> header</div>
	</div>
	
	<div class = "row chat-container">
		<div class = "col-sm-4 bg-danger contact-list">contact list</div>
		<div class = "col-sm-8 bg-primary chat-session">
			<div class = "row bg-success chat-windows">chat windows</div>
			<div class = "row bg-default chat-input">input box</div>
		</div>	
	</div>
</div>
</body>
</html>