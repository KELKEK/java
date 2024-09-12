package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet({ "/Second", "/second2" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter() : 응답문서
		String method = request.getMethod(); // 요청방식
		String addr = request.getRemoteAddr(); // 요청주소
		String cpath = request.getServletContext().getContextPath();//루트주소
		String rpath = request.getServletContext().getRealPath(".");//루트주소
		
		//response.getWriter() : 응답문서
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>응답문서</h1>");
		out.printf("<p>method:%s</p>", method);
		out.printf("<p>addr:%s</p>", addr);
		out.printf("<p>cpath:%s</p>", cpath);
		out.printf("<p>rpath:%s</p>", rpath);
		//서블릿 : 서버에서 실행되는 자바프로그램(Java!!!+HTML);
		//JSP : 서버에서 실행되는 자바프로그램(Java+HTML!!!);
	}
}
