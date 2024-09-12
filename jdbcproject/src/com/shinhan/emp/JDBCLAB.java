package com.shinhan.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCLAB {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		while (!isStop) {
			int selectJob = menu();
			switch (selectJob) {
			case 1 -> {
				String sql = " select salary, hire_date" + " from employees\r\n"
						+ " where first_name = initcap('adam')";
				method1(sql);
			}
			case 2 -> {
				String sql = " select *" + " from countries"
						+ " where lower(country_name) = 'united states of america'";
				method2(sql);
			}
			case 3 -> {
				String sql = "select first_name || '의 입사일은 ' || hire_date || ' 이고, 급여는 ' || salary || ' 입니다.'\r\n"
						+ "from employees";
				method3(sql);
			}
			case 4 -> {
				String sql = "select first_name, salary, hire_date " + "from employees " + "where length(first_name)<=";
				method4(sql);
			}
			case 5 -> {
				String sql = "select first_name, salary, hire_date\r\n"
						+ "from employees\r\n"
						+ "where to_char(hire_date, 'yyyy') = ";
				method5(sql);
			}
			case 6 -> {
				String sql = "select first_name, hire_date, "
						+ "trunc(months_between(sysdate, hire_date)/12) 근무년차\r\n"
						+ "from employees\r\n"
						+ "where months_between(sysdate, hire_date)/12 >= ";
				method6(sql);
			}
			case 7 -> {
				isStop = true;
			}
			default -> {
				System.out.println("입력한 작업은 지원되지않음. 다시선택~");
			}
			}
		}
		System.out.println("====시스템종료======");
	}
	
	private static void method6(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();

			System.out.print("근무년수 몇년이상?>>");
			int su = sc.nextInt();

			ResultSet rs = st.executeQuery(sql + su);
			int i = 0;
			while (rs.next()) {
				i++;
				String name = rs.getString(1);
				int year = rs.getInt(3);
				Date hdate = rs.getDate(2);
				System.out.println(i + "==>" + name + "\t" + year + "\t" + hdate + "\t");
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void method5(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();

			System.out.print("조회년도>>");
			int su = sc.nextInt();

			ResultSet rs = st.executeQuery(sql + su);
			int i = 0;
			while (rs.next()) {
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(2);
				Date hdate = rs.getDate(3);
				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate + "\t");
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method4(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();

			System.out.print("이름이 몇글자 이하>>");
			int su = sc.nextInt();

			ResultSet rs = st.executeQuery(sql + su);
			int i = 0;
			while (rs.next()) {
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(2);
				Date hdate = rs.getDate(3);
				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate + "\t");
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method3(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				i++;
				String info = rs.getString(1);
				System.out.println(i + "==>" + info);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method2(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String country_id = rs.getString(1);
				String country_name = rs.getString("country_name"); // 칼럼명으로 줘도 됨
				int regionId = rs.getInt("region_id"); // 칼럼명으로 줘도 됨
				System.out.println(
						"country_id :" + country_id + " country_name: " + country_name + " region_id " + regionId);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method1(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			//속성의 자료형을 알고싶을 때
//			ResultSetMetaData metaData = rs.getMetaData();
//			System.out.println(metaData.getColumnTypeName(1));
//			System.out.println(metaData.getColumnTypeName(2));
			while (rs.next()) {
				int sal = rs.getInt(1);
				Date hdate = rs.getDate(2);
				System.out.println(sal + "\t" + hdate);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void dbDisconnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		conn.close();
		System.out.println("3. 실행후 DB해제");
	}

	private static Connection dbConnection() {
		// 1. JDBC Driver load
		// 2. Connection 생성
		// 자기ip, localhost, 127.0.0.1
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // EE - data source explorer 에서 찾기
		String userid = "hr";
		String password = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Referenced Libraries에서 찾기
			System.out.println("1. JDBC Driver load 성공");
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println("2. Connection 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// 동시에 몇명이 쓸수있는지에 따라 비용이 달라지므로, 연결하고 자원을 반납해야 다른 사람이 사용가능하다.
	private static int menu() {
		System.out.println("============================");
		System.out.println("1.INITCAP 2.lower 3.concat 4.length");
		System.out.println("5.to_char 6.months_between 7.END");
		System.out.println("작업을 선택>");
		int job = sc.nextInt();
		System.out.println("============================");
		return job;
	}

}