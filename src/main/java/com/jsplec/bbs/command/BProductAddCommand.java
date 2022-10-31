
package com.jsplec.bbs.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsplec.bbs.dao.BProductDao;


public class BProductAddCommand implements ZCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String pName = request.getParameter("pName");
		String pColor = request.getParameter("pColor");
		String pSize = request.getParameter("pSize");
		String pDetail = request.getParameter("pDetail");
		int pSalePrice = Integer.parseInt(request.getParameter("pSaleprice"));
		String pCategory = request.getParameter("pCategory");
		String pBrand = request.getParameter("pBrand");
		int pStock = Integer.parseInt(request.getParameter("pStock"));
		
		BProductDao dao = new BProductDao();
		dao.productadd(pName, pColor, pSize, pDetail, pSalePrice, pCategory, pBrand, pStock);
		
		
	}

}
