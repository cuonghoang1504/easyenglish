<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey Admin</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  h2 {
  	text-align: center;
  	margin: 10px;
  }
  .question {
  	width: 100%;
  	font-weight: bold;
  }
  .answer {
  	padding: 10px;
  }
  .survey {
  	margin: auto;
  	padding: 10px;
  	width: 100%;
  }
  .answers {
  	margin: auto;
  }
  .main-container {
  	width:100%;
  	margin:auto;
  }
  </style>
  <script>
  $(document).ready(function(){
  	var surveys ='<c:out value="${answers}" escapeXml="false"/>';
  	var surveysObj = JSON.parse(surveys);
  	surveysObj.forEach(function(survey) {
  		
  		$("#answers").append("<div class = 'survey'>");
  		$("#answers").append("----------------------------");
  		survey.forEach(function(answer) {
  			$("#answers").append("<div class = 'question'>"
  					+ answer.question
  					+ "</div>");
  			$("#answers").append("<div class = 'answer'>"
  					+ answer.answer
  					+ "</div>");
  			
  			});
  		$("#answers").append("----------------------------");
  		$("#answers").append("</div>");
  	});
  });
  </script>
</head>
<body>
<div class = "bg-warning container-fluid main-container">
	
	<h2>SURVEY ADMIN</h2>
	
	<div class = "row answers" id = "answers">
	</div>
</div>
</body>
</html>