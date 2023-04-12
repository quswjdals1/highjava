package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Stack;

import kr.or.ddit.util.DBUtil3;

public class JdbcTest06 {
	
	/*
	
		회원관리하는 프로그램 작성
		crud기능 구현하기
		메뉴 예시)
		1. 자료 추가
		2. 자료 삭제
		3. 자료 수정
		4. 전체자료 출력
		0. 작업 끝
		----------------
		
		조건
		1. 자료 추가에서 회원id는 중복되지 않는다.(중복되면 다시입력 받도록한다.)
		2. 자료삭제는 회원id를 입력받아서 처리한다.
		3. 자료수정에서 회원id는 변경되지 않는다.
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		out:while(true) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("---------------------");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2");
			System.out.println("6. 자료 수정3");
			System.out.println("0. 작업 끝");
			System.out.println("---------------------");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				add(sc);			
				break;
			case 2:
				remove(sc);
				break;
			case 3:
				update(sc);
				break;
			case 4:
				select(sc);
				break;
			case 5:
				update2(sc);
				break;
			case 6:
				update3(sc);
				break;
			case 0:
				System.out.println("프로그램 종료");
				break out;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
		}
		
	}

	private static void update3(Scanner sc) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection conn = DBUtil3.getConnection();
		int res=0;
		PreparedStatement ps = null;
		String set="";
		Stack<String> list = new Stack<>();
		try {
			int cnt=0;
			System.out.println("수정할 자료의 id 입력: ");
			String id = sc.nextLine();
			System.out.println("mem_pass 수정값 입력: ");
			String pass = sc.nextLine();
			if(!pass.equals("")) {
				set+="mem_pass=?,";
				cnt++;
				list.add(pass);
			}
			System.out.println("mem_name 수정값 입력: ");
			String name = sc.nextLine();
			if(!name.equals("")) {
				set+="mem_name=?,";
				cnt++;
				list.add(name);
			}
			System.out.println("mem_tel 수정값 입력: ");
			String tel = sc.nextLine();
			if(!tel.equals("")) {
				set+="mem_tel=?,";
				cnt++;
				list.add(tel);
			}
			System.out.println("mem_addr 수정값 입력: ");
			String addr = sc.nextLine();
			if(!addr.equals("")) {
				set+="mem_addr=?,";
				cnt++;
				list.add(addr);
			}
			
			if(set.equals("")) {
				System.out.println("수정내용을 아무것도 입력안했습니다.");
				return;
			}
			if(set.charAt(set.length()-1)==',') {
				set=set.substring(0, set.length()-1);
			}
			String sql = "update mymember set "+set+" where mem_id=?";
			ps = conn.prepareStatement(sql);
			
			for (int i=cnt; i > 0; i--) {
				String temp=list.pop();
				ps.setString(i, temp);
			}
			ps.setString(cnt+1,id);
			
			res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	//원하는 항목을 선택해서 수정하기
	private static void update2(Scanner sc) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil3.getConnection();
		PreparedStatement ps = null;
		int res=0;
		String sel = "";
		System.out.println("수정할 아이디 입력: ");
		String id = sc.nextLine();
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 주소 수정");
		String val="";
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			sel="mem_pass";
			System.out.println("수정할 비밀번호 입력: ");
			val=sc.nextLine();
			break;
		case 2:
			sel="mem_name";
			System.out.println("수정할 이름 입력: ");
			val=sc.nextLine();
			break;
		case 3:
			sel="mem_tel";
			System.out.println("수정할 전화번호 입력: ");
			val=sc.nextLine();
			System.out.println();
			break;
		case 4:
			sel="mem_addr";
			System.out.println("수정할 주소 입력: ");
			val=sc.nextLine();
			break;
		default:
			System.out.println("잘못된 입력입니다. 메인으로 돌아갑니다.");
			return;
		}
		try {
			String sql = "update mymember set "+sel+"=? where mem_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, val);
			ps.setString(2, id);
			res = ps.executeUpdate();
			
			if(res==1) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static void select(Scanner sc) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil3.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from mymember ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			System.out.println("id\t pass\t name\t tel\t addr 순");
			System.out.println("-------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getString(4)+"\t "+rs.getString(5));	
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private static void update(Scanner sc) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil3.getConnection();
		int res=0;
		PreparedStatement ps = null;
		
		try {
			System.out.println("수정할 자료의 id 입력: ");
			String id = sc.nextLine();
			System.out.println("mem_pass 수정값 입력: ");
			String pass = sc.nextLine();
			System.out.println("mem_name 수정값 입력: ");
			String name = sc.nextLine();
			System.out.println("mem_tel 수정값 입력: ");
			String tel = sc.nextLine();
			System.out.println("mem_addr 수정값 입력: ");
			String addr = sc.nextLine();
			

			String sql = "update mymember set mem_pass=?,"
						+"mem_name=?, "
						+"mem_tel=?, "
						+"mem_addr=? "
						+"where mem_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,pass);
			ps.setString(2,name);
			ps.setString(3,tel);
			ps.setString(4,addr);
			ps.setString(5,id);
			
			res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private static void remove(Scanner sc) {
		// TODO Auto-generated method stub
		Connection conn =DBUtil3.getConnection();
		int res = 0;
		PreparedStatement ps=null;
		
		try {
			System.out.println("삭제할 자료의 id 입력: ");
			String id = sc.nextLine();
			String sql = "delete from mymember where mem_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			res=ps.executeUpdate();
			if(res==1) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static void add(Scanner sc) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id=null;
		String pass=null;
		String name=null;
		String tel=null;
		String addr=null;
		
		try {
			Connection conn=DBUtil3.getConnection();
			int res=1;
			
			String sql;
			while (res!=0) {
				System.out.print("id 입력: ");
				id = sc.nextLine();
				sql = "select count(*) from mymember where mem_id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				res = rs.getInt(1);
				if(res==1) {
					System.out.println("중복된 아이디가 있습니다. 다시입력하세요");
				}
			}
			System.out.println("비밀번호 입력: ");
			pass=sc.nextLine();
			System.out.println("이름 입력: ");
			name=sc.nextLine();
			System.out.println("전화번호 입력: ");
			tel=sc.nextLine();
			System.out.println("주소 입력: ");
			addr=sc.nextLine();
			
			sql = "insert into mymember(mem_id,mem_pass,mem_name,mem_tel,mem_addr)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, tel);
			ps.setString(5, addr);
			
			res=ps.executeUpdate();
			if(res==1) {
				System.out.println("등록 완료");
			}else {
				System.out.println("등록 실패");
			}
			
		} catch (Exception e) {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
