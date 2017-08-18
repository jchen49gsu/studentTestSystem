<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sts.vo.StudentVO"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student Testing System</title>

<link href="/skin/css/common.css" rel="stylesheet" />
<link href="/skin/css/index.css" rel="stylesheet" type="text/css" />
</head>
<%StudentVO vo = (StudentVO)request.getSession().getAttribute("StudentVO");  %>
	<body>
	<div id="menu" class="menu leftMenu">
				<ul id="menuUl">
					<li class="menuLi hasChildren selected"><span style="color:white;"></span> <i class="after"></i>
						<ul class="subMenu" style="">
							<li class=""><i class="icn icn-10 icn-menu-hscd"></i>
							<span style="color:white;">Name：<%=vo.getName()%></span><i class="triangle"></i></li>
						</ul>
						<ul class="subMenu" style="">
							<li class=""><i class="icn icn-10 icn-menu-hscd"></i>
							<span style="color:white;">Email：<%=vo.getEmail() %></span><i class="triangle"></i></li>
						</ul>
						<ul class="subMenu" style="">
							<li class=""><i class="icn icn-10 icn-menu-hscd"></i>
							<span style="color:white;">Phone：<%=vo.getMobile_number() %></span><i class="triangle"></i></li>
						</ul>
					</li>
				</ul>
				<div class="clear"></div>
			</div>
</body>