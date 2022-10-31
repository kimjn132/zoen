package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.BProductDao;

public class BProductDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BProductDao dao = new BProductDao();
		dao.productdelete(request.getParameter("pId"));
		
		System.out.println("딜리트커맨드");
		
	}

}
