package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// 읽어온 정보를 저장할 Properties객체 생성
		Properties prop = new Properties();
		
		// 읽어올 파일명을 이용한 File객체 생성
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(f);
			
			// 입력 스트림을 이용하여 파일내용을 읽어와 properties 객체에 저장
			prop.load(fis); // ==> 파일내용을 읽어와 key값과 value값을 분류한 후
							// 	   분류된 정보를 properties 객체에 추가한다.
		
			//읽어온 데이터 출력하기
			System.out.println("driver: "+prop.get("driver").getClass());
			System.out.println("url: "+prop.get("url"));
			System.out.println("user: "+prop.get("user"));
			System.out.println("pass: "+prop.get("pass"));
			System.out.println("");
			System.out.println("driver: "+prop.getProperty("driver").getClass());
			System.out.println("url: "+prop.getProperty("url"));
			System.out.println("user: "+prop.getProperty("user"));
			System.out.println("pass: "+prop.getProperty("pass"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
