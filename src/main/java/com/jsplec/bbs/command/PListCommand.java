package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.PDao;
import com.jsplec.bbs.dto.PDto;

public class PListCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PDao dao = new PDao();
		ArrayList<PDto> dtos = dao.productListCheck();
		request.setAttribute("product_list_check", dtos);
	}

}
