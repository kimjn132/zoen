package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.ZDao;

public class ZOrderCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		int pId = Integer.parseInt(request.getParameter("pId"));
		
		
		ZDao dao = new ZDao();
		//dao.order(cId, pId);
	}

}
