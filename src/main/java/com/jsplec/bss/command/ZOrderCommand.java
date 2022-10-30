package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bss.dao.ZDao;

public class ZOrderCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession();
		String cId = (String)session.getAttribute("CID");
		String pId = (String)session.getAttribute("PID");

		String oPayment = request.getParameter("oPayment");
		

		
		
		ZDao dao = new ZDao();
		
		dao.order(cId, pId, oPayment);
	}

}
