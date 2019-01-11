package org.web.membercommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDAO;
import org.web.memberdto.MemberDTO;

public class MemberDeleteViewCommend implements MemberQueryCommend {
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("DeleteView");

		String userId = request.getParameter("userId");

		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO result = dao.modifyView(userId);

		String url = "";

		if (result != null) {

			request.setAttribute("member", result);
			url = "memberDelete.jsp";

		} else {
			url = "index.jsp";
		}
		
		request.setAttribute("url", url);
	}
}
