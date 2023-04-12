package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*

	lprod테이블에 새로운 데이터 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아서
	lprod_id는 현재의 lprod_id중에서 제일 큰값보다 1 크게한다.
	
	입력받은 lprod_gu가 이미 등록되어있으면 다시 입력받아서 처리한다.

*/

public class JdbcTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// bankinfo에 계좌정보를 추가하는 예제
		Scanner sc = new Scanner(System.in);
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bjm", "java");
			
			conn=DBUtil.getConnection();
			
			int dup=1;
			String sql="select count(*) from lprod where lprod_gu=?";
			String gu="";
			while(dup==1) {
				System.out.println("gu 입력: ");
				gu=sc.nextLine();
				ps = conn.prepareStatement(sql);
				ps.setString(1, gu);
				rs=ps.executeQuery();
				rs.next();
				dup=rs.getInt(1);
				if(dup==1) {
					System.out.println("중복됩니다. 다시입력하세요");
				}
				ps.close();
				rs.close();
			}
			
			System.out.println("nm 입력: ");
			String nm=sc.nextLine();
			
			sql="select max(lprod_id) from lprod";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			int id=rs.getInt(1)+1;
			
			sql="insert into lprod(lprod_id,lprod_gu,lprod_nm) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, gu);
			ps.setString(3, nm);
			int res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("등록완료");
			}else {
				System.out.println("등록실패");
			}

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
