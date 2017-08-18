<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Student Testing System</title>
 
 
<script src="/skin/scripts/common.js"></script>
<link rel="stylesheet" href="/skin/css/login1.css">


	 
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
			
			<form id="loginForm"  action="/j_spring_security_check" method="post" >
				<div class="loginContent">
					<div class="title">Register</div>
					<div class="inputArea">
						<div class="box user">
							<input type="text" id="name"  name="name" placeholder="Name" >
							<i class="icn icn-20 icnUser"></i>
						</div>
						<div class="box user">
							<input type="text" id="email"  name="email" placeholder="Email address" >
							<i class="icn icn-20 icnUser"></i>
						</div>
						<div class="box user">
							<input type="text" id="phonenumber"  name="phonenumber" placeholder="Phone number" >
							<i class="icn icn-20 icnUser"></i>
						</div>
					</div>
					
					 <div class="errorContent">
					<div id="message" class="errorAlert" style="display:none;"></div>
					</div>
					<div class="loginButton">
						<input class="login" type="submit" value="Start testing">
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