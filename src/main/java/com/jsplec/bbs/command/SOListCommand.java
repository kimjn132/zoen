package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.component.SOrderList;
import com.jsplec.bbs.dao.SODao;

public class SOListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SODao sodao = new SODao();
		ArrayList<SOrderList>dtos = sodao.sOrderList();
		request.setAttribute("sorder_list", dtos);
		
		
	}

}
