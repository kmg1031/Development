<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/login.css" media="all" />

</head>
<body>
<%
	Boolean code = false;
	String codeURL = ""; 
%>
	<%@ include file="js/header.js"%>

<div class="login">
		<form action="MemberLogin.mo">
			<ul>
				<li class="title">LOGIN</li>
				<li><input type="text" name="userId" id="userId" placeholder="ID" /></li>
				<li><input type="password" name="userPw" id="userPw" placeholder="PASSWORD"/></li>
				<li><input type="button" value="로그인" onclick="loginOk()" /></li>
			</ul>
		</form>
	</div>
<script src="js/login.js"></script>

</body>
</html>