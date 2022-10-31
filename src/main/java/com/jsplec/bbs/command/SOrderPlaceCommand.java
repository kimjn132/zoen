package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.component.SOrderPlace;
import com.jsplec.bbs.dao.SDao;
import com.jsplec.bbs.dao.SODao;

public class SOrderPlaceCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String soProduct_pId = request.getParameter("soProduct_pId");
		String pBrand = request.getParameter("pBrand");
		String soQuantity = request.getParameter("soQuantity");
		
		SDao sDao = new SDao();
		int isId = sDao.getSupplierId(pBrand);
		int isoProduct_pId = Integer.parseInt(soProduct_pId);
		int isoQuantity = Integer.parseInt(soQuantity);
		
		SODao soDao = new SODao();
		soDao.sOrderPlace(isId, isoProduct_pId, isoQuantity);
		
	}

}
