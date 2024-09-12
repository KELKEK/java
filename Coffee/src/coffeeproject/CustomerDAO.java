package coffeeproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;//Statement를 상속받음, 바인딩변수를 지원
	ResultSet rs;
	
	//1, 회원가입
	public int customInsert(CustomerDTO cus) {
		int result = 0; //insert 실패 시 -1, insert할 것이 없을 시 0
		String sql = "insert into customer(customerid, nickname, pword)"
				+ " values(?, ?, ?)";
		conn = DBUtil.dbConnection();//setAutoCommit(true)되어있음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cus.getCustomerid());
			pst.setString(2, cus.getNickname());
			pst.setString(3, cus.getPword());
			result = pst.executeUpdate();
			//DML문장은 excuteUpdate, select문은 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("회원등록 실패!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//1, 커피 선호도 입력
	public int customFavor(CustomerFavorDTO cusf) {
		int result = 0;
		String sql = "insert into customer_favor values(?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cusf.getCustomerid());
			pst.setInt(2, cusf.getPrice());
			pst.setInt(3, cusf.getCaffeine());
			pst.setInt(4, cusf.getSugar());
			pst.setInt(5, cusf.getQuality());
			pst.setInt(6, cusf.getDistance());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//2, 로그인
	public CustomerDTO customLogin(String Id, String Pw) {
		CustomerDTO ccus = new CustomerDTO();
		String sql = "select nickname, dist_x, dist_y "
				+ " from customer "
				+ " where customerid = ? and pword = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			pst.setString(2, Pw);
			rs = pst.executeQuery();		
			while(rs.next()) {
				ccus.setNickname(rs.getString("nickname"));
				ccus.setDist_x(rs.getInt("dist_x"));
				ccus.setDist_y(rs.getInt("dist_y"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("로그인 실패!!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return ccus;
	}
	

	//3, 추천값 반환
	public List<Object> customRecommend(String id, int x, int y){
		List<Object> recommendlist = new ArrayList<Object>();
		String sql = "select * from ( "
				+ "select coffee_name as 커피명, coffee_brandname as 커피브랜드, "
				+ "(cuf.price - fe.price + fe.quality - cuf.quality - (ABS(cuf.caffeine-fe.caffeine)+ABS(cuf.sugar-fe.sugar))+(power(? - dist_x, 2)+power(? - dist_y, 2))/18) + 100 추천값 "
				+ "from customer_favor cuf, coffee fe left outer join coffeebrand using(coffee_brandid) "
				+ "where cuf.customerid = ? "
				+ "order by 3 desc) "
				+ "where rownum = 1";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, x);
			pst.setInt(2, y);
			pst.setString(3, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Map<String, String> hm = new HashMap<>();
				hm.put("커피명", rs.getString("커피명"));
				hm.put("커피브랜드", rs.getString("커피브랜드"));
				//hm.put("추천값", Integer.toString(rs.getInt("추천값")));
				recommendlist.add(hm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return recommendlist;
	}
	

	
	//4-1, 고객ID 입력 시 로그인이 된 상태인지 확인하는 용도
	public CustomerDTO customLogin2(String Id) {
		CustomerDTO ccus = new CustomerDTO();
		String sql = "select customerid, nickname, dist_x, dist_y "
				+ " from customer "
				+ " where customerid = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			rs = pst.executeQuery();		
			while(rs.next()) {
				ccus.setCustomerid(rs.getString("customerid"));
				ccus.setNickname(rs.getString("nickname"));
				ccus.setDist_x(rs.getInt("dist_x"));
				ccus.setDist_y(rs.getInt("dist_y"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("로그인 실패!!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return ccus;
	}

	
	//4, 커피 선호도 갱신
	public int customFavorUpdate(CustomerFavorDTO cusf) {
		int result = 0;
		String sql = "update customer_favor "
				+ "set price = ?, caffeine = ?, sugar = ?, quality = ?, distance = ? "
				+ "where customerid = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cusf.getPrice());
			pst.setInt(2, cusf.getCaffeine());
			pst.setInt(3, cusf.getSugar());
			pst.setInt(4, cusf.getQuality());
			pst.setInt(5, cusf.getDistance());
			pst.setString(6, cusf.getCustomerid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//5, 커피 메뉴판
	public List<Object> customMenu(String id, String brandname, int x, int y) {
		List<Object> menuboard = new ArrayList<Object>();
		String sql = "select coffee_name as 커피명,  (cuf.price - fe.price + fe.quality - cuf.quality - (ABS(cuf.caffeine-fe.caffeine)+ABS(cuf.sugar-fe.sugar))+(power(? - dist_x, 2)+power(? - dist_y, 2))/18) + 100 추천값 "
				+ "from customer_favor cuf, coffee fe left outer join coffeebrand using(coffee_brandid) "
				+ "where cuf.customerid = ? and coffee_brandname = ? "
				+ "order by 2 desc ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, x);
			pst.setInt(2, y);
			pst.setString(3, id);
			pst.setString(4, brandname);
			rs = pst.executeQuery();
			while(rs.next()) {
				Map<String, Object> hm = new HashMap<>();
				hm.put("커피명", rs.getString("커피명"));
				hm.put("추천값", rs.getInt("추천값"));
				menuboard.add(hm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return menuboard;
	}
	
	//6, 호원탈퇴
	public int customDelete(String id, String pw) {
		int result = 0;
		String sql = "delete from customer "
				+ "where customerid = ? and pword = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//6-2, 회원 선호도 삭제
	public int customFavorDelete(String id) {
		int result = 0;
		String sql = "delete from customer_favor "
				+ "where customerid = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}
