package home.joci.testdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestDbServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = "springstudent";
		String userPassword = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			System.out.println("Connecting to DB..");
			Connection connetion = DriverManager.getConnection(jdbcUrl, user, userPassword);
			System.out.println("Connected to DB");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
