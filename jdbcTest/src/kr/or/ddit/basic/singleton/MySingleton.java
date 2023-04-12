package kr.or.ddit.basic.singleton;


/*

	singleton패턴 => 객체가 1개만 만들어지게 하는 방법

	장점: 메모리 낭비를 방지할 수 있다.(메소드 사용용 객체는 여러개 만들 필요없음)
		 데이터의 공유가 쉽다.
	
	구현방법
	1. 자신 class의 참조값이 저장될 변수를 private static 으로 선언한다
	2. 모든 생성자의 접근 제한자를 private으로 선언
	3. 자신 class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 작성한다.
		(이 메소드의 이름은 보통 getInstance로 한다.)
	
*/

public class MySingleton {

	private static MySingleton single;
	
	private MySingleton(){
	
	}

	public static MySingleton getInstance() {
		if(single==null) {
			single = new MySingleton();
		}
		return single;
	}
	public void displayTest() {
		System.out.println("싱글톤 클래스의 메소드가 실행됩니다.");
	}
	
}
