package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MybatisSqlSessionFactory;

/*

	lprod테이블에 새로운 데이터 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아서
	lprod_id는 현재의 lprod_id중에서 제일 큰값보다 1 크게한다.
	
	입력받은 lprod_gu가 이미 등록되어있으면 다시 입력받아서 처리한다.

	jdbc예제중 jdbcTest05.java를 mybatis를 사용한것으로 변경하시오
	==> mapper파일명은 jdbc-mapper.xml로 한다.
	
*/

public class jdbcToMybatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		SqlSession session = null;
		
		try {

			session=MybatisSqlSessionFactory.getSqlSession();
			String fv="";
			int res=0;
			while(true) {
				System.out.println("gu 입력>>");
				fv=sc.next();
				res = session.selectOne("test.selectIsExistId",fv);
				if(res>0) {
					System.out.println("중복된 아이디가 있습니다.");
				}else {
					break;
				}			
			}
			System.out.println("nm 입력>>");
			String nm = sc.next();
			int gid = session.selectOne("test.selectGreatestId");
			
			LprodVO lprodVO = new LprodVO();
			lprodVO.setLprod_id(gid);
			lprodVO.setLprod_nm(nm);
			lprodVO.setLprod_gu(fv);
			
			int insertRes = session.insert("test.insertLprod",lprodVO);
			
			if(insertRes>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		}finally {
			session.commit();
			session.close();
		}
	
		
		
	}

}
