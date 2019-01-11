var xhr = new XMLHttpRequest();
	var idCheckOk=false;
	var userId = document.getElementById("userId");
	var userPw = document.getElementById("userPw");
	var userPwCheck = document.getElementById("userPwCheck");
	var userIdSave="";
	
	userId.addEventListener('change',function(){
			idCheckOk=false;
	});
	userPw.addEventListener('change',function(){
		pwChecked();
	});
	userPwCheck.addEventListener('change',function(){
		pwChecked();
	});
	
	
	function idChecked() {

		if (userId.value==null || userId.value=="") {
			alert("아이디를 입력해주세요");
			userId.focus();
			return false;
		}

		var data = "userId=" + userId.value;
		var url = "IdChecked.mo";

		xhr.open("post", url);
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8")
		xhr.onreadystatechange = idCheckedOk;
		xhr.send(data);

	}

	function idCheckedOk() {

		if (xhr.status == 200 && xhr.readyState == 4) {

			var result = xhr.responseText;

			if (result == 1) {
				alert("중복아이디")
				idCheckOk=false;
				userId.focus();
			} else {
				alert("사용 가능한 아이디")
				idCheckOk=true;
				userIdSave=userId.value;
				userId.focus();
			}
		}
	}

	function pwChecked(){
		var li_Pw=document.getElementById("pw");
		var sp_pwCheck=document.getElementById("pwCheck");
		if(userPw.value==userPwCheck.value){
			li_Pw.style.display="none";
			return false;
		}else{
			li_Pw.style.display="block";
			return true;
		}
	}
	
	function joinOk() {

		var userPw = document.getElementById("userPw");
		var userName = document.getElementById("userName");

		if (!idCheckOk) {
			alert("아이디를 확인해주세요");
			userId.focus();
			return false;
		} else if (userPw.value == null || userPw.value == "") {
			alert("비밀번호를 확인해주세요");
			userPw.focus();
			return false;
		} else if (userName.value == null || userName.value == "") {
			alert("이름을 확인해주세요");
			userName.focus();
			return false;
		} else if (pwChecked()) {
			alert("비밀번호를 확인해주세요");
			userPw.focus();
			return false;
		}
		
		var data = "userId=" + userId.value;
		data += "&userPw="+userPw.value;
		data += "&userName="+userName.value;
		var url = "MemberJoin.mo";

		xhr.open("post", url);
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8")
		xhr.onreadystatechange = joinOkFn;
		xhr.send(data);
	
	}
	
	function joinOkFn(){
		
		if (xhr.status == 200 && xhr.readyState == 4) {
		
			var result=xhr.responseText;
			
			if(result=="1"){
				alert("회원가입 성공")
				location.href="index.jsp";
			}else{
				idCheckOk=false;
				alert("회원가입 실패")
			}
		}	
	}
	
	
	