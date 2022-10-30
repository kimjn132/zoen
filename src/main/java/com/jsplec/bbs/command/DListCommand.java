package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.DDao;
import com.jsplec.bbs.dto.DDto;

public class DListCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DDao dao = new DDao();
		ArrayList<DDto> dtos = dao.deliveryCo_list();
		request.setAttribute("deliveryCo_list", dtos);
		
	}

}
