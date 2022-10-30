package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.DDao;

public class DModifyCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String deliveryCo_name = request.getParameter("deliveryCo_name");
		String deliveryCo_phone = request.getParameter("deliveryCo_phone");
		String deliveryCo_email = request.getParameter("deliveryCo_email");
		int deliveryCo_id = Integer.parseInt(request.getParameter("deliveryCo_id"));
		
		System.out.println(deliveryCo_id);
		System.out.println("모디파이커맨드");
		
		
		DDao dao = new DDao();
		dao.deleveryCo_modify(deliveryCo_name, deliveryCo_phone, deliveryCo_email,deliveryCo_id);
		
	
	
	}	

}
