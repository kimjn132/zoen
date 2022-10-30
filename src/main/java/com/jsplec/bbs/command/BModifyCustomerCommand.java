package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BCustomerDao;

public class BModifyCustomerCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		String cAddress = request.getParameter("cAddress");
		String cEmail = request.getParameter("cEmail");
		String cPhone = request.getParameter("cPhone");
		
		BCustomerDao dao = new BCustomerDao();
		dao.modifyCustomer(cId,cPw,cAddress,cEmail, cPhone);
		
		//request.setAttribute("content_view", result);
	
	}

}
