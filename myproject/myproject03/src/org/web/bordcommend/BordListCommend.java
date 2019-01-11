package org.web.bordcommend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.borddao.BordDAO;
import org.web.borddto.BordDTO;

public class BordListCommend implements BordQueryCommend{
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("list");
			
		BordDAO dao=BordDAO.getInstance();
			
		int page=1;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int eNum=10;
		int sNum=(page-1)*eNum;
		int listSize=dao.listSize();
		int pageSize=(listSize-1)/eNum+1;
		pageSize=pageSize==0?1:pageSize;
		
		ArrayList<BordDTO> list=new ArrayList<>();
		list=dao.paging(sNum, eNum);
		
		int sPage=(page-1)/10*10+1;
		int ePage=(sPage+9)<pageSize?(sPage+9):pageSize;
		HttpSession session=request.getSession();
		
		session.setAttribute("list", list);
		session.setAttribute("pageSize",pageSize);
		session.setAttribute("pageNum",page);
		session.setAttribute("sPage",sPage);
		session.setAttribute("ePage",ePage);
		
		
	}
}
