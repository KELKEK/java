package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingDataScopeServlet
 */
@WebServlet("/jsp/binding.do")
public class BindingDataScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BindingDataScopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//3가지 scope
		//1)application영역에 저장 : 서버가 stop될 때까지 유효, 모든 Servlet, JSP사용 가능
		ServletContext app = request.getServletContext();
		app.setAttribute("appData", request.getParameter("myname"));
		//2)session영역에 저장 : 하나의 Browser(한 사람이 이 사이트로 온 것), 브라우저를 이용해서 이동되는 모든 페이지에서 접근가능, Browser 종료 시 제거
		HttpSession session = request.getSession();
		session.setAttribute("sessionData", request.getParameter("myname"));
		//3)request영역에 저장
		request.setAttribute("requestData", request.getParameter("myname"));
		
		request.getRequestDispatcher("binding.jsp").forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
