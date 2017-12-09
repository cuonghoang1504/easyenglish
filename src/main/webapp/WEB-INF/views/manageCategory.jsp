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
<script type="text/javascript">
</script>
<style>
tr {
	width: 100%;
	display: inline-table;
	table-layout: fixed;
	}

	table{
	 height:400px;              // <-- Select the height of the table
	 display: -moz-groupbox;    // Firefox Bad Effect
	}
	tbody{
	  overflow-y: scroll;      
	  height: 300px;            //  <-- Select the height of the body
	  width: 100%;
	  position: absolute;
	}
</style>

</head>
<body>
<div class = "row">
<div class = "col-lg-4 col-sm-4">
<div class = "form-group">
	<u><i class = "text-danger">Category Name:</i></u>
	<textarea class="form-control" placeholder ="Type your answer here or take some note..." style = "margin-top:10px;margin-bottom:10px; height: 100px; width: 90%" id = "cateName"></textarea>
	<input type = "button" onclick = "addCategory()" class = "btn-warning" value = "Add Category">
</div>
</div>
<div class = "col-lg-8 col-sm-8">
<table class="table table-condensed" style = "max-height:50%">
    <thead>
      <tr>
        <th>Name</th>
        <th>No. Questions</th>
        <th>No. Vocabulary</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="cate" items="${categories}">
            <tr>
           <td>${cate.categoryName}</td>
           <td>${cate.numOfQuestions}</td>
           <td>${cate.numOfVocab}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
</div>


</div>	
</body>
</html>