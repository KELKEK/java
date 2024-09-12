package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.emp.JobDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpConditionServlet
 */
@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpService eservice = new EmpService();
		List<JobDTO> joblist = eservice.selectAllJob();

		// 모든 부서 조회
		DeptService dservice = new DeptService();
		List<DeptDTO> deptlist = dservice.selectAll();

		request.setAttribute("job_datas", joblist);
		request.setAttribute("dept_datas", deptlist);
		// ㄴ 요청문서에 data를 저장한다.(JSP가 사용하기 위함) <- 왼쪽에 있는 joblist가 JSP에 쓰인다.

		// Servlet받은 요청과 응답을 JSP(View담당)에 해준다.
		RequestDispatcher rd = request.getRequestDispatcher("retrieve.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jobid = req.getParameter("jobid");
		int deptid = Integer.parseInt(req.getParameter("deptid"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		Date hiredate = DateUtil.getSQLDate(req.getParameter("hiredate"));
		System.out.println(jobid);
		System.out.println(deptid);
		System.out.println(salary);
		System.out.println(hiredate);

		EmpService service = new EmpService();
		List<EmpDTO> emplist = service.selectByCondition(deptid, jobid, hiredate, salary);
		req.setAttribute("emplist", emplist);

		RequestDispatcher rd = req.getRequestDispatcher("emplist2.jsp");
		rd.forward(req, response);
	}

}
