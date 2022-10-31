package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jsplec.bbs.dao.DDao;
import com.jsplec.bbs.dto.DDto;

public class DContentCommand implements DCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String deliveryCo_id = request.getParameter("deliveryCo_id");
		DDao dao = new DDao();
		DDto dto = dao.deliveryCo_contentView(deliveryCo_id);
		
		request.setAttribute("deliveryCo_contentView", dto);
	}
}
