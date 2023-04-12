package member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.util.MybatisSqlSessionFactory;
import member.vo.MemberVO;

public class MemberDao {
	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao==null) dao=new MemberDao();
		return dao;
	}
	
	public List<MemberVO> getAllMember(){
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<MemberVO> list = session.selectList("getAllMember");
		session.close();
		
		return list;
	}
	
	public MemberVO getMember(String mem_id){
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		MemberVO memberVO = session.selectOne("getMember",mem_id);
		session.close();
		
		return memberVO;
	}
	
	public int insertMember(MemberVO memberVO) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res = session.insert("insertMember",memberVO);
		session.commit();
		session.close();
		
		return res;
		
	}
	
	public int dupMember(String id) {
		SqlSession session= MybatisSqlSessionFactory.getSqlSession();
		int res = session.selectOne("dupMember",id);
		session.close();
		return res;
	}
	
	public int deleteMember(String id) {
		SqlSession session= MybatisSqlSessionFactory.getSqlSession();
		int res = session.delete("deleteMember",id);
		session.commit();
		session.close();
		return res;
	}
	
	public int updateMember(MemberVO memberVO) {
		SqlSession session= MybatisSqlSessionFactory.getSqlSession();
		int res = session.update("updateMember",memberVO);
		session.commit();
		session.close();
		return res;
		
	}
	
	public String selectPhoto(String mem_id) {
		
		SqlSession session= MybatisSqlSessionFactory.getSqlSession();
		String photo = session.selectOne("selectPhoto",mem_id);
		session.close();
		return photo;
	}
}
