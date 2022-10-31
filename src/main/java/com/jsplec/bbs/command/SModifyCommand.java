package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.SDao;
import com.jsplec.bbs.dto.SDto;

public class SModifyCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String sId = request.getParameter("sId");
		int isId = Integer.parseInt(sId);
		String newsName = request.getParameter("sName");
		String newsPhone = request.getParameter("sPhone");
		String newsEmail = request.getParameter("sEmail");
		SDto dto = new SDto(isId, newsName, newsPhone, newsEmail);
		SDao dao = new SDao();
		dao.supplierModify(dto);
	}

}
