package create_table;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/test";
		String userName = "postgres";
		String password = "root";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			
			String query = "call abc(?, ?, ?)";
			
			CallableStatement cs = con.prepareCall(query);
			
			cs.setInt(1, 103);
			cs.setString(2, "mno");
			cs.setInt(3, 25);
			
			cs.execute();
//			
//			String query = "insert into student values(?, ?, ?)";
//			
//			PreparedStatement pstm = con.prepareStatement(query);
//			
//			pstm.setInt(1, 102);
//			pstm.setString(2, "xyz");
//			pstm.setInt(3, 20);
//			
//			pstm.execute();
			
			con.close();
			
			System.out.println("Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
