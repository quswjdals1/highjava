package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JDBC(JAVA DATABASE CONNECTIVITY) 라이브러리를 이용한 db자료 처리하기
public class jdbcTest01 {
	/*
		jdbc를 이용한 db처리 순서
		
		1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리로 읽어들이는 작업
			Class.forName("oracle.jdbc.driver.OracleDriver");
		2. db에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
			Connection conn = DriverManager.getConnection();
		3. 질의 ==>sql 쿼리를 db서버로 보내서 처리를 하고 그 결과를 얻어옴
			Statement, preparedStatement객체를 사용
		4. 결과처리 ==> 질의결과를 받아서 원하는 작업을 수행한다.
			sql문이 select: ResultSet객체에 저장되어 반환
			sql문이 select가 아닐경우: 정수값 반환(작업이 수행된 행의 수)
		5. 사용자원 반납==>close()
			
	*/
	public static void main(String[] args) {
		//db작업에 필요한 객체변수 선언
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bjm", "java");
			String sql = "select * from lprod ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
