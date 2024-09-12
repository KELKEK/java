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
 * http://ip:post/contextpath/emp/empDetail
 */
@WebServlet("/emp/empDetail") // intdx.html의 action과 같은 이름이어야 한다.
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get요청");
		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		if (empid == null)
			return;

		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = eService.selectByID(i_empid);
		System.out.println(emp);
		request.setAttribute("empInfo", emp); //요청문서에 data를 저장한다.
		
		//java code는 servlet담당....비지니스 로직을 수행한 후
		//View는 JSP담당(HTML코드는 JSP에서)...JSP에 넘긴다.
		//Browser가 요청 -> 서블릿이 받음 -> JSP에게 위임함(forward)(더 예쁘게 보이게 하기 위해)
		
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		request.setAttribute("deptlist", dlist);
	
		List<HashMap<String, Object>> mlist = eService.selectAllManager();//EmpService에 요청을 받음
		request.setAttribute("mlist", mlist);//요청받은 결과를 왼쪽의 mlist라는 이름으로 JSP에 주게 된다.

		
		List<JobDTO> joblist = eService.selectAllJob();
		request.setAttribute("joblist", joblist);
		
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//get : 상세보기할 때 사용
	//post : 수정, 입력 시 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자동으로 encoding X, 요청문서에 내용을 담아서 온다.
		//request.setCharacterEncoding("utf-8");//1문자가 3byte임을 설정
		//ㄴ 필터로 대체 한 번 해볼예정
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
