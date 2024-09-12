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
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/dept/deptList.do")
//내가 쓴 주소
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		System.out.println(deptlist.size() + "건 조회됨");
		request.setAttribute("deptList", deptlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
		//쓴 주소와 달리 실제로 이동한 내용(주소는 바뀌지 않았음)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
