package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface BoardDao {
	
	/**
	 * 게시판 삽입
	 * @return 성공시 1 실패시 0
	 */
	public int insertBoard(BoardVO boardVO);
	
	/**
	 * 게시글 하나의 정보를 가져옴
	 * @param boardNo
	 * @return 성공시 게시판vo, 실패시 null
	 */
	public BoardVO selectBoard(int boardNo);
	
	/**
	 * 조회수를 증가시키는 
	 * @param boardNo
	 * @return 성공시 1, 실패시 0
	 */
	public int countIncre(int boardNo);
	
	/**
	 * 모든 게시글목록을 가져옴
	 * @return 성공시 리스트반환, 실패시 비어있는 리스트반환
	 */
	public List<BoardVO> selectBoards();
	/**
	 * 게시글을 업데이트함
	 * @return 성공시 1, 실패시 0
	 */
	public int updateBoard(BoardVO boardVO);
	
	/**
	 * 게시글을 삭제함
	 * @param boardNo
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteBoard(int boardNo);
		
	/**
	 * 게시글을 검색함
	 * @param keyword
	 * @return 성공시 검색된 vo객체를 포함한 list, 실패시 빈 list
	 */
	public List<BoardVO> searchBoard(String keyword);
}
