package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDAO;
import org.web.borddto.BordDTO;


public class BordSearchCommend implements BordQueryCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("list");
		
		String keyWord=request.getParameter("keyWord");
		
		BordDAO dao= BordDAO.getInstance();
		
		ArrayList<BordDTO> list = new ArrayList<BordDTO>();
		
		list=dao.search(keyWord);
	
		String data = getJSON(list);
		
		PrintWriter out = response.getWriter();
		out.write(data);
		out.close();
		
	}
	
	private String getJSON(ArrayList<BordDTO> list) {
		StringBuffer data = new StringBuffer();
			
		data.append("{'result':[");
		
		for(BordDTO dto:list) {
		
			data.append("{'value':'"+dto.getName()+"'},");
			data.append("{'value':'"+dto.getTitle()+"'},");
			data.append("{'value':'"+dto.getMemo()+"'},");
		
		}
		
		data.append("]}");
		
		return data.toString();
	}
}
