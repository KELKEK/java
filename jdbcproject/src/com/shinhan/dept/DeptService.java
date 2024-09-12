package com.shinhan.dept;

import java.util.List;

public class DeptService {
	DeptDAO deptDAO = new DeptDAO();
	
	//1. 직원 모두 조회
	public List<DeptDTO> selectAll(){
		List<DeptDTO> deptlist = deptDAO.selectAll();
		return deptlist;
	}
}
