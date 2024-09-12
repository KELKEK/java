package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
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
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/emp/empUpdate.do")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		request.setAttribute("deptlist", dlist);
		
		EmpService eService = new EmpService();
		List<HashMap<String, Object>> mlist = eService.selectAllManager();//EmpService에 요청을 받음
		request.setAttribute("mlist", mlist);//요청받은 결과를 왼쪽의 mlist라는 이름으로 JSP에 주게 된다.

		
		List<JobDTO> joblist = eService.selectAllJob();
		request.setAttribute("joblist", joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empInsert.jsp");
		rd.forward(request, response);
	}
	/*
	 * 404 : 페이지가 존재하지 않는다. 주소확인
	 * 405 : 요청방식을 지원하지 않는다.(get, post 확인)
	 * 500 : 서버 오류. 프로그램 실행오류이므로 서버의 console창(이클립스 아랫부분의 console) 확인
	 * 200 : 요청 성공
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자동으로 encoding X, 요청문서에 내용을 담아서 온다.
		request.setCharacterEncoding("utf-8");//1문자가 3byte임을 설정
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		System.out.println(result+"건 수정됨");
		request.setAttribute("message", result+"건 수정됨");

		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		//1)JSP에 응답을 위임하는 경우(MVC2모델)
		
		//2)서블릿이 직접 응답을 하는 경우
//		response.setContentType("text/html;charset=utf-8");//text/html : MINE-TYPE
//		PrintWriter out = response.getWriter();
//		out.write("<h1>서블릿이 직접 응답을 하는 경우</h1>");
		
	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		// TODO Auto-generated method stub

		
		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("employee_id"));//emplist.jsp의 넣고자 했던 입력폼의 name명과 같다.
		int mid = convertInt(request.getParameter("manager_id"));//emplist.jsp의 넣고자 했던 입력폼의 name명과 같다.
		int did = convertInt(request.getParameter("department_id"));//emplist.jsp의 넣고자 했던 입력폼의 name명과 같다.
		int salary = convertInt(request.getParameter("salary"));//emplist.jsp의 넣고자 했던 입력폼의 name명과 같다.
		double commission = convertDoule(request.getParameter("commission_pct"));//emplist.jsp의 넣고자 했던 입력폼의 name명과 같다.
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
		
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setSalary(salary);
		emp.setCommission_pct(commission);
		emp.setManager_id(mid);
		emp.setDepartment_id(did);
		
		return emp;
	}

	private double convertDoule(String parameter) {
		if(parameter == null) return 0;
		return Double.parseDouble(parameter);
	}

	private int convertInt(String parameter) {
		// TODO Auto-generated method stub
		if(parameter == null) return 0;
		return Integer.parseInt(parameter);
	}


}
