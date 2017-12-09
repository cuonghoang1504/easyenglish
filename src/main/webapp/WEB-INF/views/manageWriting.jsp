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
	 height:200px;              // <-- Select the height of the table
	 display: -moz-groupbox;    // Firefox Bad Effect
	}
	tbody{
	  overflow-y: scroll;      
	  height: 180px;            //  <-- Select the height of the body
	  width: 100%;
	  position: absolute;
	}
</style>
</head>
<body>
<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Question: </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "sQuestion" style = "height: 100px" class = "form-control" placeholder = "Enter the question to add..."></textarea>
</div>
</div>

<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Hint(s): </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "qHint" style = "height: 100px" class = "form-control" placeholder = "Add some hint here..."></textarea>
</div>
</div>		

<div class = "row" style = "margin-top: 10px">
<div class = "col-lg-3 col-sm-3"><label class = "text-danger">Module:</label></div>
<div class = "col-lg-9 col-sm-9"><form class = "form-group">
	<label class = "radio-inline">
		<input type = "radio" name = "module" value = "1" checked>General
	</label>
	<label class = "radio-inline">
		<input type = "radio" name = "module" value = "2"> Academic
	</label>
</form>
</div>
</div>

<div class = "row" style = "margin-top: 10px">
<div class = "col-lg-3 col-sm-3"><label class = "text-danger">Part:</label></div>
<div class = "col-lg-9 col-sm-9"><form class = "form-group">
	<label class = "radio-inline">
		<input type = "radio" name = "part" value = "1" checked>Part 1
	</label>
	<label class = "radio-inline">
		<input type = "radio" name = "part" value = "2"> Part 2
	</label>
</form>
</div>
</div>

<div class = "row" style = "margin-top: 10px">
<div class = "col-lg-3 col-sm-3"><label class = "text-danger">Category(ies):</label></div>
<div class = "col-lg-9 col-sm-9"><table class = "table">
<c:forEach var="cate" items="${categories}">
            <tr>
            <td><input type = "checkbox" name = "cbxCateName[]" value = "${cate.categoryName}"></td>
           <td>${cate.categoryName}</td>
            </tr>
        </c:forEach>
</table>
<button class = "btn btn-warning" style = "float:right" onclick = "addQuestion('2')">Add question</button>
</div>
</div>
</body>
</html>