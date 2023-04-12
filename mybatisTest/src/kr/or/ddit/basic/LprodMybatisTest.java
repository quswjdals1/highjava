package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//mybatis를 이용하여 DB자료를 처리하는 순서 및 방법

public class LprodMybatisTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. mybatis의 환경 설정 파일을 읽어와서 실행한다. (mybatis-config.xml)
		
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			//1-1. 환경설정 파일을 읽어 올 스트림 객체를 생성한다.
			//	   (이때 읽어올 환경설정 파일을 지정해준다.)
			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			//1-2. 환경설정 파일을 읽어와 환경설정을 완성한 후 sql문을 호출해서 실행할 수 있는
			//	   객체를 생성하는 SQLSessionFactory객체를 생성한다.
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("mybatis 초기화 실패");
			e.printStackTrace();
		}finally {
			if(rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		//------------------------------------------------------------------------------------
	SqlSession session=null;
	/*	
		//2. mapper에 등록된 sql문 중에서 실행할 sql문을 호출해서 원하는 작업을 수행한다.
		
		//SqlSession 객체 ==> 실제 sql문을 읽어와 처리하고 결과를 얻어오는 객체
		
		
		//2.1 insert 작업
		System.out.println("insert 작업 시작...");
		
		System.out.print("lprod_id 입력 >>");
		int lprodId=sc.nextInt();
		
		System.out.print("lprod_gu 입력 >>");
		String lprodGu=sc.next();
		
		System.out.print("lprod_nm 입력 >>");
		String lprodNm=sc.next();
		
		LprodVO lprodVO = new LprodVO();
		lprodVO.setLprod_gu(lprodGu);
		lprodVO.setLprod_id(lprodId);
		lprodVO.setLprod_nm(lprodNm);
		
		try {
			// SqlSessionFactory 객체를 이용하여 SqlSession객체를 구한다.
			//		==> openSessiont()메소드를 이용한다.
			// 형식) SqlSessionFactory객체.openSession(논리값)
			// 		==> 논리값이 true이면 autocommit이 활성화 된 상태이고.
			//		==> 논리값이 false이면 autocommit이 비활성화 된 상태이다.(기본값)
			session = sqlSessionFactory.openSession();
			
			// SqlSession 객체변수를 이용하여 처리할 SQL문을 호출해서 실행한다.
			// 형식) session.insert("namespace속성값.id속성값",파라미터클래스)
			//			==> 반환값 : 작업에 성공한 레코드 수
			int insertCnt = session.insert("insertLprod",lprodVO);
			
			if(insertCnt>0) {
				System.out.println("insert 작업 성공");
			}else {
				System.out.println("insert 작업 실패");
			}
		} finally {
			// SqlSession을 생성할 때 AutoCommit이 비활성화된 상태일 때는 commit을 직접 실행해야 한다.
			session.commit();
			
			//작업이 완료되면 session을 닫아준다.
			session.close();
		
		
		}
		*/
		
		//-------------------------------------------------------------------------------
		
	/*
		//2-2. update 연습
		System.out.println("update 연습 시작...");
		
		System.out.print("수정할 lprod_gu 입력 >>");
		String lprodGu=sc.next();
		
		System.out.print("lprod_id 입력 >>");
		int lprodId=sc.nextInt();
		
		System.out.print("lprod_nm 입력 >>");
		String lprodNm=sc.next();
		
		//입력받은 데이터를 vo객체에 저장한다.
		
		LprodVO lprodVO = new LprodVO();
		lprodVO.setLprod_gu(lprodGu);
		lprodVO.setLprod_id(lprodId);
		lprodVO.setLprod_nm(lprodNm);
		
		try {
			//SqlSessionFactory객체를 이용하여 sqlsession객체를 구한다.
			session= sqlSessionFactory.openSession();
			
			//sqlsession객체변수를 이용하여 처리할 sql문을 호출해서 실행한다.
			//형식) session.update("namespace속성값.id속성값",파라미터클래스);
			// 		==> 반환값: 작업에 성공한 레코드 수
			
			int updateCnt=session.update("lprod.updateLprod",lprodVO);
			
			if(updateCnt>0) {
				System.out.println("update 작업 성공");
			}else {
				System.out.println("update 작업 실패");
			}
			
		} finally {
			session.commit();
			session.close();
		}
		
		*/
	
	
	
	
	//---------------------------------------------------------------------------------------
	/*
	//2-3. delete 연습
	System.out.println("delete 연습 시작...");
	System.out.println("삭제할 lprod_gu");
	String lprodGu = sc.nextLine();
	
	try {
		session = sqlSessionFactory.openSession();
		int res=session.delete("lprod.deleteLprod",lprodGu);
		if(res>0) {
			System.out.println("delete 작업성공");
		}else {
			System.out.println("delete 작업실패");
		}
		
	} finally {
		session.commit();
		session.close();
	}
	*/
	
	
	//------------------------------------------------------------------------------------------
	
	// 2.4 select 연습
	
	/*
	// 1) 처리한 결과가 여러개의 레코드일 경우
	System.out.println("select 연습 시작(결과가 여러개일 경우)...");
	
	try {
		session=sqlSessionFactory.openSession();
		//select문의 처리결과가 여러개일 경우에는 selectList()메소드를 사용하는데
		//이 메소드는 여러개의 레코드 각각을 vo객체에 담은 후 이 vo객체를 list에 추가해 주는
		//작업을 자동으로 수행한다.
		//형식) session.selectList("namespace속성값.id속성값",파라미터클래스)
		//반환값: resultType에 설정된 자료형이 담긴 list객체를 반환한다.
		List<LprodVO> selectList = session.selectList("getAllLprod");
		
		for (LprodVO lprodVO : selectList) {
			System.out.println(lprodVO);
		}
	} finally {
		session.close();
	}
	*/
	
	// 2) 처리한 결과가 1개의 레코드일 경우
	System.out.println("select 작업 시작(결과가 1개일 경우)...");
	
	System.out.println("검색할 lprod_gu 입력 >>");
	String lprodGu = sc.next();
	
	try {
		session=sqlSessionFactory.openSession();
		
		//sqlsession객체변수를 이용하여 처리할 sql문을 호출해서 실행한다
		//select문의 처리결과가 1개 일 경우에는 selectOne()메서드를 사용한다.
		//형식) session.selectOne("namespace속성값.id속성값" 파라미터클래스);
		//반환값 : resultType에 설정한 자료형으로 반환한다.
		
		LprodVO lprodVO = session.selectOne("getLprod", lprodGu);
		
		if(lprodVO==null) {
			System.out.println("검색된 데이터가 없습니다.");
		}else {
		System.out.println(lprodVO);
		}
	} finally {
		session.close();
	}
	
	}
}
