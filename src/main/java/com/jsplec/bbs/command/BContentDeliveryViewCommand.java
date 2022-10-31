package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDeliveryDao;
import com.jsplec.bbs.dto.BDeliveryDto;

public class BContentDeliveryViewCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//HttpSession session=request.getSession();
		//String cId = (String)session.getAttribute("cId");
		System.out.println("delivery_id :"+request.getParameter("delivery_id")+":");
		int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
		System.out.println("delivery_id :"+delivery_id+":");
		BDeliveryDao dao = new BDeliveryDao();
		//BDeliveryDto dto = dao.contentDeliveryView(cId);
		BDeliveryDto dto = dao.contentDeliveryViewId(delivery_id);
		System.out.println(dto.getDelivery_id());
		System.out.println(dto.getDeliveryCo_id());
		System.out.println(dto.getpId());
		System.out.println(dto.getcId());
		System.out.println(dto.getoId());
		System.out.println(dto.getDelivery_initdate());
		System.out.println(dto.getDelivery_enddate());
		
		request.setAttribute("deliveryid", dto);
		
	}

}
