package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

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
		// TODO Auto-generated method stub
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.insert("insertMember",memberVO);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.delete("deleteMember",memId);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.update("updateMember",memberVO);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		List<MemberVO> list = session.selectList("selectAllMember");
		session.close();
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.selectOne("getMemberCount",memId);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int updateMember2(MemberVO memberVO) {
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.update("updateMember2",memberVO);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int updateMember3(MemberVO memberVO) {
		SqlSession session=null;	
		session= MybatisSqlSessionFactory.getSqlSession();	
		int res=session.update("updateMember3",memberVO);
		session.commit();
		session.close();
		return res;
	}
	


}
