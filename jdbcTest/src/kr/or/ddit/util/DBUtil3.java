package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

	//jdbc드라이버를 로딩하고 connection 객체를 생성해서 반환하는 메소드로
	//구성된 class 작성하기
	//(dbinfo.properties파일의 내용으로 설정하는 방법)


public class DBUtil3 {
	private static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
	
		try {
			
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
	}
	
	//Connection 객체를 반환하는 메소드
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결 실패");
			e.printStackTrace();
		}
		return null;
	}

}
