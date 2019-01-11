package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDAO;
import org.web.borddto.BordDTO;


public class BordWriteCommend implements BordQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("write");
	/*		
		
		
		String mGroup=request.getParameter("mGroup");
		String nicName=request.getParameter("nicName");
		String title=request.getParameter("title");
		String memo=request.getParameter("memo");
		
			
			
		BordDAO dao=BordDAO.getInstance();
		
		
		if(mGroup==null) {
		
		int result=dao.write(nicName,title,memo);
		
		}
		
		response.sendRedirect("BordList.bo");
	*/		
		
	}
}
