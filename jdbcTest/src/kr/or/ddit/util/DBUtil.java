package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	//jdbc드라이버를 로딩하고 connection 객체를 생성해서 반환하는 메소드로
	//구성된 class 작성하기
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
	}
	
	//Connection 객체를 반환하는 메소드
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bjm", "java");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결 실패");
			e.printStackTrace();
		}
		return null;
	}

}
