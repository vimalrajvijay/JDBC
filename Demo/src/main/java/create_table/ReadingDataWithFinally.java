package create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingDataWithFinally {
	
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/test";
		String userName = "postgres";
		String password = "root";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement(); 
			
			String query = "select * from student";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Id   : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Age  : "+rs.getInt(3));
				System.out.println("----------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
