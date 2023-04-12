package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 문자기반 스트림을 이용하여 파일 내용 읽어와 출력하기
		FileReader fr = null;
		
		try {
			fr= new FileReader("d:/d_other/test.txt");
			int c;
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
