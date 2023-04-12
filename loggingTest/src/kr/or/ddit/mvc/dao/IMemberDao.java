package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Stack;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 sql문을 수행하여 결과를 작성해서 
 * service에게 전달하는 DAO의 interface
 * 
 * 하나의 메소드는 DB와 관련된 작업을 한개만 수행해야 한다.
 * 
 * @author PC-26
 *
 */

public interface IMemberDao {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메소드
	 * 
	 * @param memberVO insert할 데이터가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int insertMember(MemberVO memberVO);
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메소드
	 * 
	 * @param memId 삭제할 회원ID
	 * @return 삭제 성공: 1, 삭제 실패: 0
	 */
	public int deleteMember(String memId);

	/**
	 * MemberVO객체에 담겨진 자료를 이용하여 DB에 update하는 메소드
	 * 
	 * @param memberVO update할 회원정보가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0ㅂ
	 */
	public int updateMember(MemberVO memberVO);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아서 반환하는 메소드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember(); 

	/**
	 * 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메소드
	 * 
	 * @param memId 검색할 회원 ID 
	 * @return 검색된 회원ID의 개수
	 */
	public int getMemberCount(String memId);

	public int updateMember2(MemberVO memberVO);

	public int updateMember3(MemberVO memberVO);

}
