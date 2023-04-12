package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {

	private static MemberDaoImpl memberDaoImpl;
	
	private MemberDaoImpl() {
		
	}
	
	public static MemberDaoImpl getInstance() {
		if(memberDaoImpl==null) {
			memberDaoImpl=new MemberDaoImpl();
		}
		return memberDaoImpl;
	}
	
	@Override
	public int insertMember(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement ps=null;
		int res=0;//반환값
		
		try {
			conn=DBUtil3.getConnection();
			String sql = "insert into mymember(mem_id,mem_pass,mem_name,mem_tel,mem_addr)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, memberVO.getMemId());
			ps.setString(2, memberVO.getMemPass());
			ps.setString(3, memberVO.getMemName());
			ps.setString(4, memberVO.getMemTel());
			ps.setString(5, memberVO.getMemAddr());
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return res;
	}

	@Override
	public int deleteMember(String memId) {

		// TODO Auto-generated method stub
		Connection conn =DBUtil3.getConnection();
		int res = 0;
		PreparedStatement ps=null;
		
		try {

			String sql = "delete from mymember where mem_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			res=ps.executeUpdate();
		
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
		return res;
		
	}

	@Override
	public int updateMember(MemberVO memberVO) {

		Connection conn = DBUtil3.getConnection();
		int res=0;
		PreparedStatement ps = null;
		
		try {

			String sql = "update mymember set mem_pass=?,"
						+"mem_name=?, "
						+"mem_tel=?, "
						+"mem_addr=? "
						+"where mem_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,memberVO.getMemPass());
			ps.setString(2,memberVO.getMemName());
			ps.setString(3,memberVO.getMemTel());
			ps.setString(4,memberVO.getMemAddr());
			ps.setString(5,memberVO.getMemId());
			
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
		
		return res;
		
	}

	@Override
	public List<MemberVO> getAllMember() {

		// TODO Auto-generated method stub
		Connection conn = DBUtil3.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		
		try {
			String sql = "select * from mymember ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			System.out.println("id\t pass\t name\t tel\t addr 순");
			System.out.println("-------------------------------");
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
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
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		int res = 0; // 반환값
		
		try {
			conn=DBUtil3.getConnection();
			String sql = "select count(*) from mymember where mem_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			rs=ps.executeQuery();
			if(rs.next()) {
				res=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return res;
	}

	@Override
	public int updateMember2(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement ps = null;
		int res = 0;
		String sel="";
		String val="";
		if(memberVO.getMemAddr()!=null) {
			val=memberVO.getMemAddr();
			sel="mem_addr";
		}else if(memberVO.getMemName()!=null) {
			val=memberVO.getMemName();
			sel="mem_name";
		}else if(memberVO.getMemPass()!=null) {
			val=memberVO.getMemPass();
			sel="mem_pass";
		}else if(memberVO.getMemTel()!=null) {
			val=memberVO.getMemTel();
			sel="mem_tel";
		}
		
		try {
			conn=DBUtil3.getConnection();
			String sql = "update mymember set "+sel+"=? where mem_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, val);
			ps.setString(2, memberVO.getMemId());
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
		return res;
	}

	@Override
	public int updateMember3(MemberVO memberVO) {
		
		Connection conn = DBUtil3.getConnection();
		int res=0;
		PreparedStatement ps = null;
		String set="";
		if(memberVO.getMemAddr()!=null) {
			set+="mem_addr='"+memberVO.getMemAddr()+"',";
		}
		if(memberVO.getMemName()!=null) {
			set+="mem_name='"+memberVO.getMemName()+"',";
		}
		if(memberVO.getMemPass()!=null) {
			set+="mem_pass='"+memberVO.getMemPass()+"',";
		}
		if(memberVO.getMemTel()!=null) {
			set+="mem_tel='"+memberVO.getMemTel()+"',";
		}
		
		if(set=="") {
			return 0;
		}
		
		if(set.charAt(set.length()-1)==',') {
			set=set.substring(0, set.length()-1);
		}
		
		try {

			String sql = "update mymember set "+set+" where mem_id=?";
			ps = conn.prepareStatement(sql);
			
	
			ps.setString(1,memberVO.getMemId());
			
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
		return res;
		
		
	}

}
