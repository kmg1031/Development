package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDAO;
import org.web.borddto.BordDTO;


public class BordReplyWriteCommend implements BordQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	System.out.println("replyWrite");
			
		String mId=request.getParameter("mId");
		String mGroup=request.getParameter("mGroup");
		String step=request.getParameter("step");
		String indent=request.getParameter("indent");
		String nicName=request.getParameter("nicName");
		String title=request.getParameter("title");
		String memo=request.getParameter("memo");
		
		BordDAO dao=BordDAO.getInstance();
		
		int result=dao.reply(mId, mGroup, step, indent, nicName, title, memo);
		
		PrintWriter out=response.getWriter();
		out.write(result+"");
		
		out.close();
		
	*/	
	}
}
