package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.ZDao;
import com.jsplec.bbs.dto.ZDto;

public class ZOrderCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("CID");
		String pId = (String)session.getAttribute("PID");
		String oPayment = request.getParameter("oPayment");
		
		ZDao dao = new ZDao();
		
		dao.order(cId, pId, oPayment);
		
		
		
		
		
//		HttpSession session = request.getSession()
//		String pId = (String)session.getAttribute("PID");

		ZDao dao1 = new ZDao();
		ZDto dto = dao1.orderRecentView(cId);
		
		request.setAttribute("orderRecentView", dto);
		
	}

}
