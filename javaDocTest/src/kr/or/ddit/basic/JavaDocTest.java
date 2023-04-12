package kr.or.ddit.basic;
//javaDoc 파일만들기 예제 ==> 프로그램과 메뉴얼을 같이 만드는 방법
/**
 * 
 * @author PC-26
 * @version 1.0
 * 
 * <p>
 * 파일명: JavaDocTest.java<br>
 * 설명: JavaDoc문서 작성을 위한 연습용 interface<br><br>
 * 
 * 수정이력<br>
 * ---------------------<br>
 * 수정일자: 2023-03-17<br>
 * 작 성 자: bjm<br>
 * 수정내용: 최초작성<br>
 * </p>
 */
public interface JavaDocTest {
	/**
	 * 메소드명: method<br>
	 * 설명: 반환값이 없는 메소드<br>
	 * 
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번째 매개변수 (정수형)
	 */
	public void method(int a,int b);
	
	/**
	 * 메소드명: methodAdd<br>
	 * 설명: 반환값이 있는 메소드<br>
	 * @param x 첫번째 정수형 매개변수
	 * @param y 두번째 정수형 매개변수
	 * @return 처리된 결과가 정수형으로 반환된다.
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메소드명: methodSub<br>
	 * 설명: 반환값이 없는 메소드<br>
	 * 
	 * @return
	 */
	public int methodSub();
	
}
