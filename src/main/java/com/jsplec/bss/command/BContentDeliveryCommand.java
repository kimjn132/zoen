package com.jsplec.zoen.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.zoen.dao.BDeliveryDao;
import com.jsplec.zoen.dto.BDeliveryDto;

public class BContentDeliveryCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String cId = (String)session.getAttribute("cId");
		//String delivery_id = request.getParameter("delivery_id");
		BDeliveryDao dao = new BDeliveryDao();
		//BDeliveryDto dto = dao.contentDeliveryView(cId);
		ArrayList<BDeliveryDto> dtos = dao.contentDeliveryView(cId);
		
		request.setAttribute("delivery_list", dtos);
		
	}

}
