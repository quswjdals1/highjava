package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {

	public static void main(String[] args) {
		// 파일의 인코딩 방식을 지정해서 읽어오기
		try {
//			FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
//			FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
			
			//인코딩 방식을 지정해서 입출력하는 보조스트림
			//InputStreamReader => 입력용
			//OutputStreamWriter => 출력용
			
//			FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");
//			
//			InputStreamReader isr = new InputStreamReader(fin);
			
			// 인코딩 방식을 지정해서 읽어오기
			// 인코딩 방식 예시
			// - MS949 => 윈도우의 기본 한글 인코딩방식(ANSI랑 같다)
			// - UTF-8 => 유니코드 UTF-8 인코딩 방식
			// - US-ASCII => 영문 전용 인코딩 방식
			
			FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");
			// fileInputStream은 바이트 기반이다. 따라서 isr을 사용해서 바이트 기반=>문자열 기반으로 바꿔주는 작업을밑에서 한다.
			InputStreamReader isr = new InputStreamReader(fin,"ms949");
			
			
			
			int c;
			
			while((c=isr.read())!=-1) {
				System.out.print((char)c);
			}
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
