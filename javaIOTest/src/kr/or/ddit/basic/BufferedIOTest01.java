package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		//입출력의 성능향상을 위해서 buffered스트림을 사용한다.
		FileOutputStream fout = null;
		BufferedOutputStream bout= null;
		
		try {
			fout= new FileOutputStream("d:/d_other/bufferTest.txt");
			
			//버퍼의 크기가 5인 버퍼스트림 객체 생성
			bout = new BufferedOutputStream(fout,5);
			for (char i = '1'; i <= '9'; i++) {
				bout.write(i);
			}
			bout.flush();
			System.out.println("작업 끝...");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bout!=null)
				try {
					bout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
}
