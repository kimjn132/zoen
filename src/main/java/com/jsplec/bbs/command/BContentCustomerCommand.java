package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.BCustomerDao;
import com.jsplec.bbs.dto.BCustomerDto;

public class BContentCustomerCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		String cId = (String)session.getAttribute("CID");
		BCustomerDao dao = new BCustomerDao();
		BCustomerDto dto = dao.contentCustomerView(cId);
		
		request.setAttribute("content_view", dto);
		
	}

}
