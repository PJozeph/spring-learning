package home.joci.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
			String user = "hbstudent";
			String password = "hbstudent";
			
			System.out.println("Connecting to DB");
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connected to DB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
