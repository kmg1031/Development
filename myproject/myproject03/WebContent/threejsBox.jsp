<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Three.js</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/threejsBox.css" media="all" />
</head>
<body>
	<%
		Boolean code = true;
		String codeURL = "https://github.com/kmg1031/Development/blob/master/threejsBox.js";
	%>
	<%@ include file="js/header.js"%>
	<script src="js/three.min.js"></script>
	<script src="js/threejsBox.js"></script>
</body>
</html>