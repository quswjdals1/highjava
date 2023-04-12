package kr.or.ddit.basic;

import java.util.ResourceBundle;

/*

ResourceBundle객체 ==> 파일의 확장자가 .properties인 파일의 내용을 읽어와서
key값과 value값으로 분리해서 정보를 갖는 객체
(읽어올 파일의 내용은 key값=value값 형태로 작성되어야 한다.)

*/
public class ResourceBundleTest {

	public static void main(String[] args) {
		// ResourceBundle객체를 이용하여 파일 읽어오기
		
		// ResourceBundle객체 생성
		//	==>읽어올 파일을 지정할때 "패키지명.파일명"까지만 지정(확장자명 없이)
		
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		
		System.out.println(bundle.getString("url"));
		
		
	}

}
