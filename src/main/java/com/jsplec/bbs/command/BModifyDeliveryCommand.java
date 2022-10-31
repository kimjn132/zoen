package com.jsplec.bbs.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BCustomerDao;
import com.jsplec.bbs.dao.BDeliveryDao;

public class BModifyDeliveryCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
		int deliveryCo_id = Integer.parseInt(request.getParameter("deliveryCo_id"));
		int pId = Integer.parseInt(request.getParameter("pId"));
		String cId = request.getParameter("cId");
		int oId = Integer.parseInt(request.getParameter("oId"));
		String delivery_initdate = request.getParameter("delivery_initdate");
		String delivery_enddate = request.getParameter("delivery_enddate");
		System.out.println(delivery_id);
		System.out.println(deliveryCo_id);
		System.out.println(pId);
		System.out.println(cId);
		System.out.println(oId);
		System.out.println(delivery_initdate);
		System.out.println(delivery_enddate);
		
		BDeliveryDao dao = new BDeliveryDao();
		dao.modifyDelivery(delivery_id, deliveryCo_id, pId, cId, oId, delivery_initdate, delivery_enddate );
		
		//request.setAttribute("content_view", result);
	
	}

}
