package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;

/**
 * Servlet implementation class DeptDetailController
 */
@WebServlet("/dept/deptUpdate.do")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//doGet(), doPost() 모두 코드가 같다면 service()메서드에서 코드해도 된다.
	protected void /*doGet*/service	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("deptid");
		if(deptid==null) return;
		
		DeptService dService = new DeptService();
		int i_deptid = Integer.parseInt(deptid);
		DeptDTO dept = dService.selectById(i_deptid);
		//지금 다음 함수를 안 말들어서 없음 나중에 만들어보기
		request.setAttribute("deptInfo", dept);
		System.out.println(deptid);
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptUpdate.jsp");
		rd.forward(request, response);
		
	}
	
	/*
	 * 404 : 페이지가 존재하지 않는다. 주소확인
	 * 405 : 요청방식을 지원하지 않는다.(get, post 확인)
	 * 500 : 서버 오류. 프로그램 실행오류이므로 서버의 console창(이클립스 아랫부분의 console) 확인
	 * 200 : 요청 성공
	 */


}
