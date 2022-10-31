package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bss.dao.BProductDao;

public class BProductModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pName = request.getParameter("pName");
		String pColor = request.getParameter("pColor");
		String pSize = request.getParameter("pSize");
		String pBrand = request.getParameter("pBrand");
		int pSaleprice = Integer.parseInt(request.getParameter("pSaleprice"));
		String pDetail = request.getParameter("pDetail");
		int pStock = Integer.parseInt(request.getParameter("pStock"));
		int pId = Integer.parseInt(request.getParameter("pId"));
		
		System.out.println("모디파이커멘ㄷ");
		System.out.println(pName);
		
		BProductDao dao = new BProductDao();
		dao.productmodify(pName, pColor, pSize, pBrand, pSaleprice, pDetail, pStock, pId);
	}

}
