package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BProductDao;

public class BProductdeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BProductDao dao = new BProductDao();
		dao.productdelete(request.getParameter("pId"));
		
		System.out.println("딜리트커맨드");
		
	}

}
