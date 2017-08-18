<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Student Testing System</title>
 
 
<script src="/skin/scripts/common.js"></script>
<link rel="stylesheet" href="/skin/css/login1.css">

<script type="text/javascript">
<%
Object message = request.getAttribute("student_exist");
if(message!=null){
	String msg = (String)message;
	if(msg.equals("true")){
		%>
		alert("email address registered successfully, please check");
		<%
	}
}
%>

function checkForm(){
	
	var name = document.getElementById("name").value;
	var phone =  document.getElementById("phonenumber").value;
	var email = document.getElementById("email").value;
	if(name==''||phone==''||email==''){
		alert("please complete");
		return;
	}
	if(!check(email)){
		 window.alert( "email address not exists" );
		 return;
	}
	if(!checkphone(phone)){
		 alert('please enter correct phone number');  
		 return;
	}
	document.getElementById("loginForm").submit();
}


	 function check(email_address)
	    {
	        var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	        if ( regex.test( email_address ) )
	        {
	            
	            var user_name = email_address.replace( regex, "$1" );
	            var domain_name = email_address.replace( regex, "$2" );
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }

	 function checkphone(phone){
		 var re= /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;   
		 if(!re.test(phone)){   
			 return false;
		 }else{
			 return true;
		 }
	}

</script>
	 
</head>
<body>
	<div class="header">
		<div class="main">
			<img class="logo" src="/skin/images/logo1.png">
		</div>
	</div>
	<div class="container">
		<div class="main">
			<div class="loginBox">
			
			<form id="loginForm"  action="/exam/StudentRegisterController" method="post" >
				<div class="loginContent">
					<div class="title">Register</div>
					<div class="inputArea">
						<div class="box user">
							<input type="text" id="name"  name="name" placeholder="Name" >
							<i class="icn icn-20 icnUser"></i>
						</div>
						<div class="box user">
							<input type="text" id="email"  name="email" placeholder="Email Address" >
							<i class="icn icn-20 icnUser"></i>
						</div>
						<div class="box user">
							<input type="text" id="phonenumber"  name="phonenumber" placeholder="Phone Number" >
							<i class="icn icn-20 icnUser"></i>
						</div>
					</div>
					
					 <div class="errorContent">
					<div id="message" class="errorAlert" style="display:none;"></div>
					</div>
					<div class="loginButton">
						<input class="login" type="button" onclick="javascript:checkForm();" value="Start Testing">
					</div>
					
 
		
				</div>
				</form>
				
			</div>
		</div>
	</div>
	<div class="loginBoxShadow">
		<div class="main"></div>
	</div>
	<div class="footer">
		<div class="main">
			Copyright © 2017 student testing system project      All rights reserved.
		</div>
	</div>
</body>
</html>