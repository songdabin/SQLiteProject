import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// SQLite JDBC check
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			//데이터 조회
			System.out.println("\n----- 데이터 조회 -----");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artist";
			ResultSet rs1 = stat1.executeQuery(sql1);
			
			while (rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				String regdate = rs1.getString("regdate");
				System.out.println(id + " " + name + " " + regdate);
			}
			stat1.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try { 
					con.close();
				} catch (Exception e) {
					
				}
			}
		}
	}

}
