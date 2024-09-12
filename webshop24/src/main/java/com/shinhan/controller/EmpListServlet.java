package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectAll();
		System.out.println(emplist.size() + "건 조회됨");
		request.setAttribute("emplist", emplist);//요청문서에 추가로 저장함, emplist에 해당되는 것을 왼쪽의 emplist라는 것으로 저장(명칭은 꼭 안 같아도 됨)
		
		
		//RequestDispatcher : 클라이언트로부터 요청받은 정보를 서버의 다른 자원(HTMl, JSP또는 Servlet등의 자원) 에 보내는 역할을 하는 인터페이스
		//ㄴ : 위임하다. 요청은 서블릿이 받았는데 응답은 JSP가 한다.
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}
	//response가 전달되었다는 것은 서블릿대신 JSP가 응답한다의 의미

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
