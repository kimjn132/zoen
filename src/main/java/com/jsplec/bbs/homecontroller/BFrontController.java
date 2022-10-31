package com.jsplec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.command.BCommand;
import com.jsplec.bbs.command.BModifyCommand;
import com.jsplec.bbs.command.BProductdeleteCommand;
import com.jsplec.bbs.command.BProductmodifyCommand;
import com.jsplec.bbs.command.BProductAddCommand;
import com.jsplec.bbs.command.BProductListCommand;
import com.jsplec.bbs.command.BProductViewCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do") //do로 쓰여지는 것은 다 여기로 오게하는 역할
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
//		System.out.println(uri); 
		
		String conPath = request.getContextPath();
//		System.out.println(conPath); 
		
		String com = uri.substring(conPath.length());
//		System.out.println(com); 
		
		switch(com) {			
		
		case("/productlistj.do"): 
			command = new BProductListCommand();
			command.execute(request, response);
			viewPage = "productListj.jsp";
			break;
		
		
			//입력하기
		case("/productadd.do"): 
		command = new BProductAddCommand();
		command.execute(request, response);
		viewPage="productlistj.do";
		break;
		
		//내용보기
		case("/productview.do"): 
		command = new BProductViewCommand();
		command.execute(request, response);
		viewPage="productView.jsp";
		break;
		
		case("/productdelete.do"):
		command = new BProductdeleteCommand();
		command.execute(request, response);
		viewPage="productlistj.do";
		break;
		
		case("/productmodify.do"): 
		command = new BProductmodifyCommand();
		command.execute(request, response);
		viewPage="productlistj.do";
		break;
				
		}
		
		
		
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
}