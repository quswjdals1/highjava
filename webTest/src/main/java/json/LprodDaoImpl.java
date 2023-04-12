package json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;

public class LprodDaoImpl implements ILprodDao {

	private static ILprodDao dao;
	
	private LprodDaoImpl() {
		
	}
	
	public static ILprodDao getInstance() {
		if(dao==null) {
			dao=new LprodDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<LprodVO> list = session.selectList("selectLprod");
		session.close();
		

		return list;
	}

}
