package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BProductDao;
import com.jsplec.bbs.dto.BProductDto;

public class BProductViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BProductDao dao = new BProductDao();
		String pId = request.getParameter("pId");
		BProductDto dto = dao.productView(pId);
		
		System.out.println("프로덕트뷰커맨드");
		System.out.println(pId);
		
		request.setAttribute("productview", dto);
		
		
	}

}
