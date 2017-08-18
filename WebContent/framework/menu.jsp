<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Student Testing System</title>

<link href="/skin/css/common.css" rel="stylesheet" />
<link href="/skin/css/index.css" rel="stylesheet" type="text/css" />
</head>

	<body>
	<div id="menu" class="menu leftMenu">
				<ul id="menuUl">
				<li class="menuLi hasChildren selected">
				<a class="menuLink" href="/admin/main.jsp" >
					<i class="icn icn-26 icn-menuLink icn-menu-home"></i><span>Home</span><i class="after"></i>
				</a>
				</li>
				
				<li class="menuLi hasChildren selected">
				<a class="menuLink" href="/admin/QuestionsController" >
					<i class="icn icn-26 icn-menuLink icn-menu-jcwj"></i><span>TestBank</span><i class="after"></i>
				</a>
				</li>
					<li class="menuLi hasChildren selected"><a class="menuLink"> 
						<i class="icn icn-26 icn-menuLink icn-menu-xtgl"></i><span>Exam Management</span> <i class="after"></i>
					</a>
						<ul class="subMenu" style="">
							<li class=""><a href="/admin/ManagerQuestionCountController"><i class="icn icn-10 icn-menu-hscd"></i>
							<span>Exam Quantity Management</span><i class="triangle"></i></a></li>
						</ul>
						<ul class="subMenu" style="">
							<li class=""><a href="/admin/TestResultConfigerConterller"><i class="icn icn-10 icn-menu-hscd"></i>
							<span>Testing Grades Level Management </span><i class="triangle"></i></a></li>
						</ul>
					</li>
					<li class="menuLi hasChildren selected"><a class="menuLink"> 
						<i class="icn icn-26 icn-menuLink icn-menu-jjgc"></i><span>Info Search</span> <i class="after"></i>
					</a>
					<ul class="subMenu" style="">
							<li class=""><a href="/admin/SearchStudentScoreContorller"><i class="icn icn-10 icn-menu-hscd"></i>
							<span>Testing Results</span><i class="triangle"></i></a></li>
						</ul>
					</li>
					
					<li class="menuLi hasChildren selected"><a class="menuLink"> 
						<i class="icn icn-26 icn-menuLink icn-menu-tjfx"></i><span>Log out</span> <i class="after"></i>
					</a>
					</li>
					
				</ul>
				<div class="clear"></div>
			</div>
</body>