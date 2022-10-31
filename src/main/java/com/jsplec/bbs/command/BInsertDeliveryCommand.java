package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BCustomerDao;
import com.jsplec.bbs.dao.BDeliveryDao;

public class BInsertDeliveryCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int deliveryCo_id = Integer.parseInt(request.getParameter("deliveryCo_id"));
		int pId = Integer.parseInt(request.getParameter("pId"));
		String cId = request.getParameter("cId");
		int oId = Integer.parseInt(request.getParameter("oId"));
		
		BDeliveryDao dao = new BDeliveryDao();
		dao.write(deliveryCo_id,pId,cId,oId);
	
	}

}
