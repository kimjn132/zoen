package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BProductDao;
import com.jsplec.bbs.dto.BProductDto;

public class BProductListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			BProductDao dao = new BProductDao();
			ArrayList<BProductDto> dtos = dao.productlist();
			request.setAttribute("productlist", dtos);

	}

}
