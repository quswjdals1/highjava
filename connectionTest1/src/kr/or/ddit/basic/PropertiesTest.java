package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
	
	/*properties객체는 map의 축소된 기능을 한다.
	 * key와 value는 String만 사용할 수 있다.
	 * 
	 * map은 put,get을 사용하지만 properties객체는 setproperty
	 * , getproperty 메소드를 사용한다.
	 * 
	 * 데이터를 파일로 입출력 할 수 있다.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "20");
		prop.setProperty("tel","010-3453-6677");
		prop.setProperty("addr", "대전");
		
		System.out.println(prop.getProperty("name"));
		
	}

}
