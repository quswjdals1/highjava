package member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.dao.MemberDao;
import member.util.MybatisSqlSessionFactory;
import member.vo.MemberVO;

public class MemberService {
	private static MemberService service;
	private static MemberDao dao;
	private MemberService() {
		dao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		if(service==null) service = new MemberService();
		return service;
	}
	
	
	public List<MemberVO> getAllMember(){
		return dao.getAllMember();
	}
	
	public MemberVO getMember(String mem_id){
		return dao.getMember(mem_id);
	}
	
	public int insertMember(MemberVO memberVO) {
		return dao.insertMember(memberVO);
	}
	
	public int dupMember(String id) {
		return dao.dupMember(id);
	}
	
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}
	
	public int updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}
	
	public String selectPhoto(String mem_id) {
		return dao.selectPhoto(mem_id);
	}
}
