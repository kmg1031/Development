package org.web.memberdto;

public class MemberDTO {
	
	private String userId;
	private String userPw;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public String getUserName() {
		return userName;
	}
	public MemberDTO(String userId) {
		super();
		this.userId = userId;
	}
	public MemberDTO(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	public MemberDTO(String userId, String userPw, String userName) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	
	
}
