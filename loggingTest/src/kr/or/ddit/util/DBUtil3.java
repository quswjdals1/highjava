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

import org.apache.log4j.Logger;

	//jdbc드라이버를 로딩하고 connection 객체를 생성해서 반환하는 메소드로
	//구성된 class 작성하기
	//(dbinfo.properties파일의 내용으로 설정하는 방법)


public class DBUtil3 {
	static final Logger logger = Logger.getLogger(DBUtil3.class);
	
	private static ResourceBundle bundle;
	
	static {
	
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("ResourceBundle 객체 생성 - dbinfo.properties 파일 읽기");
		
		try {
			
			Class.forName(bundle.getString("driver"));
			logger.debug("DB 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("드라이버 로딩 실패",e);
			e.printStackTrace();
		}
		
	}
	
	//Connection 객체를 반환하는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
			logger.info("DB연결 성공 - Connection객체 생성");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("db연결 실패",e);
			e.printStackTrace();
		}
		return conn;
	}

}
