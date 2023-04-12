package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

	//jdbc드라이버를 로딩하고 connection 객체를 생성해서 반환하는 메소드로
	//구성된 class 작성하기
	//(dbinfo.properties파일의 내용으로 설정하는 방법)


public class DBUtil2 {
	private static Properties prop;
	
	static {
		prop = new Properties();
		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(file);
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Connection 객체를 반환하는 메소드
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결 실패");
			e.printStackTrace();
		}
		return null;
	}

}
