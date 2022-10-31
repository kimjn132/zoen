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

//import com.jsplec.bbs.command.DContentCommand;
//import com.jsplec.bbs.command.DDeleteCommand;
//import com.jsplec.bbs.command.DListCommand;
//import com.jsplec.bbs.command.DModifyCommand;
//import com.jsplec.bbs.command.DWriteCommand;
//
//import com.jsplec.bbs.command.BProductAddCommand;
//import com.jsplec.bbs.command.BProductDeleteCommand;
//import com.jsplec.bbs.command.BProductListjCommand;
//import com.jsplec.bbs.command.BProductModifyCommand;
//import com.jsplec.bbs.command.BProductViewCommand;


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

		//주현---------
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

      
//주현------------


////상혁 --------------
//		/*
//		 * // 입력 화면 띄우기 case("/write_viewCustomer.do"):
//		 * System.out.println("doViewWriteCustomer"); viewPage =
//		 * "write_viewCustomer.jsp"; break;
//		 */
//
//		// 입력 하기
//		case ("/insertCustomer.do"):
//			System.out.println("doWriteCustomer");
//			command = new BInsertCustomerCommand();
//			command.execute(request, response);
//			viewPage = "Home.jsp";
//			break;
//
//		// 내용 보기
//		case ("/content_viewCustomer.do"):
//			System.out.println("doViewContent");
//			command = new BContentCustomerCommand();
//			command.execute(request, response);
//			viewPage = "content_viewCustomer.jsp";
//			break;
//
//		case ("/modifyCustomer.do"):
//			System.out.println("doModifyCustomer");
//			command = new BModifyCustomerCommand();
//			command.execute(request, response);
//			viewPage = "listCustomer.do";
//			break;
//		case ("/deleteCustomer.do"):
//			System.out.println("doDeleteCustomer");
//			command = new BDeleteCustomerCommand();
//			command.execute(request, response);
//			viewPage = "listCustomer.do";
//			break;
//		// 입력 하기
//		case ("/insertDelivery.do"):
//			System.out.println("doInsertDelivery");
//			command = new BInsertDeliveryCommand();
//			command.execute(request, response);
//			viewPage = "Home.jsp";
//			break;
//
//		// 배송 내용 보기
//		case ("/content_viewDelivery.do"):
//			System.out.println("doViewDelivery");
//			command = new BContentDeliveryCommand();
//			command.execute(request, response);
//			viewPage = "deliveryList.jsp";
//			break;
//
//		case ("/modifyDelivery.do"):
//			System.out.println("doModifyDelivery");
//			command = new BModifyDeliveryCommand();
//			command.execute(request, response);
//			viewPage = "listCustomer.do";
//			break;
//		case ("/deleteDelivery.do"):
//			System.out.println("doDeleteDelivery");
//			command = new BDeleteDeliveryCommand();
//			command.execute(request, response);
//			viewPage = "listCustomer.do";
//			break;
//      
// //상혁----------
//
//		//상준	-------
//		case("/productlistj.do"): 
//			command = new BProductListjCommand();
//			command.execute(request, response);
//			viewPage = "productListj.jsp";
//			break;
//		
//		
//			case("/productadd.do"): 
//			command = new BProductAddCommand();
//			command.execute(request, response);
//			viewPage="productlistj.do";
//			break;
//		
//			case("/productview.do"): 
//			command = new BProductViewCommand();
//			command.execute(request, response);
//			viewPage="productView.jsp";
//			break;
//		
//			case("/productdelete.do"):
//			command = new BProductDeleteCommand();
//			command.execute(request, response);
//			viewPage="productlistj.do";
//			break;
//		
//			case("/productmodify.do"): 
//			command = new BProductModifyCommand();
//			command.execute(request, response);
//			viewPage="productlistj.do";	
//			break;
////상준-------
//		
//			
//			
//			
//			//성연-------
//		case("/deliveryCo_list.do"):
//			command = new DListCommand();
//			command.execute(request, response);
//			viewPage = "deliveryCo_list.jsp";
//			break;
//		
//		//배송업체 등록 화면 띄우기
//		case("/deliveryCo_writeView.do"):
//			viewPage = "deliveryCo_writeView.jsp";
//			break;
//			
//		//등록 완료 화면 띄우기
//		case("/deliveryCo_registrationView.do"):
//			viewPage = "deliveryCo_registrationView.jsp";
//			break;
//			
//		//입력하기
//		case("/deliveryCo_write.do"): 
//			command = new DWriteCommand();
//			command.execute(request, response);
//			viewPage="deliveryCo_registrationView.do";
//			//viewPage="deliveryCo_list.do";
//			break;
//			
//		//내용보기
//		case("/deliveryCo_contentView.do"): 
//			command = new DContentCommand();
//			command.execute(request, response);
//			viewPage="deliveryCo_contentView.jsp";
//			break;
//			
//		//삭제하기
//		case("/deliveryCo_delete.do"): 
//			command = new DDeleteCommand();
//			command.execute(request, response);
//			viewPage="deliveryCo_list.do";
//			break;
//		
//		//수정하기
//		case("/deliveryCo_modify.do"): 
//			command = new DModifyCommand();
//			command.execute(request, response);
//			viewPage="deliveryCo_list.do";
//			break;
////성연 end --------------
//			
//			
			


		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
