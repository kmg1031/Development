<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link rel="stylesheet" href="css/map.css" media="all" />


</head>
<body>

	<%@ include file="js/header.js" %>

	<div id="map" ></div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65eab00c40798a2648dccc278b639f07&libraries=services"></script>
	<script type="text/javascript">
	
	
		var container = document.getElementById('map'); 
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(33.450701, 126.570667),
			level : 3
		};
		
		var map = new daum.maps.Map(container, options);
		
		
	</script>

</body>
</html>