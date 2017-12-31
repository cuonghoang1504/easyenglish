<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>Managing Vocabularies</title>
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
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Word or phrase: </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "vocab" style = "height: 50px" class = "form-control" placeholder = "Enter new word or phrases..."></textarea>
</div>
</div>

<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Type: </label></div>
<div class = "col-lg-9 col-sm-9">
<form class = "form-group">
<input type = "checkbox" class = "form-input" name = "type[]" value = "1"> <label class = "label text-warning">Verb</label>
<input type = "checkbox" class = "form-input" name = "type[]" value = "2"> <label class = "label text-warning">Noun</label>
<input type = "checkbox" class = "form-input" name = "type[]" value = "3"> <label class = "label text-warning">Adjective</label>
<input type = "checkbox" class = "form-input" name = "type[]" value = "4"> <label class = "label text-waring">Adverb</label>
</form>
</div>
</div>

<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Meaning(s): </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "vocabMean" style = "height: 50px" class = "form-control" placeholder = "Enter vocabulary meaning..."></textarea>
</div>
</div>

<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Example(s): </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "vocabExample" style = "height: 75px" class = "form-control" placeholder = "Give some examples of usages..."></textarea>
</div>
</div>	

<div class = "row">
<div class = "col-lg-3 col-sm-3"><label class= "text-danger">Synonym(s): </label></div>
<div class = "col-lg-9 col-sm-9">
<textarea id = "vocabSynonyms" style = "height: 50px" class = "form-control" placeholder = "Synonyms of given word"></textarea>
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
<button class = "btn btn-warning" style = "float:right" onclick = "addVocabulary()">Add Vocabulary</button>
</div>
</div>
</body>
</html>