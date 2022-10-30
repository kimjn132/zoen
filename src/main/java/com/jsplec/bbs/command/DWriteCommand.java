package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.DDao;

public class DWriteCommand implements DCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	
		String deliveryCo_name = request.getParameter("deliveryCo_name");
		String deliveryCo_phone = request.getParameter("deliveryCo_phone");
		String deliveryCo_email = request.getParameter("deliveryCo_email");
		
		System.out.println(deliveryCo_name);
		System.out.println(deliveryCo_phone);
		System.out.println(deliveryCo_email);
		
		DDao dao = new DDao();
		dao.deliveryCo_write(deliveryCo_name, deliveryCo_phone, deliveryCo_email);
		
		
		
		
	
	
	}

}
