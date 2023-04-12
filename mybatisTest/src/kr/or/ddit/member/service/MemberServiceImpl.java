package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//일을 시킬 DAO객체 변수 선언
	private static MemberServiceImpl memberServiceImpl;
	private IMemberDao dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if(memberServiceImpl==null) {
			memberServiceImpl=new MemberServiceImpl();
		}
		return memberServiceImpl;
	}
	
	@Override
	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return dao.insertMember(memberVO);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return dao.updateMember(memberVO);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return dao.updateMember2(memberVO);
	}

	@Override
	public int updateMember3(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return dao.updateMember3(memberVO);
	}

}
