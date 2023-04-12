package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private static BoardServiceImpl service;
	private static BoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service==null) {
			service = new BoardServiceImpl();
		}
		return service;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVO);
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.selectBoard(boardNo);
	}

	@Override
	public int countIncre(int boardNo) {
		// TODO Auto-generated method stub
		return dao.countIncre(boardNo);
	}

	@Override
	public List<BoardVO> selectBoards() {
		// TODO Auto-generated method stub
		return dao.selectBoards();
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> searchBoard(String keyword) {
		// TODO Auto-generated method stub
		return dao.searchBoard(keyword);
	}
	
	
	
	
}
