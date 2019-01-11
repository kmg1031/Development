package org.web.membercommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutCommend implements MemberQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("logout");
		
		HttpSession session=request.getSession();
		
		session.invalidate();
		
		request.setAttribute("url", "index.jsp");
		
	}
}
