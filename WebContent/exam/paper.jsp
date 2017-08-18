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
<script type="text/javascript">
function submitForm(){
	var from = document.getElementById("paperform");
	from.submit();
}
</script>
<body class="">
			<!-- header -->
		<jsp:include page="../framework/header.jsp"></jsp:include>
		<div class="container">
<% List<ExamVO> list = (List<ExamVO>)request.getSession().getAttribute("examList"); %>
		
			<!-- menu -->
			<jsp:include page="../framework/studentinfo.jsp"></jsp:include>
			
			
			<div id="frameDiv" class="frame">
				<div class="contentContainer">
					<div class="content">
						
						<form id="paperform" action="/exam/CheckPaperContorller" method="post">
						<div id="mainFrame" class="projectContent">
						<!-- content -->
						 Multiple choices：please select the correct answers
							 <br/>
							 <br/>
						<%int i = 0;
						for(ExamVO vo : list){
						i++;
						%>
						<%=i %>. <%=vo.getContans() %>
						 <br/>
						<br/>
						<span class="label">A：&nbsp;</span><input type="radio"  name="<%=vo.getId() %>" value="A" />  &nbsp;&nbsp;&nbsp;<%=vo.getAnswerA() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="label">B：&nbsp;</span><input type="radio"  name="<%=vo.getId() %>" value="B" />  &nbsp;&nbsp;&nbsp;<%=vo.getAnswerB() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="label">C：&nbsp;</span><input type="radio"  name="<%=vo.getId() %>" value="C" />  &nbsp;&nbsp;&nbsp;<%=vo.getAnswerC() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="label">D：&nbsp;</span><input type="radio"  name="<%=vo.getId() %>" value="D" />  &nbsp;&nbsp;&nbsp;<%=vo.getAnswerD() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<br/>
							<br/>	
						<% } %>		
						</div>
							 <div align='center'> <input id='savebutton' name= 'savebutton' class="submit" type="button" value="Submit" onclick="submitForm();"></div>
						</form>
				<!-- footer -->
			<jsp:include page="../framework/footer.jsp"></jsp:include>			

				</div>
			</div>
		</div>
	</div>




</body>


</html>
