package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		// 바이트 기반의 파일 입력용 스트림으로 파일내용 읽기
		
		FileInputStream fin=null; //파일 입력용 스트림 객체변수 선언
		
		try {
			//방법1
			//fin = new FileInputStream("D:/D_OTHER/TEST.TXT");
			
			//방법2
			File file = new File("D:/D_OTHER/TEST.TXT");
			fin=new FileInputStream(file);
			
			int c; //읽어올 데이터를 저장할 변수
			
			while((c=fin.read())!=-1) {
				
				System.out.print((char)c);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fin!=null) try {fin.close();}catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
