<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="sts.vo.TestResultCfgVO"%>
<!DOCTYPE html>
<html>
<script>
function checkvalues(){
	var d_start = document.getElementById("d_start").value;
	var c_start = document.getElementById("c_start").value;
	var b_start = document.getElementById("b_start").value;
	var a_start = document.getElementById("a_start").value;
	var d_end = document.getElementById("d_end").value;
	var c_end = document.getElementById("c_end").value;
	var b_end = document.getElementById("b_end").value;
	var a_end = document.getElementById("a_end").value;
	var desca = document.getElementById("desca").value;
	var descb = document.getElementById("descb").value;
	var descc = document.getElementById("descc").value;
	var descd = document.getElementById("descd").value;
	if(d_start>=d_end){
		alert(d_start);
		alert(d_end);
		alert("D end must greater than start! ");
		return;
	}
	if(d_end!=c_start){
		alert("D end must equal to C start!");
		return;
	}
	if( c_end<=c_start){
		alert("C end must equal to B start!"！");
		return;
	}
	if(c_end!=b_start){
		alert("B end must equal to A start!"！");
		return;
	}
	if(b_start>=b_end){
		 alert("B end must greater than start!");
		 return;
	}
	if(b_end!=a_start){
		alert("B end must equal to A start!");
		return;
	}
	if(desca==''||descb==''||descc==''||descd==''){
		alert("Must fill out discription");
		return;
	}
	document.getElementById("tsetresultconfigform").submit();
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
							   <form action='/admin/TestResultConfigerConterller'  method="post" id="tsetresultconfigform" name="tsetresultconfigform">
							   <input type="hidden" value="update" id="method" name="method"/>
							   <span class="label">Testing Result level：</span>
		 						<div  style="height:50px;">
		 						<%TestResultCfgVO vod = (TestResultCfgVO)request.getAttribute("vod");
		 						TestResultCfgVO voc = (TestResultCfgVO)request.getAttribute("voc");
		 						TestResultCfgVO vob = (TestResultCfgVO)request.getAttribute("vob");
		 						TestResultCfgVO voa = (TestResultCfgVO)request.getAttribute("voa");
		 						%>
		 						
								Level D：<select id="d_start" name="d_start" >
								<option>0</option>
								</select>%
								&nbsp;&nbsp;&nbsp;&nbsp;
								<select id="d_end" name="d_end" >
								<% if(vod.getGrader_percent_end()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(vod.getGrader_percent_end()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Description：<input type="text" value="<%=vod.getGrader_descripton() %>" id="descd" name ="descd">
		 						</div>
		 						<div  style="height:50px;">
								Level C：<select id="c_start" name="c_start" >
								<% if(voc.getGrader_percent_start()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(voc.getGrader_percent_start()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%
								&nbsp;&nbsp;&nbsp;&nbsp;
								<select id="c_end" name="c_end" >
								<% if(voc.getGrader_percent_end()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(voc.getGrader_percent_end()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Description：<input type="text" value="<%=voc.getGrader_descripton() %>" id="descc" name ="descc">
		 						</div>
		 						<div  style="height:50px;">
								LevelB：<select id="b_start" name="b_start" >
								<% if(vob.getGrader_percent_start()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(vob.getGrader_percent_start()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%
								&nbsp;&nbsp;&nbsp;&nbsp;
								<select id="b_end" name="b_end" >
								<% if(vob.getGrader_percent_end()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(vob.getGrader_percent_end()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Description：<input type="text" value="<%=vob.getGrader_descripton() %>" id="descb" name ="descb">
		 						</div>
		 						<div  style="height:50px;">
								LevelA：<select id="a_start" name="a_start" >
								<% if(voa.getGrader_percent_start()==10){%>
									<option selected="selected">10</option>
								<%} else{%>
									<option>10</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==20){%>
									<option selected="selected">20</option>
								<%} else{%>
									<option>20</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==30){%>
									<option selected="selected">30</option>
								<%} else{%>
									<option>30</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==40){%>
									<option selected="selected">40</option>
								<%} else{%>
									<option>40</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==50){%>
									<option selected="selected">50</option>
								<%} else{%>
									<option>50</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==60){%>
									<option selected="selected">60</option>
								<%} else{%>
									<option>60</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==70){%>
									<option selected="selected">70</option>
								<%} else{%>
									<option>70</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==80){%>
									<option selected="selected">80</option>
								<%} else{%>
									<option>80</option>
								<%}%>
								<% if(voa.getGrader_percent_start()==90){%>
									<option selected="selected">90</option>
								<%} else{%>
									<option>90</option>
								<%}%>
								</select>%
								&nbsp;&nbsp;&nbsp;
								<select id="a_end" name="a_end" >
								<option>100</option>
								</select>%&nbsp;&nbsp;&nbsp;&nbsp; Description：<input type="text" value="<%=voa.getGrader_descripton() %>" id="desca" name ="desca">
		 						</div>
		 						<input type="button" value="Submit" onclick="checkvalues();" class="findOut" />	
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
