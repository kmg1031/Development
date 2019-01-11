package org.web.membercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.membercommend.*;

@WebServlet("*.mo")
public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		request.setCharacterEncoding("utf-8");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String basicURI = uri.substring(path.length());

		String url = "index.jsp";
		MemberQueryCommend action = null;

		if (basicURI.equals("/MemberJoin.mo")) {
			action = new MemberJoinCommend();
			action.excuteQueryCommend(request, response);
			return;
		} else if (basicURI.equals("/MemberLogin.mo")) {
			action = new MemberLoginCommend();
			action.excuteQueryCommend(request, response);
			return;
		} else if (basicURI.equals("/MemberModify.mo")) {
			action = new MemberModifyCommend();
			action.excuteQueryCommend(request, response);
			url = (String)request.getAttribute("url");
		} else if (basicURI.equals("/ModifyView.mo")) {
			action = new MemberModifyViewCommend();
			action.excuteQueryCommend(request, response);
			url = (String)request.getAttribute("url");
		} else if (basicURI.equals("/MemberDelete.mo")) {
			action = new MemberDeleteCommend();
			action.excuteQueryCommend(request, response);
			return;
		} else if (basicURI.equals("/memberDeleteView.mo")) {
			action = new MemberDeleteViewCommend();
			action.excuteQueryCommend(request, response);
			url = (String)request.getAttribute("url");
		} else if (basicURI.equals("/IdChecked.mo")) {
			action = new MemberIdCheckCommend();
			action.excuteQueryCommend(request, response);
			return;
		} else if (basicURI.equals("/MemberLogout.mo")) {
			action = new MemberLogoutCommend();
			action.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		}

		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
	}

}
