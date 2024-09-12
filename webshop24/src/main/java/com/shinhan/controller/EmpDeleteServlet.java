package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		
		//forward는 받은 요청을 다른 페이지에 위임한다. 주소가 바뀌지 않음 <- 이 문제로 칼럼이 삭제된 뒤 dispatcher로 emplist.jsp를 불러도 주소가 그대로 되며 혼돈이 생기게 된다.
//		request.setAttribute("message", result + "건 삭제되었다.");
//		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		//새로운 요청으로 보내기(sendredirect)...주소창의 주소가 바뀐다.
		//할 일을 끝내고 새로운 위치로 감
		//response.sendRedirect("empList");
		response.addHeader("Refresh", "3;empList");
		//다른 방식3)<meta http-equiv="refresh" content="3;empList">
	}

	

}
