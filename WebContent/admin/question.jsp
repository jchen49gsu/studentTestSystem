<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="sts.vo.ExamVO"%>
<!DOCTYPE html>
<html>
<link href="/skin/css/table.css" rel="stylesheet" type="text/css" />
<link href="/skin/css/list.css" rel="stylesheet" type="text/css" />
<link href="/skin/css/frame.css" rel="stylesheet" type="text/css" />
<script>
function add_question(){
	var question_content = document.getElementById("question_content").value;
	var answer_a = document.getElementById("answer_a").value;
	var answer_b = document.getElementById("answer_b").value;
	var answer_c = document.getElementById("answer_c").value;
	var answer_d = document.getElementById("answer_d").value;
	if(question_content==''||answer_a==''||answer_b==''||answer_c==''||answer_d==''){
		alert("please enter correct answer!");
		return;
	}else{
		if('<%=(String)request.getAttribute("modify")%>'=='Y'){
			document.getElementById("method").value = "update";
			
		}
		document.getElementById("addquestionform").submit();		
	}
}
</script>
<body class="">
			<!-- header -->
		<jsp:include page="../framework/header.jsp"></jsp:include>
		<div class="container">

		
			<!-- menu -->
			<jsp:include page="../framework/menu.jsp"></jsp:include>
			

			<div id="frameDiv" class="frame">
				<div class="contentContainer">
					<div class="content">
						

						<div id="mainFrame" class="projectContent">
						<!-- content -->
							   <!-- start -->
		<form id="addquestionform" method="post"  action='/admin/QuestionsController' >
		<%ExamVO evo = (ExamVO)request.getAttribute("exam_vo"); 
		if(evo==null||evo.getAnswer() == null){
			evo = new ExamVO();
			evo.setAnswer("");
			evo.setContans("");
			evo.setAnswerA("");
			evo.setAnswerB("");
			evo.setAnswerC("");
			evo.setAnswerD("");
		}
		%>
		<input type="hidden" id="method" name="method" value="add"/>
		<input type="hidden" id="questionid" name="questionid" value="<%=evo.getId()%>"/>
		
		<span class="label"> Question Content：</span>
		<div  style="height:100px;">
		<textarea id="question_content" name="question_content" style="height:100px; width: 1000px;" ><%=evo.getContans() %></textarea>
		 </div>
		 <span class="label">Choices：</span>
		<div  style="height:50px;">
		 <span class="label">A：</span><input id="answer_a" name="answer_a" value="<%=evo.getAnswerA() %>" type="text"/>
		 <span class="label">B：</span><input id="answer_b" name="answer_b"  value="<%=evo.getAnswerB() %>" type="text"/>
		 <span class="label">C：</span><input id="answer_c" name="answer_c"  value="<%=evo.getAnswerC() %>" type="text"/>
		 <span class="label">D：</span><input id="answer_d" name="answer_d"  value="<%=evo.getAnswerD() %>" type="text"/>
		 </div>
		 
		 <span class="label">Correct Answer：</span>
		<div  style="height:50px;">
		<select id="answer" name="answer" >
		<%  if(evo!=null&&evo.getAnswer()!=null&&evo.getAnswer().equals("A")){%>
			<option selected="selected">A</option>
		<% } else{%>
		<option >A</option>
		<% }%>
		
		<%  if(evo!=null&&evo.getAnswer()!=null&&evo.getAnswer().equals("B")){%>
			<option selected="selected">B</option>
		<% } else{%>
		<option >B</option>
		<% }%>
		
		<%  if(evo!=null&&evo.getAnswer()!=null&&evo.getAnswer().equals("C")){%>
			<option selected="selected">C</option>
		<% } else{%>
		<option >C</option>
		<% }%>
		
		<%  if(evo!=null&&evo.getAnswer()!=null&&evo.getAnswer().equals("D")){%>
			<option selected="selected">D</option>
		<% } else{%>
		<option >D</option>
		<% }%>
		
		</select>
		 </div>
		
		<input type="button" value="Submit" onclick="add_question();" class="findOut" />	
		</form>
	
	
	<% List<ExamVO> list = (List<ExamVO>)request.getAttribute("questList");
				%>
	
	
	<div class="serchResult" >
		<div class="resultTableTitle">
			<div class="result">
						<span class="resultTitle">Searching Results</span>（total is  <span><%=list.size() %></span>）
			</div>
		</div>
<form id="alldatafile" method="post" name="alldatafile" action='' >
	<hr>
	<div class="resultTableTitle">
	<div class="lfloat">
	</div>
	
  </div>
		<table  id="resultList" >
		
			 <thead style="background: #ebebeb;font-size:13px;">
				<th>QuestionID</th>
				<th>Question content</th>
				<th>Choice A</th>
				<th>Choice B</th>
				<th>Choice C</th>
				<th>Choice D</th>
				<th>Answer</th>
				<th>Select</th>
			</thead>				
				
				<%
				for(int i=0; i<list.size(); i++){
					ExamVO vo = list.get(i);%>
					<tr align="center">
					<td><%=vo.getId() %></td>					
					<td><%=vo.getContans() %></td>
					<td><%=vo.getAnswerA() %></td>
					<td><%=vo.getAnswerB() %></td>
					<td><%=vo.getAnswerC() %></td> 
					<td><%=vo.getAnswerD() %></td>
					<td><%=vo.getAnswer() %></td>
					<td ><a href="/admin/QuestionsController?method=delete&id=<%=vo.getId() %>"><i>Delete</i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/admin/QuestionsController?method=modify&id=<%=vo.getId() %>"><i>Edit</i></a></td>
				</tr>
				<% } %>
		</table>
	
	</form>
	</div>
							   
							   <!-- end -->
							   
						</div>

				<!-- footer -->
			<jsp:include page="../framework/footer.jsp"></jsp:include>			

				</div>
			</div>
		</div>
	</div>




</body>


</html>
