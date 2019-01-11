<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/bordList.css" media="all" />

</head>
<body>
	<%
	Boolean code = false;
	String codeURL = ""; 
%>
	<%@ include file="js/header.js"%>
	
	<div class="listPage">
		<table class="list table table-hover table-bordered ">
			<h1 class="title">LIST</h1>
			<thead>
				<tr>
					<th class="nicName">글번호</th>
					<th class="title">제목</th>
					<th class="memo">내용</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr class="body">
						<td class="nicName">${dto.name}</td>
						<td class="title">${dto.title}</td>
						<td class="memo">${dto.memo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="page">
			<c:if test="${pageNum!=1}">
				<a value="1">[<<]</a>
				<a value="${pageNum-1}">[<]</a>
			</c:if>

			<c:forEach begin="${sPage}" end="${ePage}" var="page">

				<c:choose>
					<c:when test="${pageNum eq page}">
						<span>${page}</span>
					</c:when>
					<c:otherwise>
						<a value="${page}">[${page}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${pageNum!=pageSize}">
				<a value="${pageNum+1}">[>]</a>
				<a value="${pageSize}">[>>]</a>
			</c:if>

		</div>
	</div>

	<script type="text/javascript">
		$("a").on("click", function() {
			event.preventDefault();

			$.ajax({ //ajax list get
				url : 'BordList.bo',
				data : {
					page : $(this).attr('value')
				},
				type : 'post'
			}).done(function() {

			}).fail(function() {

			}).always(function() {
				$("#content").load("list.jsp", bordViewFn) //페이지 표시
			})

		});
	</script>
</body>
</html>