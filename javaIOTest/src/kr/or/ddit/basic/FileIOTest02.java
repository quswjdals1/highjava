package kr.or.ddit.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileIOTest02 {
	public static void main(String[] args) {
		//바이트 기반의 파일 출력용 스트립을 이용해서 파일로 출력하기
		
		FileOutputStream fout = null;
		
		try {
			File f = new File("D:/D_OTHER/OUT.TXT");
			fout = new FileOutputStream(f); //파일 출력용 스트림 객체 생성
			
			for(char ch='A'; ch<='Z'; ch++) {
				fout.write(ch);
			}
			fout.flush();  //출력 버퍼에 남아있는 자료를 강제로 출력한다.
			
			System.out.println("작업 완료...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fout!=null) {try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
		
	}
}
