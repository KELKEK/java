package com.shinhan.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shinhan.util.DBUtil;

//DAO(Data Access하는 비지니스 로직을 처리하는 Object)
public class EmpDAO {
	//모든 작업은 connection필요
	Connection conn;
	Statement st;
	PreparedStatement pst;//Statement를 상속받음, 바인딩변수(?)를 지원
	ResultSet rs;
	//1, 직원 모두 조회
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();//ArrayList말고 다른 걸로도 바뀔 수 있으므로 emplist를 List형태로 담아둔다.
		String sql = "select * from employees";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				//칼럼이 11개라 다 쓰기엔 너무 많음
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);//해제
		}	
		
		
		return emplist;
	}

	
	//2, 특징 직원의 상세보기
	public EmpDTO selectByID(int empid) {
		EmpDTO emp = null;
		String sql = "Select * from employees where employee_id = " + empid;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);//해제
		}	
		return emp;
	}
	
	//3, 특징 부서의 상세보기
	public List<EmpDTO> selectBydept(int deptid) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();//ArrayList말고 다른 걸로도 바뀔 수 있으므로 emplist를 List형태로 담아둔다.
		//String sql = "select * from employees where department_id = " + deptid; //나중에 후술할 4번 문제처럼 비효율적으로 세팅해야할 수 있다.
		String sql = "select * from employees where department_id = ?";//바인딩변수 '?'를 통해 세팅을 편하게 함
		conn = DBUtil.dbConnection();
		try {
			//st = conn.createStatement();
			//rs = st.executeQuery(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);//1번째 ? 에 deptid를 넣기
			rs = pst.executeQuery();
			while(rs.next()) {
				//칼럼이 11개라 다 쓰기엔 너무 많음
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);//해제
		}
		return emplist;	
	}
	
	//4, 다양한 조건으로 조회하기
	//부서별(=), 직책별(=), 입사일별(언제 이후에 입사했나, >=), 급여별(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();//ArrayList말고 다른 걸로도 바뀔 수 있으므로 emplist를 List형태로 담아둔다.
		//String sql = "select * from employees where department_id = " + deptid; //나중에 후술할 4번 문제처럼 비효율적으로 세팅해야할 수 있다.
		String sql = "select * "
				+ " from employees "
				+ " where department_id = ?"
				+ " and job_id = ?"
				+ " and hire_date >= ? "
				+ " and salary >= ? ";//바인딩변수 '?'를 통해 세팅을 편하게 함
		conn = DBUtil.dbConnection();
		try {
			//st = conn.createStatement();
			//rs = st.executeQuery(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);//1번째 ? 에 deptid를 넣기
			pst.setString(2, jobid);//2번째 ? 에 jobid를 넣기
			pst.setDate(3, hdate);//3번째 ? 에 hdate를 넣기
			pst.setInt(4, salary);//4번째 ? 에 salary를 넣기
			rs = pst.executeQuery();
			while(rs.next()) {
				//칼럼이 11개라 다 쓰기엔 너무 많음
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);//해제
		}
		return emplist;	
	}
	
	
	//5, 입력(Insert)
	public int empInsert(EmpDTO emp) {
		int result = 0; //insert 실패 시 -1, insert할게 없을 시 0
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,? )";
		conn = DBUtil.dbConnection();//setAutoCommit(true)되어있음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();//DML문장은 excuteUpdate, select문은 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//6. 수정(Update)
	public int empUpdate(EmpDTO emp) {
		int result = 0; //insert 실패 시 -1, insert할게 없을 시 0
		String sql = "update employees "
				+ " set"
				+ " FIRST_NAME = ?, "
				+ " LAST_NAME = ?, "
				+ " EMAIL = ?, "
				+ " PHONE_NUMBER = ?, "
				+ " HIRE_DATE = ?, "
				+ " JOB_ID = ?, "
				+ " SALARY = ?, "
				+ " COMMISSION_PCT = ?, "
				+ " MANAGER_ID = ?, "
				+ " DEPARTMENT_ID = ? "
				+ " where EMPLOYEE_ID = ?";
		conn = DBUtil.dbConnection();//setAutoCommit(true)되어있음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			pst.setInt(11, emp.getEmployee_id());
			result = pst.executeUpdate();//DML문장은 excuteUpdate, select문은 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//7, 삭제(Delete)
	public int empDelete(int empid) {
		int result = 0; //insert 실패 시 -1, insert할게 없을 시 0
		String sql = "delete from employees where EMPLOYEE_ID = ? ";
		conn = DBUtil.dbConnection();//setAutoCommit(true)되어있음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			result = pst.executeUpdate();//DML문장은 excuteUpdate, select문은 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//칼럼 하나를 추출
	private EmpDTO makeEmp(ResultSet rs) {
		// TODO Auto-generated method stub
		EmpDTO emp = new EmpDTO();
		try {
			emp.setCommission_pct(rs.getDouble("commission_pct"));//실제로는 칼럼의 번호를 알 수 없으므로 이렇게 해준다.
			emp.setDepartment_id(rs.getInt("department_id"));
			emp.setEmail(rs.getString("email"));
			emp.setEmployee_id(rs.getInt("employee_id"));
			emp.setFirst_name(rs.getString("first_name"));
			emp.setJob_id(rs.getString("job_id"));
			emp.setHire_date(rs.getDate("hire_date"));
			emp.setLast_name(rs.getString("last_name"));
			emp.setManager_id(rs.getInt("manager_id"));
			emp.setPhone_number(rs.getString("phone_number"));
			emp.setSalary(rs.getInt("salary"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	//직원번호를 입력받아서 직원정보(이름, 칙책, 급여)를 return
	public Map<String, Object> empInfo(int empid) {
		// TODO Auto-generated method stub
		Map<String, Object> empMap = new HashMap<>();
		String fname = null;
		String job = null;
		int salary = 0;
		String sql = "{call sp_empInfo(?, ?, ?, ?)";
		CallableStatement cstmt = null;
		conn = DBUtil.dbConnection();
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			boolean result = cstmt.execute();
			fname = cstmt.getString(2);
			job = cstmt.getString(3);
			salary = cstmt.getInt(4);
			empMap.put("fname", fname);
			empMap.put("job", job);
			empMap.put("salary", salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		return empMap;
	}
	
	
	
	//직원 번호가 들어오면 직원보너스를 return 하는 함수를 호출한다.
	public double callFunction(int empid) {
		double bonus = 0;
		
		String sql = "select f_bonus(?) from dual";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if(rs.next()) {
				bonus = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bonus;
	}
	
	//특정부서에 근무하는 직원들
	
	
	//입력
	//수정
	//삭제
}
