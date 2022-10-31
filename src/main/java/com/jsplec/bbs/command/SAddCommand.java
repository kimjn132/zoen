package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.SDao;

public class SAddCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sName = request.getParameter("sName");
		String sPhone = request.getParameter("sPhone");
		String sEmail = request.getParameter("sEmail");
		
		SDao dao = new SDao();
		dao.addSupplier(sName, sPhone, sEmail);
		
		
		
	}

}
