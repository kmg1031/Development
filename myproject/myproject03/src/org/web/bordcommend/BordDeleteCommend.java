package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDAO;
import org.web.borddto.BordDTO;


public class BordDeleteCommend implements BordQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			System.out.println("delete");
			
		int mId=Integer.parseInt(request.getParameter("mId"));
		
		BordDAO dao=BordDAO.getInstance();
		
		int result=dao.delete(mId);
		
		PrintWriter out=response.getWriter();
		out.write(result+"");
		
		out.close();
		
	}
}
