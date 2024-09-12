package coffeeproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoffeeDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;//Statement를 상속받음, 바인딩변수를 지원
	ResultSet rs;
	
	//1, 커피집 등록
	public int coffeebrandInsert(CoffeeBrandDTO coffeebrand) {
		int result = 0;
		String sql = "insert into coffeebrand values(?, ?, ?, ?)";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, coffeebrand.getCoffee_brandid());
			pst.setString(2, coffeebrand.getCoffee_brandname());
			pst.setDouble(3, coffeebrand.getDist_x());
			pst.setDouble(4, coffeebrand.getDist_y());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		
		return result;
	}
	
	
	//2, 커피 등록
	public int coffeeInsert(CoffeeDTO coffee) {
		int result = 0;
		String sql = "insert into coffee values(?, ?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, coffee.getCoffee_id());
			pst.setInt(2, coffee.getCoffee_brandid());
			pst.setString(3, coffee.getCoffee_name());
			pst.setInt(4, coffee.getPrice());
			pst.setInt(5, coffee.getCaffeine());
			pst.setInt(6, coffee.getSugar());
			pst.setInt(7, coffee.getQuality());
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
