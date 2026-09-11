package create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/test";
		String userName = "postgres";
		String password = "root";
	
		try(Connection con = DriverManager.getConnection(url, userName, password)) {
			String query = "delete student where id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 101);
			int data = pstm.executeUpdate();
			//No of Rows affected
			System.out.println(data);
			System.out.println("Deleted");
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
