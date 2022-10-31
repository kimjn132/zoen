package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.ZDao;
import com.jsplec.bbs.dto.ZDto;

public class ZProductListCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ZDao dao = new ZDao();
		ArrayList<ZDto> dtos = dao.List();
		request.setAttribute("list", dtos);
		
		
		
	}

}
