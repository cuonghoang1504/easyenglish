<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey creater</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  *{
  	box-sizing: border-box;
  }
  .main-container{
  	padding: 10px;
  	width: 90%;
 	margin:auto;
 	margin-top: 20px;
  	font-size: 18px;
  	/* border-radius */
 	border-radius: 2px;
	/* box-shadow */
 	box-shadow: rgba(0,0,0,0.8) 0 0 10px;
 	border-collapse: collapse;
  }
  .question-session{
  	margin: auto;
  	width: 90%;
  	min-height: 15%;
  	border-radius: 10px;
  	box-shadow: 1px 2px #888888;
  	padding: 10px;
  	font-size: 18px;
  	color: white;
    text-shadow: 2px 2px 4px #000000;
  	text-align: center;
  }
  .answer-session{
  	margin: auto;
  	margin-top: 10px;
  	width: 90%;
  	min-height: 350px;
  	text-align: center;
  	border-radius: 10px;
  	border: 1px solid #aaaaaa;
  	box-shadow: 2px 5px #888888;
  	padding: 10px;
  }
  .bottom-session{
  	margin: auto;
  	margin-top: 10px;
  	width: 90%;
  	min-height: 10%;
  }
  .btm-right{
  	float: right;
  	width: 100px;
  	margin-right: 5px;
  }
  .txt-status{
  	font-style: italic;
  }
  .s-textarea {
  	width: 100%;
  	min-height: 50px;
  }
  .s-radio {
    margin: auto;
    text-align: left;
  	width: 200px;
  }
  .s-checkbox {
    margin: auto;
    text-align: left;
    padding-right: 5px;
  	width: 100%;
  }
  span{
    margin-left: 10px;
    font-style: italic;
  }
  .radio-element {
  	display: inline-block;
  	width: 50px;
  	margin-bottom: 10px;
  }
  
  .radio-element span {
  	margin-right: 10px;
  }
  
  </style>
  <script type="text/javascript">
  var questions = [];
  var currentQuestion = 1;
  var q1 = {
			index : 1,	  
			type: 'text',
			question: 'Họ và Tên',
			answer: ''
  };
  var q2 = {
			index : 2,	  
			type: 'text',
			question: 'Hãy cho mình biết email của bạn!',
			answer: ''
		  };
  var q3 = {
			index : 3,	  
			type: 'text',
			question: 'Số điện thoại!',
			answer: ''
		  };
  var q4 = {
			index : 4,	  
			type: 'text',
			question: 'Năm sinh',
			answer: ''
		  };
  var q5 = {
		  index : 5,
		  type : 'radio-button',
		  question : 'Nghề nghiệp của bạn',
		  options : ['Học sinh phổ thông','Sinh viên đi học', 'Đi làm'],
		  answer : ''
  };
  var q6 = {
		  index : 6,
		  type : 'radio-button',
		  question : 'Bạn đã từng thi IELTS bao giờ chưa?',
		  options : ['Có','Chưa'],
		  answer : ''
  };
  var q7 = {
		  index : 7,
		  type : 'radio-button-table',
		  xs : ['A1', 'A2', 'B1', 'B2'],
		  ys : ['Listening', 'Vocab', 'Grammar', 'Reading'],
		  question : 'Kết quả bài làm Entrance Test (nếu bạn chưa thi IELTS) (Ko cần làm nếu bạn đăng ký lớp Sentence & Writing)'
			  + 'Link bài test; https://www.oxfordonlineenglish.com/english-level-test',
		  answer : []
  };
  var q8 = {
			index : 8,	  
			type: 'text',
			question: 'Nếu đã từng thi IELTS, điểm overall của bạn là bao nhiêu?',
			answer: ''
		  };
  var q9 = {
		  index : 9,
		  type : 'radio-button-table',
		  xs : ['4.5', '5.0', '5.5', '6.0', '6.5', '7.0', '7.5', '8.0', '8.5', '9.0'],
		  ys : ['Reading', 'Listening', 'Speaking', 'Writing'],
		  question : 'Nếu đã từng thi IELTS, điểm từng thành phần của bạn là bao nhiêu?',
		  answer : []
  };
  var q10 = {
		  index : 10,
		  type : 'radio-button-plus-text',
		  question : 'Khoá học bạn đăng ký',
		  options : ['IELTS Basic (KG: 11/10/2018)','IELTS Foundation (KG: 10/10/2018)', 'Sentence Structure and Writing (KG: 17/10/2018)', 'Mục khác: '],
		  answer : ''
  };
  var q11 = {
		  index : 11,
		  type : 'radio-button',
		  question : 'Bạn dự định sẽ thi IELTS khi nào?',
		  options : ['3 tháng tới','6 tháng tới', '1 năm tới', 'Chưa xác định'],
		  answer : ''
  };
  var q12 = {
		  index : 12,
		  type : 'radio-button-plus-text',
		  question : 'Mục đích luyện thi IELTS của bạn?',
		  options : ['Tốt nghiệp Đại học','Du học', 'Cải thiện Tiếng Anh','Mục khác: '],
		  answer : ''
  };
  var q13 = {
			index : 13,	  
			type: 'text',
			question: 'Mục tiêu IELTS của bạn?',
			answer: ''
		  };
  
  var q14 = {
		  index : 14,
		  type : 'checkbox',
		  question : 'Những nội quy liên quan luyện thi IELTS tại VietAccepted',
		  options : ['Bài tập sẽ rất nhiều',
			  'Các bạn phải dành 2-3 tiếng mỗi ngày để hoàn thành đủ bài tập', 
			  'Sẽ chỉ có kỷ luât thép trong việc học bài và ôn thi',
			  'Tiền học phí đã đóng là không hoàn lại khi khoá học bắt đầu',
			  'Khoá học là không bảo lưu khi đã bắt đầu'],
		  answer : []
  };
  var q15 = {
			index : 15,	  
			type: 'text',
			question: 'Bạn biết đến VietAccepted IELTS qua nguồn nào/ ai giới thiệu không?'
				+ 'Nếu bạn có người quen giới thiệu, hãy ghi tên ra giúp mình nhé ^_^',
			answer: ''
		  };
  var q16 = {
			index : 16,	  
			type: 'text',
			question: 'Bạn có comment/ suggestions nào không?',
			answer: ''
		  };
  
  questions.push(q1);
  questions.push(q2);
  questions.push(q3);
  questions.push(q4);
  questions.push(q5);
  questions.push(q6);
  questions.push(q7);
  questions.push(q8);
  questions.push(q9);
  questions.push(q10);
  questions.push(q11);
  questions.push(q12);
  questions.push(q13);
  questions.push(q14);
  questions.push(q15);
  questions.push(q16);
  
  $(document).ready(function(){
	  //alert();
	$("#btn_submit").prop("disabled", true);
  	displayNextQuestion();
  
  });
  function getAnswerOfThisQuestion() {
	  var thisQuestion = questions[currentQuestion - 1];
	  if(thisQuestion.type === 'text') {
		  thisQuestion.answer = $("#txt-answer").val();
	
	  } else if(thisQuestion.type === 'radio-button') {
		  var name = "name" + (currentQuestion-1);
		  thisQuestion.answer = $('input[name='+ name +']:checked').val();
	  
	  } else if(thisQuestion.type === 'radio-button-table') {
		  var ys = thisQuestion.ys;
		  ys.forEach(function(y){
			  var name = "name" + ys.indexOf(y);
			  var answer = y + ": " + $('input[name='+ name +']:checked').val();
			  thisQuestion.answer.push(answer);
		  });
		  
	  } else if(thisQuestion.type === 'radio-button-plus-text') { 
		  var txtAnswer = $("#plus-txt-answer").val();
		  var name = "name" + (currentQuestion-1);
		  var answer = $('input[name='+ name +']:checked').val();
		  if(answer === thisQuestion.options[thisQuestion.options.length -1]){
			  answer += ": " + txtAnswer;
		  }
		  thisQuestion.answer = answer;
		  //alert(thisQuestion.answer);
		  
	  } else if(thisQuestion.type === 'checkbox') {
		  var options = thisQuestion.options;
		  options.forEach(function(option) {
			  var id = "#id" + options.indexOf(option);
			  if ($(id).is(":checked"))
			  {
			    thisQuestion.answer.push($(id).val());
			  }
		  });
		  
	  } else {
		  
	  }
	  //alert(thisQuestion.answer);
	  currentQuestion ++;
	  
	  displayNextQuestion();  
	 
  }
  function displayNextQuestion(){
	//Check if this is the last question
	  if(currentQuestion == questions.length){
		  $("#btn_next").prop("disabled", true);
		  $("#btn_submit").removeAttr("disabled");
	  }
	  if(currentQuestion > questions.length){
		  return;
	  }
	
	  var thisQuestion = questions[currentQuestion - 1];
	  $("#question").text(thisQuestion.question);
	  $("#answer").empty();
	  if(thisQuestion.type === 'text') {
		  $("#answer").append("<textarea id = 'txt-answer' class = 's-textarea'></textarea>");
	  } else if(thisQuestion.type === 'radio-button') {
		 var options = thisQuestion.options;
		 options.forEach(function(option) {
			 $("#answer").append("<div class = 's-radio'>"
					 +"<input type = 'radio' name = '"
					 + "name" + (currentQuestion-1)
					 + "' value = '" 
					 + option 
					 + "'><span>" 
					 + option 
					 + "</span></div>");
		 }); 
		  //$("#answer").append("<textarea class = 's-textarea'></textarea>");
	  } else if(thisQuestion.type === 'radio-button-table') {
		  var xs = thisQuestion.xs;
		  var ys = thisQuestion.ys;
		  ys.forEach(function(y){
			  $("#answer").append("<div class = 'tbl-row'>"
				+ "<label>" + y + "<label>");
				
				xs.forEach(function(x){
					$("#answer").append("<div class = 'radio-element'><input type = 'radio' name = '"
							+ "name" + ys.indexOf(y)
							+ "'value = '"
							+ x
							+ "'><span>" 
							+ x 
							+ "</span></div></div>");
				})
				
		  })
		  
	  } else if(thisQuestion.type === 'radio-button-plus-text') { 
		  var options = thisQuestion.options;
			 options.forEach(function(option) {
				 $("#answer").append("<div class = 's-radio'>"
						 +"<input type = 'radio' name = '"
						 + "name" + (currentQuestion-1)
						 + "' value = '" 
						 + option 
						 + "'><span>" 
						 + option 
						 + "</span></div>");
			 });
			 $("#answer").append("<textarea class = 's-textarea' id = 'plus-txt-answer'></textarea>");
			 
	  } else if(thisQuestion.type === 'checkbox') {
		  var options = thisQuestion.options;
			 options.forEach(function(option) {
				 $("#answer").append("<div class = 's-checkbox'>"
						 +"<input type = 'checkbox' id = '"
						 + "id" + options.indexOf(option)
						 + "' value = '" 
						 + option 
						 + "'><span>" 
						 + option 
						 + "</span></div>");
			 });
	  } else {
		  
	  }
	  
	  var status = "Câu hỏi thứ " + currentQuestion + " trong " + questions.length + " câu hỏi!";
	  $("#txt_status").text(status);
  }
  function submitAnswer(){
	  getAnswerOfThisQuestion();
	  url = document.location + "/sumitSurvey";
	  var answers = JSON.stringify(questions);
	  $.ajax({
			method: 'POST',
			url : url,
			dataType : "html",
			data : {
				answers : answers
			},
			success : function(responseText) {
				alert("SUBMITTED");
				$("#main-container").empty();
				$("#main-container").append("<h2>Cảm ơn bạn đã tham gia! Chúc bạn ngày mới vui vẻ!</h2>");
			},
	        error: function(e) 
	        {
	            alert('Error: ' + e);
	        }
		});
	  
  }
  </script>
</head>
<body>
<div class = "container container-fluid">
	<div class = "main-container bg-warning" id = "main-container">
		<div class = "row">
			<div class = "question-session bg-success text-default" id = "question">
			This is a question!
			</div>
			<div class = "row answer-session bg-success" id = "answer">
			This is answer part
			</div>
			<div class = "row bottom-session">
				<div class = "col-sm-6 txt-status text-info" id = "txt_status">hahaha</div>
				<div class = "col-sm-6">
					<button class = "btn btn-info btm-right" onclick = "getAnswerOfThisQuestion()" id = "btn_next">Next</button>
					<button class = "btn btn-info btm-right" onclick = "submitAnswer()" id = "btn_submit">Submit</button>
				</div>
			</div>
		</div>
</div>
</body>
</html>