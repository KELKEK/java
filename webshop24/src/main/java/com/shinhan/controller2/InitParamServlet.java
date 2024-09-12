package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
//@WebServlet(
//		urlPatterns = { 
//				"/InitParamServlet", 
//				"/init", "/Init2"
//		}, 
//		initParams = { 
//				@WebInitParam(name = "myname", value = "kel"), 
//				@WebInitParam(name = "email", value = "ljk5252525@gmail.com"),
//				@WebInitParam(name = "phone", value = "010-9876-5432")
//		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //특정 서블릿만 적용되는 값
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamServlet() {
		System.out.println("initParamServlet 생성자");
        // TODO Auto-generated constructor stub
    }
	
	public void destroy() {
		System.out.println("initParamServlet 소멸자");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = getInitParameter("myname");
		String b = getInitParameter("email");
		String c = getInitParameter("phone");
		System.out.println(a + " : " + b + " : " + c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
