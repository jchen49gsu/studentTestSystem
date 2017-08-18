<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<script>
function updateconf(){
	document.getElementById("updatecfg").submit();
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
							   <div style="width:1100px;height:450px;">
							   <div class="informationArea">
							   <form action='/admin/ManagerQuestionCountController'  method="post" id="updatecfg" name="updatecfg">
							   <input type="hidden" value="update" id="method" name="method"/>
							   <span class="label">Questions Quantity：</span>
								<div  style="height:50px;">
								<select id="questioncfgs" name="questioncfgs" >
								<%List<Integer> list = (List<Integer>)request.getAttribute("list");
								Integer counts = (Integer)request.getAttribute("counts");
								for(Integer i: list){
									if(counts.intValue()==i.intValue()){%>
									<option selected="selected"><%=i %></option>
									<%}else{%>
									<option><%=i %></option>
									<%}
								 }%>
								</select>
		 						</div>
		 						<input type="button" value="Submit" onclick="updateconf();" class="findOut" />	
							   </form>
							   </div>
							   </div>
						</div>

				<!-- footer -->
			<jsp:include page="../framework/footer.jsp"></jsp:include>			

				</div>
			</div>
		</div>
	</div>




</body>


</html>
