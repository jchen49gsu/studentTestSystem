<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="sts.vo.ExamVO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student Testing System</title>

<link href="/skin/css/common.css" rel="stylesheet" />
<link href="/skin/css/index.css" rel="stylesheet" type="text/css" />



</head>

<body class="">
			<!-- header -->
		<jsp:include page="../framework/header.jsp"></jsp:include>
		<div class="container">
<% List<ExamVO> list = (List<ExamVO>)request.getAttribute("wrong");
int percent = (Integer)request.getAttribute("persent");
String grader = (String)request.getAttribute("garde");
String descriptin = (String)request.getAttribute("desciption");
%>
		
			<!-- menu -->
			<jsp:include page="../framework/studentinfo.jsp"></jsp:include>
			
			
			<div id="frameDiv" class="frame">
				<div class="contentContainer">
					<div class="content">
						
				
						<div id="mainFrame" class="projectContent">
						 <div align='center'>Correct Rate：<%= percent%>%;</div>
						 <div align='center'>Level：<%= grader%>;</div>
						  <div align='center'><%= descriptin%>;</div>
						</div>
					
				<!-- footer -->
			<jsp:include page="../framework/footer.jsp"></jsp:include>			

				</div>
			</div>
		</div>
	</div>




</body>


</html>
