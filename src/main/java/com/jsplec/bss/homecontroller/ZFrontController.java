package com.jsplec.bss.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsplec.bss.command.BContentCustomerCommand;
import com.jsplec.bss.command.BContentDeliveryCommand;
import com.jsplec.bss.command.BDeleteCustomerCommand;
import com.jsplec.bss.command.BDeleteDeliveryCommand;
import com.jsplec.bss.command.BInsertCustomerCommand;
import com.jsplec.bss.command.BInsertDeliveryCommand;
import com.jsplec.bss.command.BLoginCommand;
import com.jsplec.bss.command.BModifyCustomerCommand;
import com.jsplec.bss.command.BModifyDeliveryCommand;
import com.jsplec.bss.command.BProductAddCommand;
import com.jsplec.bss.command.BProductDeleteCommand;
import com.jsplec.bss.command.BProductListjCommand;
import com.jsplec.bss.command.BProductModifyCommand;
import com.jsplec.bss.command.BProductViewCommand;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		ZCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {
		case ("/list.do"):
			command = new ZProductListCommand();
			command.execute(request, response);
			viewPage = "ProductList.jsp";
			break;
		case ("/detail.do"):
			command = new ZProductDetailCommand();
			command.execute(request, response);
			viewPage = "ProductDetail.jsp";
			break;
		case ("/detailOrder.do"):
			command = new ZProductDetailCommand();
			command.execute(request, response);
			viewPage = "CustomerOrder.jsp";
			break;
		case ("/order.do"):
			command = new ZOrderCommand();
			command.execute(request, response);
			viewPage = "OrderDone.jsp";
			break;
		// 전체 내용 검색
		case ("/login.do"):
			System.out.println("doLogin");
			command = new BLoginCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;
		/*
		 * // 입력 화면 띄우기 case("/write_viewCustomer.do"):
		 * System.out.println("doViewWriteCustomer"); viewPage =
		 * "write_viewCustomer.jsp"; break;
		 */
		// 입력 하기
		case ("/insertCustomer.do"):
			System.out.println("doWriteCustomer");
			command = new BInsertCustomerCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;

		// 내용 보기
		case ("/content_viewCustomer.do"):
			System.out.println("doViewContent");
			command = new BContentCustomerCommand();
			command.execute(request, response);
			viewPage = "content_viewCustomer.jsp";
			break;

		case ("/modifyCustomer.do"):
			System.out.println("doModifyCustomer");
			command = new BModifyCustomerCommand();
			command.execute(request, response);
			viewPage = "listCustomer.do";
			break;
		case ("/deleteCustomer.do"):
			System.out.println("doDeleteCustomer");
			command = new BDeleteCustomerCommand();
			command.execute(request, response);
			viewPage = "listCustomer.do";
			break;
		// 입력 하기
		case ("/insertDelivery.do"):
			System.out.println("doInsertDelivery");
			command = new BInsertDeliveryCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;

		// 배송 내용 보기
		case ("/content_viewDelivery.do"):
			System.out.println("doViewDelivery");
			command = new BContentDeliveryCommand();
			command.execute(request, response);
			viewPage = "deliveryList.jsp";
			break;

		case ("/modifyDelivery.do"):
			System.out.println("doModifyDelivery");
			command = new BModifyDeliveryCommand();
			command.execute(request, response);
			viewPage = "listCustomer.do";
			break;
		case ("/deleteDelivery.do"):
			System.out.println("doDeleteDelivery");
			command = new BDeleteDeliveryCommand();
			command.execute(request, response);
			viewPage = "listCustomer.do";
			break;
			
		case("/productlistj.do"): 
			command = new BProductListjCommand();
			command.execute(request, response);
			viewPage = "productListj.jsp";
			break;
		
		
			case("/productadd.do"): 
			command = new BProductAddCommand();
			command.execute(request, response);
			viewPage="productlistj.do";
			break;
		
			case("/productview.do"): 
			command = new BProductViewCommand();
			command.execute(request, response);
			viewPage="productView.jsp";
			break;
		
			case("/productdelete.do"):
			command = new BProductDeleteCommand();
			command.execute(request, response);
			viewPage="productlistj.do";
			break;
		
			case("/productmodify.do"): 
			command = new BProductModifyCommand();
			command.execute(request, response);
			viewPage="productlistj.do";	
			break;

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
