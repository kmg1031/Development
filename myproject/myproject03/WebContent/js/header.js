<%@ page pageEncoding="UTF-8"%>
<div id="header">
	<div class="gnb">
		<ul>
			<%	if(code) { %> <li><a href="<%=codeURL %>">코드보기</a></li> <% } %>
			<li><a href="index.jsp">홈으로</a></li>			
		</ul>
	</div>
</div>