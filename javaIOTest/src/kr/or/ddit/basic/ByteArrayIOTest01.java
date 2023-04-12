package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9,};
		byte[] outSrc=null;
		
		ByteArrayInputStream input=null; //입력용 스트림 객체변수
		ByteArrayOutputStream output =null; //출력용 스트림 객체변수
		
		input = new ByteArrayInputStream(inSrc); //입력용 스트립 객체 생성
		output = new ByteArrayOutputStream();
		
		int data; // 읽어온 데이터가 저장될 변수 선언
		
		try {
			while((data=input.read())!=-1) {//더이상 읽을 스트림 데이터가 없으면 -1을 반환
				//읽어온 데이터 사용
				output.write(data); //데이터 출력하기
				System.out.println(data);
			}
			
			//출력된 스트림 값들을 배열로 변환해서 저장하기
			outSrc=output.toByteArray();
			input.close();
			output.close();
			
			System.out.println("inSrc: "+Arrays.toString(inSrc));
			System.out.println("outSrc: "+Arrays.toString(outSrc));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
