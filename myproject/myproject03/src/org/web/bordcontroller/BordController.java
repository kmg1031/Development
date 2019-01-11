package org.web.bordcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.bordcommend.*;


@WebServlet("*.bo")
public class BordController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
		
			
			
			
			String path = request.getContextPath();
			String uri = request.getRequestURI();
			String basicURI = uri.substring(path.length());

			String url = "index.jsp";
			BordQueryCommend action = null;

			if (basicURI.equals("/BordList.bo")) {
				action = new BordListCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/BordSearch.bo")) {
				action = new BordSearchCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/writeOk.bo")) {
				action = new BordWriteCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/BordDelete.bo")) {
				action = new BordDeleteCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/ListDelete.bo")) {
				url="listDelete.jsp";				
			}else if (basicURI.equals("/BordUpdate.bo")) {
				action = new BordUpdateCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/ReplyWrite.bo")) {
				action = new BordReplyWriteCommend();
				action.excuteQueryCommend(request, response);
				return;
			}else if (basicURI.equals("/BordView.bo")) {
				action = new BordViewCommend();
				action.excuteQueryCommend(request, response);
				url=(String)request.getAttribute("url");
			}else if (basicURI.equals("/Crawler.bo")) {
				action = new CrawlerCommend();
				action.excuteQueryCommend(request, response);
				url=(String)request.getAttribute("url");
			} else if (basicURI.equals("/WriteView.bo")) {
				url="write.jsp";
			
			}

			RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
			
		}
}
