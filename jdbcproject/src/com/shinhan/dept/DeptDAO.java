package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class DeptDAO {
	//모든 작업은 connection필요
		Connection conn;
		Statement st;
		PreparedStatement pst;//Statement를 상속받음, 바인딩변수(?)를 지원
		ResultSet rs;
		//1, 직원 모두 조회
		public List<DeptDTO> selectAll() {
			List<DeptDTO> deptlist = new ArrayList<DeptDTO>();//ArrayList말고 다른 걸로도 바뀔 수 있으므로 emplist를 List형태로 담아둔다.
			String sql = "select * from departments";
			conn = DBUtil.dbConnection();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					//칼럼이 4개라 다 쓰기엔 너무 많음
					DeptDTO dept = makeDept(rs);
					deptlist.add(dept);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.dbDisconnect(conn, st, rs);//해제
			}	
			
			return deptlist;
		}
		
		//2, 특정 직원의 상세보기
		

//칼럼 하나를 추출
	private DeptDTO makeDept(ResultSet rs) {
		// TODO Auto-generated method stub
		DeptDTO emp = new DeptDTO();
		try {
			emp.setDepartment_id(rs.getInt("department_id"));
			emp.setDepartment_name(rs.getString("department_name"));
			emp.setManager_id(rs.getInt("manager_id"));
			emp.setLocation_id(rs.getInt("location_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
}

		