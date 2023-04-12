package kr.or.ddit.basic.argTest;

public class ArgTest {
	
	

	//매개변수 a 는 가변형 인수로 인자를 여러 갯수로 받을 수 있다.
	//함수 내에서 a는 배열로 인식된다.
	//보통 기본 타입(String int 등)과 같이 쓸때는 가변형 인수를 맨 뒤에 적는다.
	public int sumArr(int b,int...a) {
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ArgTest test= new ArgTest();
		System.out.println(test.sumArr(1,2,3,4,5));
	}
}
