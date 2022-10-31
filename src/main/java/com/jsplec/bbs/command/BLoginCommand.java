package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.BCustomerDao;
import com.jsplec.bbs.dto.BCustomerDto;

public class BLoginCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		
		BCustomerDao dao = new BCustomerDao();
		HttpSession session = request.getSession();
		if(dao.login(cId,cPw)) {
			session.setAttribute("cId", cId);
			//session.setAttribute("", session);
		}else {
			session.setAttribute("cId", "error");			
		}

		//request.setAttribute("content_view", result);
		
	}

}
