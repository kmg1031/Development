<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Three.js</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/join.css" media="all" />
</head>
<body>
<%
	Boolean code = false;
	String codeURL = ""; 
%>
	<%@ include file="js/header.js"%>

	<div class="join">
		<form action="JoinOk.mo">

			<ul>
				<li class="title">JOIN</li>
				<li id="id">
					<input type="text" name="userId" id="userId" placeholder="ID" />
					<input type="button" value="아이디 체크" onclick="idChecked()" />
				</li>
				<li><input type="password" name="userPw" id="userPw" placeholder="PASSWORD" onkeyup="pwChecked()" /></li>
				<li><input type="password" name="userPwCheck" id="userPwCheck" placeholder="PASSWORD CHECK" onkeyup="pwChecked()"/></li>
				<li id="pw"><span id="pwCheck">비밀번호를 확인해주세요</span></li>
				<li><input type="text" name="userName" id="userName" placeholder="NAME" /></li>
				<li><input type="button" value="회원가입" onclick="joinOk()" /></li>
			</ul>

		</form>
	</div>

<script src="js/join.js"></script>
</body>
</html>