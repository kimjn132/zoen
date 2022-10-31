package com.jsplec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.bbs.command.BContentCustomerCommand;
import com.jsplec.bbs.command.BContentDeliveryCommand;
import com.jsplec.bbs.command.BContentDeliveryViewCommand;
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
			HttpSession session = request.getSession();
			System.out.println("cId is :"+session.getAttribute("cId")+":");
			if(session.getAttribute("cId").equals("admin")) {
				System.out.println("viewPage is :manager_page.jsp:");
				viewPage = "manager_page.jsp";
			} else if(!session.getAttribute("cId").equals("error")) { 
				System.out.println("viewPage is :Home.jsp:");				
				viewPage = "Home.jsp";
			}else if(session.getAttribute("cId").equals("admin")) {
				System.out.println("viewPage is :manager_page.jsp:");				
				viewPage = "manager_page.jsp";
			}
			else {
				System.out.println("viewPage is :WrongID.jsp:");
				System.out.println("cId is :"+session.getAttribute("cId")+":");
				viewPage = "WrongID.jsp";
			}
			break;

			// 입력 화면 띄우기(안씀)
		case("/write_viewCustomer.do"):
			System.out.println("doViewWriteCustomer");
			viewPage = "write_viewCustomer.jsp";
			break;

			// 고객 가입하기
		case("/insertCustomer.do"):
			System.out.println("doWriteCustomer");
			command = new BInsertCustomerCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;

			// 고객 List 안씀
		case("/content_viewCustomer.do"):
			System.out.println("doViewContent");
			command = new BContentCustomerCommand();
			command.execute(request,response);
			viewPage = "content_viewCustomer.jsp";
			break;
			// 고객 정보 수정 안씀
		case("/modifyCustomer.do"):
			System.out.println("doModifyCustomer");
			command = new BModifyCustomerCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;
			// 고객 정보 삭제(enddate 추가)
		case("/deleteCustomer.do"):
			System.out.println("doDeleteCustomer");
			command = new BDeleteCustomerCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;			
			// 배송 입력 하기 ( Order 생성 시 추가되어야 함.)
		case("/insertDelivery.do"):
			System.out.println("doInsertDelivery");
			command = new BInsertDeliveryCommand();
			command.execute(request,response);
			// 뷰 화면 추가 해야함.
			viewPage = "Home.jsp";
			break;
			// 배송 List 보기
		case("/content_viewDelivery.do"):
			System.out.println("doViewDelivery");
			command = new BContentDeliveryCommand();
			command.execute(request,response);
			viewPage = "deliveryList.jsp";
			break;
			// 배송ID 내용 보기
		case("/content_viewDeliveryId.do"):
			System.out.println("doContentViewDeliveryId");
			command = new BContentDeliveryViewCommand();
			command.execute(request,response);
			viewPage = "modifyDelivery.jsp";
			break;
			// 배송 수정하기
		case("/ModifyDelivery.do"):
			System.out.println("doModifyDelivery");
			command = new BModifyDeliveryCommand();
			command.execute(request,response);
			viewPage = "content_viewDelivery.do";
			break;
			// 배송 삭제하기			
		case("/deleteDelivery.do"):
			System.out.println("doDeleteDelivery");
			command = new BDeleteDeliveryCommand();
			command.execute(request,response);
			viewPage = "content_viewDelivery.do";
			break;			
			

		} // switch
		
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}

	
} // ----

