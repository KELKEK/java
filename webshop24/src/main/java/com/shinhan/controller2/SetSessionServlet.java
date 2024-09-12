package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/jsp/setSession")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //request.getSession(true)
		System.out.println("신규? : " + session.isNew());
		System.out.println("생성시각? : " + session.getCreationTime());
		System.out.println("유효한시간? : " + session.getMaxInactiveInterval());
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		session.setAttribute("memberid", id);
		session.setAttribute("memberpass", pass);
	}


}
