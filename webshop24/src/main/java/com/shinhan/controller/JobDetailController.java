package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpService;
import com.shinhan.emp.JobDTO;

/**
 * Servlet implementation class JobDetailController
 */
@WebServlet("/job/joblist.do")
public class JobDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//모든 JOB조회
		//1, 객체생성 하는 이유? : 인스턴스메서드 호출하기 위해 객체생성, 만약에 static메서드였다면 생성없이 호출
		//비지니스 로직을 수행한다.
		EmpService eservice = new EmpService();
		List<JobDTO> joblist = eservice.selectAllJob();
		request.setAttribute("joblist", joblist);
		//ㄴ 요청문서에 data를 저장한다.(JSP가 사용하기 위함) <- 왼쪽에 있는 joblist가 JSP에 쓰인다.
		
		//Servlet받은 요청과 응답을 JSP(View담당)에 해준다.
		RequestDispatcher rd = request.getRequestDispatcher("joblist.jsp");
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
