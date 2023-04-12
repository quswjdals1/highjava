package kr.or.ddit.basic.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		MySingleton test1 = MySingleton.getInstance();
		MySingleton test2 = MySingleton.getInstance();
		
		System.out.println("test1: "+test1.toString());
		System.out.println("test2: "+test2.toString());
		
		System.out.println(test1==test2);
	}
}
