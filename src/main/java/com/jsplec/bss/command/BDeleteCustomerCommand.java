package com.jsplec.zoen.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.zoen.dao.BCustomerDao;

public class BDeleteCustomerCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		BCustomerDao dao = new BCustomerDao();
		dao.deleteCustomer(cId);
		
		
	}

}
