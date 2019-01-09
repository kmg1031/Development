<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/canvas.css" media="all" />
<link rel="stylesheet" href="css/join.css" media="all" />
<link rel="stylesheet" href="css/login.css" media="all" />
<link rel="stylesheet" href="css/list.css" media="all" />
<link rel="stylesheet" href="css/bootstrap.min.css" media="all" />
<script src="js/jquery-3.3.1.min.js"></script>

</head>
<body>

	<%@ include file="js/header.js"%>

	<div id="box">
		<div class="canvasFrame">
			<canvas id="cnvs" width="1000" height="600"></canvas>

		</div>
	</div>

	<div id="screen">
		<button id="con1" class="btn con">HOME</button>
		<button id="con2" class="btn con">JOIN</button>
		<button id="con3" class="btn con">LOGIN</button>
		<button id="con4" class="btn con">LIST</button>
	</div>

	<div id="bord">
		<div id="content" class="content"></div>
	</div>

	<script src="js/canvas.js"></script>
	<script>
		var bord = document.getElementById('bord');
		var content = document.getElementById('content');
		var con1 = document.getElementById('con1');

		bord.addEventListener('click', bordCloseFn);

		$("#con1").on("click", function() {
			location.href = "index.jsp";

		});
		$("#con2").on("click", function() {
			$("#content").load("join.jsp", bordViewFn)

		});
		$("#con3").on("click", function() {
			$("#content").load("login.jsp", bordViewFn)

		});
		$("#con4").on("click", function() {

			$.ajax({ //ajax list get
				url : 'BordList.bo',
				data : {},
				type : 'post'
			}).done(function() {

			}).fail(function() {

			}).always(function() {
				$("#content").load("list.jsp", bordViewFn) //페이지 표시
			})

		});

		function bordViewFn() {
			bord.style.display = "block";
			content.style.display = "block";
		}
		function bordCloseFn() {

			if (event.target === bord) {
				bord.style.display = "none";
			}
		}
	</script>


</body>
</html>