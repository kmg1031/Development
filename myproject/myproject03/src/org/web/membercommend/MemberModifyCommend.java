package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberModifyCommend implements MemberQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("MemberModify");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		
		MemberDAO dao=MemberDAO.getInstance();		
		int result=dao.update(new MemberDTO(userId,userPw,userName));
		
		PrintWriter out=response.getWriter();
		out.write(result+"");
		
		out.close();
		
		
		
		
	}
}
