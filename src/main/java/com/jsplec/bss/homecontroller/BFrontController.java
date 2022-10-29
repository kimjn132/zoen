package com.jsplec.zoen.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.zoen.command.BCommand;
import com.jsplec.zoen.command.BContentCustomerCommand;
import com.jsplec.zoen.command.BContentDeliveryCommand;
import com.jsplec.zoen.command.BDeleteCustomerCommand;
import com.jsplec.zoen.command.BDeleteDeliveryCommand;
import com.jsplec.zoen.command.BLoginCommand;
import com.jsplec.zoen.command.BModifyCustomerCommand;
import com.jsplec.zoen.command.BModifyDeliveryCommand;
import com.jsplec.zoen.command.BInsertCustomerCommand;
import com.jsplec.zoen.command.BInsertDeliveryCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println("doSwitch");				
		switch(com) {
		// 전체 내용 검색
		case("/login.do"):
			System.out.println("doLogin");
			command = new BLoginCommand();
			command.execute(request, response);
			viewPage = "Home.jsp";
			break;
	/*
		// 입력 화면 띄우기
		case("/write_viewCustomer.do"):
			System.out.println("doViewWriteCustomer");
			viewPage = "write_viewCustomer.jsp";
			break;
*/
		// 입력 하기
		case("/insertCustomer.do"):
			System.out.println("doWriteCustomer");
			command = new BInsertCustomerCommand();
			command.execute(request,response);
			viewPage = "Home.jsp";
			break;

		// 내용 보기
		case("/content_viewCustomer.do"):
			System.out.println("doViewContent");
			command = new BContentCustomerCommand();
			command.execute(request,response);
			viewPage = "content_viewCustomer.jsp";
			break;
		
		case("/modifyCustomer.do"):
			System.out.println("doModifyCustomer");
			command = new BModifyCustomerCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;					
		case("/deleteCustomer.do"):
			System.out.println("doDeleteCustomer");
			command = new BDeleteCustomerCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;			
			// 입력 하기
		case("/insertDelivery.do"):
			System.out.println("doInsertDelivery");
			command = new BInsertDeliveryCommand();
			command.execute(request,response);
			viewPage = "Home.jsp";
			break;

		// 배송 내용 보기
		case("/content_viewDelivery.do"):
			System.out.println("doViewDelivery");
			command = new BContentDeliveryCommand();
			command.execute(request,response);
			viewPage = "deliveryList.jsp";
			break;
		
		case("/modifyDelivery.do"):
			System.out.println("doModifyDelivery");
			command = new BModifyDeliveryCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;					
		case("/deleteDelivery.do"):
			System.out.println("doDeleteDelivery");
			command = new BDeleteDeliveryCommand();
			command.execute(request,response);
			viewPage = "listCustomer.do";
			break;			
			

		} // switch
		
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}

	
} // ----

