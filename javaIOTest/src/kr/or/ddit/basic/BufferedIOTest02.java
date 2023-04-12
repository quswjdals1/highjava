package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자 기반의 bufferedstream 사용하기
		BufferedReader br = null;
		
		try {
			//이클립스에서 자바 프로그램이 실행되는 현재위치는 실행 프로젝트 폴더이다.
			br = new BufferedReader(new FileReader("./src/kr/or/ddit/basic/FileTest01.java"));
			String temp=""; //읽어온 문자열이 저장될 변수
			//문자기반의 입력용 버퍼스트림은 한줄단위로 읽어오는 메소드를 갖는다
			//==>readLine(): 더이상 읽어올 데이터가 없으면 null 반환
			
		
//			while((temp=br.readLine())!=null) {
//				System.out.println(temp);
//			}
			for(int i=1; (temp=br.readLine())!=null; i++) {
				System.out.println(temp);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
