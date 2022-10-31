package com.jsplec.bss.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.BProductDao;
import com.jsplec.bss.dto.BProductDto;

public class BProductListjCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			BProductDao dao = new BProductDao();
			ArrayList<BProductDto> dtos = dao.productlist();
			request.setAttribute("productlist", dtos);

	}

}
