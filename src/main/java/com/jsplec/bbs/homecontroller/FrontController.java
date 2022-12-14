package com.jsplec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.command.PCommand;
import com.jsplec.bbs.command.PListCommand;
import com.jsplec.bbs.command.SAddCommand;
import com.jsplec.bbs.command.SCommand;
import com.jsplec.bbs.command.SContentCommand;
import com.jsplec.bbs.command.SDeleteCommand;
import com.jsplec.bbs.command.SListCommand;
import com.jsplec.bbs.command.SModifyCommand;
import com.jsplec.bbs.command.SOListCommand;
import com.jsplec.bbs.command.SOSListCommand;
import com.jsplec.bbs.command.SOrderPlaceCommand;



/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		SCommand command = null;
		PCommand pcommand = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch(com) {
		// -----------------------------------???????????? ?????? ?????????---------------------------------
		// ?????? ?????? ??????
			case("/supplier_list.do"):
			command = new SListCommand();
			command.execute(request, response);
			viewPage = "supplier_list.jsp";
			break;
		// ???????????? ?????? ?????? ?????????
		case("/supplier_content_view.do"):
			command = new SContentCommand();
			command.execute(request, response);
			viewPage = "supplier_content_view.jsp";
			break;
			
		// ?????? ?????? ?????? ?????????
		case("/supplier_add_view.do"):
			viewPage = "supplier_add_view.jsp";
			break;
			
		// ????????????
		case("/supplier_add.do"):
			command = new SAddCommand();
			command.execute(request, response);
			viewPage = "supplier_list.do";
			break;

		case("/supplier_modify.do"):
			command = new SModifyCommand();
			command.execute(request, response);
			viewPage = "supplier_list.do";
			break;
			
		case("/supplier_delete.do"):
			command = new SDeleteCommand();
			command.execute(request, response);
			viewPage = "supplier_list.do";
			break;
		// ---------------------------------?????? ???????????????----------------------------------------
		case ("/sorder_main.do"):
			command = new SOListCommand();
			command.execute(request, response);
			viewPage = "sorder_main.jsp";
			break;
			
		case ("/available_supplier.do"):
			command = new SOSListCommand();
			command.execute(request, response);
			viewPage = "available_supplier.jsp";
		break;
		
		case ("/sorder_place_view.do"):
			pcommand = new PListCommand();
			pcommand.execute(request, response);
			viewPage = "sorder_place.jsp";
			break;
			
		case ("/sorder_place.do"):
			command = new SOrderPlaceCommand();
			command.execute(request, response);
			viewPage = "sorder_main.do";
			break;
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
	
}	// -----------------------------------
