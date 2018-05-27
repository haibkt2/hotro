package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/ga?characterSetResults=UTF-8&characterEncoding=UTF-8&useUnicode=yes";
		String name = "root";
		String pass = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, name, pass);
		return conn;
	}
	
	public static void main(String a[]) throws ClassNotFoundException, SQLException{
			Connection c = Connect.getConnection();
			System.out.println("ok");
		
	}

}
