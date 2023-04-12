package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Stack;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여
 * 결과를 받아오고, 받아온 결과를 Controller에게 보내주는 역할을 한다.
 * 
 * (자바 고급과정에서는 보통 DAO와 메서드의 구조가 같게 한다.)
 * 
 * @author PC-26
 *
 */

public interface IMemberService {
	
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

	/**
	 * MemberVO객체에 담겨진 자료를 이용하여 DB에 update하는 메소드
	 * (1개의 값에 대해서만 수정)
	 * 
	 * @param memberVO update할 회원정보가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0ㅂ
	 */
	public int updateMember2(MemberVO memberVO);

	public int updateMember3(MemberVO memberVO);
	
}
