
package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsplec.bbs.dao.BDeliveryDao;


public class BDeleteDeliveryCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
		BDeliveryDao dao = new BDeliveryDao();
		dao.deleteDelivery(delivery_id);
		
		
	}

}
