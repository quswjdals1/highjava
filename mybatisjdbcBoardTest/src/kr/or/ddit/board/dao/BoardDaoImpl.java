package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.MybatisSqlSessionFactory;import oracle.net.aso.b;
import oracle.net.ns.SessionAtts;

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

	@Override
	public int insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res =session.insert("insertBoard",boardVO);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		BoardVO res =session.selectOne("selectBoard",boardNo);
		session.close();
		return res;
	}

	@Override
	public int countIncre(int boardNo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res =session.update("countIncre",boardNo);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public List<BoardVO> selectBoards() {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<BoardVO> list = session.selectList("selectBoards");
		session.close();
		return list;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res =session.update("updateBoard",boardVO);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res =session.delete("deleteBoard",boardNo);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public List<BoardVO> searchBoard(String keyword) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<BoardVO> list = session.selectList("searchBoard");
		session.close();
		return list;
	}
	
	
}
