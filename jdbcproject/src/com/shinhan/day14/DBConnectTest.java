package com.shinhan.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 자바와 DB연결
		//1, jdbc driver를 class path 추가(buildpathconfigure이용)
		//2. jdbc드라이버를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. oracle driver load성공");
		
		//3, DB연결
		String url="jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", password = "hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2, DB연결성공");
		
		String sql = "select first_name, salary, job_id"
				+ " from EMPLOYEES "
				+ " where salary >= 15000";
		//4, Statement : 자바와 DB의 대화통로
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			//data가 있을 때 까지
			String fname = rs.getString(1);
			int salary = rs.getInt(2);
			String deptid = rs.getString(3);
			System.out.printf("%-10s\t%d\t%s\n", fname, salary, deptid);
			
		}
		//자원반환
		rs.close();
		st.close();
		conn.close();
			
	}

}
