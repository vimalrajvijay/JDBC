package create_table;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateStudentTable {
	
	public static void main(String[] args) {
		
		try {
			//step 1: Load the Driver
			Class.forName("org.postgresql.Driver");
			
			//step 2: Create the Connection object.
			String url = "jdbc:postgresql://localhost:5432/test";
			String userName = "postgres";
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, userName, password);
	
			// step 3: Create the Statement Object.
			Statement stm = con.createStatement();
			
			// step 4: Execute the Query
			String query = "create table student (id int primary key, name varchar(20), age int)";
			stm.execute(query);
			
			// step 5: Close the connection
			con.close();
			
			System.out.println("Created");
			
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
