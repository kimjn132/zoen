package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.BCustomerDao;
import com.jsplec.bss.dto.BCustomerDto;

public class BContentCustomerCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		BCustomerDao dao = new BCustomerDao();
		BCustomerDto dto = dao.contentCustomerView(cId);
		
		request.setAttribute("content_view", dto);
		
	}

}
