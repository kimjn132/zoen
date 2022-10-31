package com.jsplec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsplec.bbs.command.BContentCustomerCommand;
import com.jsplec.bbs.command.BContentDeliveryCommand;
import com.jsplec.bbs.command.BDeleteCustomerCommand;
import com.jsplec.bbs.command.BDeleteDeliveryCommand;
import com.jsplec.bbs.command.BInsertCustomerCommand;
import com.jsplec.bbs.command.BInsertDeliveryCommand;
import com.jsplec.bbs.command.BLoginCommand;
import com.jsplec.bbs.command.BModifyCustomerCommand;
import com.jsplec.bbs.command.BModifyDeliveryCommand;
import com.jsplec.bbs.command.ZCommand;
import com.jsplec.bbs.command.ZCustomerCommand;
import com.jsplec.bbs.command.ZOrderCommand;
import com.jsplec.bbs.command.ZOrderRecentView;
import com.jsplec.bbs.command.ZProductDetailCommand;
import com.jsplec.bbs.command.ZProductListCommand;

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
		case ("/login.do"):
			command = new BLoginCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
		case ("/list.do"):
			command = new ZProductListCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
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
//		case ("/orderRecentView.do"):
//			command = new ZOrderCommand();
//			command.execute(request, response);
//			viewPage = "OrderDone.jsp";
//			break;
		
			
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

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
