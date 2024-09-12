package com.shinhan.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controller -> Service ->DAO
//           <-         <-
//Service : 비지니스 로직을 수행한다.
//DB하고 관련이 없는 로직을 수행할 수도 있으므로 Service에서 그 작업을 수행
public class EmpService {

	EmpDAO empDAO = new EmpDAO();

	// 1. 직원 모두 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = empDAO.selectAll();
		return emplist;
		// return empDAO.selectAll();로 줄여도 된다.
	}
	
	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}
	
	//매니저 모두조회
	public List<HashMap<String, Object>> selectAllManager(){
		return empDAO.selectAllManager();
	}
	
	public List<JobDTO> selectAllJob(){
		return empDAO.selectAllJob();
	}

	// 2, 특정 직원의 상세보기
	public EmpDTO selectByID(int empid) {
		return empDAO.selectByID(empid);
	}
	
	//이메일 중복체크
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}

	// 3, 특정 부서의 직원조히
	public List<EmpDTO> selectBydept(int departmentid) {
		return empDAO.selectBydept(departmentid);
	}

	// 4, 다양한 조건으로 조회하기
	// 부서별(=), 직책별(=), 입사일별(언제 이후에 입사했나, >=), 급여별(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 5, 입력(Insert)
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 6. 수정(Update)
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	//7, 삭제(Delete)
		public int empDelete(int empid) {
			return empDAO.empDelete(empid);
		}
		//직원번호를 이용해서 직원의 이름과 직책과 급여를 조회한다.
		public Map<String, Object> empInfo(int empid) {
			// TODO Auto-generated method stub
			return empDAO.empInfo(empid);
		}
		
		
		public double callFunction(int empid) {
			return empDAO.callFunction(empid);
		}
}
