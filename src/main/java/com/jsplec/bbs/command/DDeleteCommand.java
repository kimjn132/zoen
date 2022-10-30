package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.DDao;

public class DDeleteCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		DDao dao = new DDao();
		dao.deliveryCo_delete(request.getParameter("deliveryCo_id"));
		
		System.out.println("dlwflqqwffqw341");
	
	
	
	}

}
