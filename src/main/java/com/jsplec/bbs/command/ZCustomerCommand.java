package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.ZDao;
import com.jsplec.bbs.dto.ZDto;

public class ZCustomerCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		//String cId = request.getParameter("cId");
		String cId = (String)session.getAttribute("CID");
		
		ZDao dao = new ZDao();
		ZDto dto = dao.customer(cId);
		
		request.setAttribute("customer", dto);

	}

}
