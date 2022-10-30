package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bss.dao.BCustomerDao;
import com.jsplec.bss.dto.BCustomerDto;

public class BLoginCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		
		BCustomerDao dao = new BCustomerDao();
		if(dao.login(cId,cPw)) {
		
			HttpSession session = request.getSession();
			session.setAttribute("cId", cId);
			//session.setAttribute("", session);
		}

		//request.setAttribute("content_view", result);
		
	}

}
