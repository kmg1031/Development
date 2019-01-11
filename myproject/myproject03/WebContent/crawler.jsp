<%@page import="org.jsoup.select.Elements"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crawlerEx</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/crawler.css" media="all" />


</head>
<body>

<!-- crawler.bo -->
	<%
		Boolean code = true;
		String codeURL = "https://github.com/kmg1031/Development/blob/master/CrawlerCommend.java"; 
	%>
	<%@ include file="js/header.js" %>

<div class="title">
	<h1 class="title">네이버 웹툰 크롤링 예제</h1>
	
</div>

<div id="content">
<ul>
	<li class="col">
		<span>월요일</span>
		<c:forEach var="var" items="${allList.get(0)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>

	<li class="col">
		<span>화요일</span>
		<c:forEach var="var" items="${allList.get(1)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	<li class="col">
		<span>수요일</span>
		<c:forEach var="var" items="${allList.get(2)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	<li class="col">
		<span>목요일</span>
		<c:forEach var="var" items="${allList.get(3)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	<li class="col">
		<span>금요일</span>
		<c:forEach var="var" items="${allList.get(4)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	<li class="col">
		<span>토요일</span>
		<c:forEach var="var" items="${allList.get(5)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	<li class="col">
		<span>일요일</span>
		<c:forEach var="var" items="${allList.get(6)}">
			<div class="thumb">
				<a href="${var.href}"><img src="${var.src}" alt="${var.title}"></a>
				<a href="${var.href}">${var.title}</a>
			</div>
		</c:forEach>
	</li>
	
</ul>
</div>
<div id="footer">
	
</div>
</body>
</html>