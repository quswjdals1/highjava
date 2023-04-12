package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		// bankinfo에 계좌정보를 추가하는 예제
		Scanner sc = new Scanner(System.in);
		Connection conn=null;
		PreparedStatement ps=null;
		int res=0;
		System.out.print("계좌번호 입력: ");
		String bankNo=sc.nextLine();
		System.out.print("은행명 입력: ");
		String bankName = sc.nextLine();
		System.out.print("예금주 명: ");
		String userName = sc.nextLine();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bjm", "java");
			String sql = "insert into bankinfo(bank_no,bank_name,bank_user_name,bank_date)values(?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bankNo);
			ps.setString(2, bankName);
			ps.setString(3, userName);
			res = ps.executeUpdate();
			System.out.println(res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
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
