var xhr=new XMLHttpRequest();
var userId = document.getElementById("userId");
var userPw = document.getElementById("userPw");

function loginOk() {

	if (userId.value == null || userId.value == "") {
		alert("아이디를 확인해주세요");
		userId.focus();
		return false;
	} else if (userPw.value == null || userPw.value == "") {
		alert("비밀번호을 확인해주세요");
		userPw.focus();
		return false;
	}
	
	var data = "userId=" + userId.value;
	data += "&userPw="+userPw.value;
	var url = "MemberLogin.mo";

	xhr.open("post", url);
	xhr.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=utf-8")
	xhr.onreadystatechange = loginOkFn;
	xhr.send(data);

}

function loginOkFn(){
	
	if (xhr.status == 200 && xhr.readyState == 4) {
	
		var result=xhr.responseText;
		
		if(result=="1"){
			alert("로그인 성공")
			location.href="index.jsp";
			
		}else{
			alert("로그인 실패")
			userPw.value="";
			userId.focus();			
		}
	}	
}