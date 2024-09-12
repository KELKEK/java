package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeServlet
 */
// /jsp/scope <- URL패턴은 가상의 이름, 실제로 없는 경로여도 괜찮
@WebServlet("/jsp/scope")
//@WebServlet("/jsp/scope/*")
//@WebServlet("/*.go")
//@WebServlet("/*")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		request.setAttribute("mydata", 100);
		session.setAttribute("mydata", 200);
		application.setAttribute("mydata", 300);
		
		request.setAttribute("myage1", 10);
		session.setAttribute("myage2", 20);
		application.setAttribute("myage3", 30);
		
		//실제로 있는 경로
		//3번쨰로 쓴 URL패턴의 경우에는 위임되는 주소를 상대경로가 아닌 절대경로로 쓰는게 나음
		String path = getServletContext().getContextPath();
		System.out.println(path); // /webshop24
//		request.getRequestDispatcher(path + "/jsp/scope.jsp").forward(request, response);
		request.getRequestDispatcher("scope.jsp").forward(request, response);
		//서블릿의 default경로는 http://localhost:9090/webshop24
		//JSP, HTML, default경로는 http://localhost:9090
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
