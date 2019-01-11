package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;

public class MemberIdCheckCommend implements MemberQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("idcheck");
	
		String userId=request.getParameter("userId");
		
		MemberDAO dao=MemberDAO.getInstance();		
		int result=dao.idCheck(userId);
		
		PrintWriter out=response.getWriter();
		out.write(result+"");
		
		out.close();
		
		
	}
}
