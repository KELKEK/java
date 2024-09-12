package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

//사용자가 요청 -> Controller -> Service
//          <- view <- Controller <- Service
//Controll가 바로 결과를 사용자한테 보내주는 것이 아니라 View를 통해 디자인을 하고 보내줌
//나중에는 Servelet(서버에서 실행되는 자바프로그램)으로 작성할 예정이다.
public class EmpController {
	//유저가 요청하면 응답을 받아서 나중에 대답을 주는 용도
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isStop = false;
		EmpService empService = new EmpService();
		while(!isStop) {
			int selectJob = menuDisplay();
			switch(selectJob) {
			case 0 ->{
				isStop = true;
			}
			case 1 -> {
				List<EmpDTO> emplist = empService.selectAll();
				EmpView.print(emplist, "모든 직원 조회");
			}
			case 2 -> {
				System.out.print("조회할 직원번호 >>");
				int empid = sc.nextInt();
				EmpView.print(empService.selectByID(empid), "특정직원조회");
				//empService.selectByID(empid);
			}
			case 3 -> {
				System.out.print("조회할 부서번호 >>");
				int deptid = sc.nextInt();
				EmpView.print(empService.selectBydept(deptid), "특정부서직원조회");
			}
			case 4 ->{
				System.out.print("조회할 (부서/직책/입사일0000-00-00/급여) >>");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				Date hdate = DateUtil.getSQLDate(sc.next());//0000/00/00
				int salary = sc.nextInt();
				EmpView.print(empService.selectByCondition(deptid, jobid, hdate, salary), "(부서/직책/입사일/급여)조건조회");
				
			}
			case 5 ->{
				EmpDTO emp = InsertMenu();
				int result = empService.empInsert(emp);
				EmpView.print(result>0?"입력성공":"입력실패");
			}//case의 코드는 짧게, 기능 구현 메소드에 나머지를 넣어놔야 유지보수할 때 편하다.
			case 6 ->{
				EmpDTO emp = InsertMenu();
				int result = empService.empUpdate(emp);
				EmpView.print(result>0?"수정성공":"수정실패");
			}
			case 7 ->{
				System.out.print("삭제할 직원 번호 >> ");
				int empid = sc.nextInt();
				int result = empService.empDelete(empid);
				EmpView.print(result>0?"삭제성공":"삭제실패");
			}
			case 8 ->{
				System.out.print("조회할 직원 번호 >> ");
				int empid = sc.nextInt();
				//모든 칼럼이면 DTO, 그러나 갖고오고 싶은게 3개(이름, JOB, salary)의 속성 뿐이면 Map이 낫다.
				Map<String, Object> emp = empService.empInfo(empid);
				EmpView.print(emp);
			}
			case 9 ->{
				System.out.print("조회할 직원 번호 >>");
				int empid = sc.nextInt();
				double result = empService.callFunction(empid);
				EmpView.print("직원의 보너스 : " + result);
				
			}
			default ->{}
			}
		}
		System.out.println("==============END========");
	}
	private static EmpDTO InsertMenu() {
		System.out.print("EMPLOYEE_ID(Int)>>");
		int empid = sc.nextInt();
		System.out.print("FIRST_NAME(String)>>");
		String fname = sc.next();
		System.out.print("LAST_NAME(String)>>");
		String lname = sc.next();
		System.out.print("EMAIL(String)>>");
		String email = sc.next();
		System.out.print("PHONE_NUMBER(String)>>");
		String phone = sc.next();
		System.out.print("HIRE_DATE(0000-00-00)>>");
		Date hdate = DateUtil.getSQLDate(sc.next());
		System.out.print("JOB_ID(String)>>");
		String job_id = sc.next();
		System.out.print("SALARY(Int)>>");
		int sal = sc.nextInt();
		System.out.print("COMMISSION_PCT(Double)>>");
		double comm = sc.nextDouble();
		System.out.print("MANAGER_ID(Int)>>");
		int mid = sc.nextInt();
		System.out.print("DEPARTMENT_ID(Int)>>");
		int deptid = sc.nextInt();
		
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setHire_date(hdate);
		emp.setManager_id(mid);
		emp.setSalary(sal);
		emp.setPhone_number(phone);
		
		return emp;
	}
	
	private static int menuDisplay() {
		System.out.println("============");
		System.out.println("1, 모든 직원 조회");
		System.out.println("2, 특정 직원 조회");
		System.out.println("3, 특정부서의 직원 조회");
		System.out.println("4, 조건조회(부서/직책/입사일/급여)");
		System.out.println("5, 직원입력");
		System.out.println("6, 직원수정");
		System.out.println("7, 직원삭제");
		System.out.println("8, Procedure호출(직원번호IN/정보OUT)");
		System.out.println("9, Function 호출(f_bonus)");
		System.out.println("0, 종료");
		System.out.print("작업 선택 >> ");
		int job = sc.nextInt();
		System.out.println("==============");
	
		return job;
	}

}
