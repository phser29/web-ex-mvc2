package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/?web_ex";
			String user = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB 연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패"); 
		}
		return conn;
	}
}
