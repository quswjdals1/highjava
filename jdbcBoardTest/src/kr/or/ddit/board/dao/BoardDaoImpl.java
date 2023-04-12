package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.util.DBUtill;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao{
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		
	}

	public static BoardDaoImpl getInstance() {
		if(dao==null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	public int insertBoard(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement ps = null;
		int res=0;
		
		try {
			conn=DBUtill.getConnection();
			String sql="insert into JDBC_BOARD(board_no,board_title,board_writer,board_date,board_cnt,board_content)"
					+ "values(board_seq.nextVal,?,?,sysdate,0,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, boardVO.getBoardTitle());
			ps.setString(2, boardVO.getBoardWriter());
			ps.setString(3, boardVO.getBoardContent());
			
			res= ps.executeUpdate();
			
			if(res==1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	
	
	public BoardVO selectBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		BoardVO boardVO=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtill.getConnection();
			String sql = "select * from jdbc_board where board_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoardNo(rs.getInt(1));
				boardVO.setBoardTitle(rs.getString(2));
				boardVO.setBoardWriter(rs.getString(3));
				boardVO.setBoardDate(rs.getString(4));
				boardVO.setBoardCnt(rs.getInt(5));
				boardVO.setBoardContent(rs.getString(6));
				
				return boardVO;
			}
			else {
				return null;
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
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		return null;
			
	}
	
	public int countIncre(int boardNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		BoardVO boardVO=null;
		int res=0;
		
		try {
			conn=DBUtill.getConnection();
			String sql = "update jdbc_board \r\n"
					+ "set board_cnt=(select board_cnt from jdbc_board where board_no=?)+1\r\n"
					+ "where board_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			ps.setInt(2, boardNo);
			res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
			}
			
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	
	public List<BoardVO> selectBoards(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = DBUtill.getConnection();
			String sql="select * from jdbc_board ";
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				BoardVO b = new BoardVO();
				b.setBoardNo(rs.getInt(1));
				b.setBoardTitle(rs.getString(2));
				b.setBoardWriter(rs.getString(3));
				b.setBoardDate(rs.getString(4));
				b.setBoardCnt(rs.getInt(5));
				b.setBoardContent(rs.getString(6));
				list.add(b);
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
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {

		Connection conn = null;
		PreparedStatement ps = null;
		int res=0;
		
		try {
			conn=DBUtill.getConnection();
			String sql = "update jdbc_board \r\n"
					+ "set board_title=?, board_content=?, board_date=sysdate \r\n"
					+ "where board_no=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardVO.getBoardTitle());
			ps.setString(2, boardVO.getBoardContent());
			ps.setInt(3, boardVO.getBoardNo());
			res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
			}
			
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	public int deleteBoard(int boardNo) {

		Connection conn = null;
		PreparedStatement ps = null;
		BoardVO boardVO=null;
		int res=0;
		
		try {
			conn=DBUtill.getConnection();
			String sql = "delete from jdbc_board "+ "where board_no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardNo);
			res=ps.executeUpdate();
			
			if(res==1) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
			}
			
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
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
	public List<BoardVO> searchBoard(String keyword) {

		Connection conn = null;
		PreparedStatement ps = null;
		BoardVO boardVO=null;
		ResultSet rs=null;
		List<BoardVO> list = new ArrayList<>();
		try {
			conn=DBUtill.getConnection();
			String sql = "select * from jdbc_board where board_title like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoardNo(rs.getInt(1));
				boardVO.setBoardTitle(rs.getString(2));
				boardVO.setBoardWriter(rs.getString(3));
				boardVO.setBoardDate(rs.getString(4));
				boardVO.setBoardCnt(rs.getInt(5));
				boardVO.setBoardContent(rs.getString(6));
				list.add(boardVO);
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
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		return list;
	}
}
