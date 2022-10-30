package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.SDao;
import com.jsplec.bbs.dto.SDto;

public class SContentCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String ssId = request.getParameter("sId");
		SDao dao = new SDao();
		SDto dto = dao.supplierContentView(ssId);
		
		request.setAttribute("supplier_content_view", dto);
	}

}
