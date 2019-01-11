package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDAO;

public class MemberLoginCommend implements MemberQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("login");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		MemberDAO dao=MemberDAO.getInstance();		
		int result=dao.login(userId,userPw);
		
		String url="";
		
		if(result==1) {
			
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*30);
			session.setAttribute("sessionId", userId);
			
		}
		
		PrintWriter out=response.getWriter();
		out.write(result+"");
		
		out.close();
		
		
		
	}
}
