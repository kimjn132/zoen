package com.jsplec.bss.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.ZDao;
import com.jsplec.bss.dto.ZDto;

public class ZProductListCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ZDao dao = new ZDao();
		ArrayList<ZDto> dtos = dao.List();
		request.setAttribute("list", dtos);
		
		
		
	}

}
