package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bss.dao.ZDao;
import com.jsplec.bss.dto.ZDto;

public class ZCustomerCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		//String cId = request.getParameter("cId");
		String cId = (String)session.getAttribute("cId");
		System.out.println("cId : "+cId);
		ZDao dao = new ZDao();
		ZDto dto = dao.customer();
		
		request.setAttribute("customer", dto);

	}

}
