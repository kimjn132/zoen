package com.jsplec.zoen.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.zoen.dao.BDeliveryDao;

public class BDeleteDeliveryCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
		BDeliveryDao dao = new BDeliveryDao();
		dao.deleteDelivery(delivery_id);
		
		
	}

}
