<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>student testing system</title>
 
 
<script src="/skin/scripts/common.js"></script>
<link rel="stylesheet" href="/skin/css/login1.css">

<script>

<%
 if(((String)request.getAttribute("login_fail"))=="Y"){%>
alert("user name or password is incorrect！");
<%}%>

function checkNameAndPassword(){
	var name= document.getElementById("name").value;
	var password = document.getElementById("password").value;
	if(name == ''||password == ''){
		alert("user name or password is required!");
		return;
	}else{
		document.getElementById("loginform").submit();
	}
} 



</script>
	 
</head>
<body>
<form action="/admin/login/AdminLoginController" method="post" id="loginform" >
	<div class="header">
		<div class="main">
			<img class="logo" src="/skin/images/logo1.png">
		</div>
	</div>
	<div class="container">
		<div class="main">
			<div class="loginBox">
			

				<div class="loginContent">
					<div class="title">adminLogin<span>LOGIN</span></div>
					<div class="inputArea">
						<div class="box user">
							<input type="text" id="name"  name="name" placeholder="User Name" >
							<i class="icn icn-20 icnUser"></i>
						</div>
						<div class="box">
							<input   type="password" id="password"  name="password" placeholder="Password">
							<i class="icn icn-20 icnpwd"></i>
						</div>
					</div>
					
					
					
					<div class="loginButton">
						<input class="login" type="button" onclick="javascript:checkNameAndPassword();" value="Log in">
					</div>
					
 
		
				</div>

				
			</div>
		</div>
	</div>
	<div class="loginBoxShadow">
		<div class="main"></div>
	</div>
	<div class="footer">
		<div class="main">
			Copyright © 2017 student testing system project. All rights reserved.     
		</div>
	</div>
	</form>
</body>
</html>