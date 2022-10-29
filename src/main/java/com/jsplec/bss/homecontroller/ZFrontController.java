package com.jsplec.bss.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsplec.bss.command.ZCommand;
import com.jsplec.bss.command.ZCustomerCommand;
import com.jsplec.bss.command.ZOrderCommand;
import com.jsplec.bss.command.ZProductDetailCommand;
import com.jsplec.bss.command.ZProductListCommand;

/**
 * Servlet implementation class ZFrontController
 */
@WebServlet("*.do")
public class ZFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZFrontController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		actionDo(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		ZCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
			
		switch(com) {
		case("/list.do"):
			command = new ZProductListCommand();
			command.execute(request, response);
			viewPage = "ProductList.jsp";
			break;
		case("/detail.do"):
			command = new ZProductDetailCommand();
			command.execute(request, response);
			viewPage = "ProductDetail.jsp";
			break;
		case("/detailOrder.do"):
			command = new ZProductDetailCommand();
			command.execute(request, response);
			viewPage = "CustomerOrder.jsp";
			break;
	
//		case("/order.do"):
//			
//			command = new ZOrderCommand();
//			command.execute(request,response);
//			viewPage = "OrderDone.jsp";
//			break;
				
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);

}
}
