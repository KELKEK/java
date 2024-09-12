package com.shinhan.controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingSetServlt
 */
@WebServlet("/jsp/set")
public class BindingSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("================setting===========");
		String myname= request.getParameter("myname");
		
		//session
		HttpSession session = request.getSession();
		
		//context
		ServletContext context = request.getServletContext();
		
		//set방식
		request.setAttribute("myinfo", myname);
		session.setAttribute("myinfo2", myname);
		context.setAttribute("myinfo3", myname);
		
		//get방식 : set앞에 코드를 작성할 경우 원래있던 값을 불러오게 되어 원하는 결과를 받지 못함(바뀐 값을 저장하고 불러오고 싶을경우)
		String my = (String)context.getAttribute("myinfo3");
		System.out.println("ServletContext에 저장된 myinfo3 : " + my);
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		System.out.println(menu_member);
		System.out.println(menu_order);
		
		System.out.println("-----------------------------------");
		
		InputStream is = context.getResourceAsStream("WEB-INF/config/init.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		
		while((line = br.readLine())!= null){
			System.out.println(line);
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("get.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
