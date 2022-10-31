package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.dao.ZDao;
import com.jsplec.bbs.dto.ZDto;

public class ZOrderRecentView implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String pId = (String)session.getAttribute("PID");

		ZDao dao = new ZDao();
		ZDto dto = dao.orderRecentView(pId);
		
		request.setAttribute("orderRecentView", dto);

	}

}
