<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="sts.vo.StudentScoreVO"%>
<%@ page import="sts.vo.StudentVO"%>
<!DOCTYPE html>
<html>
<link href="/skin/css/table.css" rel="stylesheet" type="text/css" />
<link href="/skin/css/list.css" rel="stylesheet" type="text/css" />
<link href="/skin/css/frame.css" rel="stylesheet" type="text/css" />

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
	
	<div class="serchResult" >
		<div class="resultTableTitle">
			<div class="result">
			<%List<StudentScoreVO> list = (List<StudentScoreVO>)request.getAttribute("scoreList"); %>
						<span class="resultTitle">Result</span>（Total is<span><%=list.size() %></span>）
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
				<th>Student ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Correct rate</th>
				<th>level</th>
			</thead>				
				
					
					<%for(StudentScoreVO vo : list){%>
					<tr align="center">
					<td><%=vo.getStudentVO().getId() %></td>					
					<td><%=vo.getStudentVO().getName() %></td>
					<td><%=vo.getStudentVO().getEmail() %></td>
					<td><%=vo.getStudentVO().getMobile_number() %></td>
					<td><%=vo.getScore() %></td> 
					<td><%=vo.getLevel() %></td>
					</tr>
					<%} %>
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
