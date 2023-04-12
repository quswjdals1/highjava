package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.basic.vo.MemberVO;
import kr.or.ddit.util.MybatisSqlSessionFactory;

public class MemberDao {

	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDao();
		}
		return dao;
	}

	public MemberVO getMember(MemberVO memberVO) {
		SqlSession session = null;
		MemberVO logMemberVO = null;
		
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			logMemberVO = session.selectOne("member.getMember", memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return logMemberVO;
		
	}
	
}
