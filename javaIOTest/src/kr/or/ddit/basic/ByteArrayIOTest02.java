package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9,};
		byte[] outSrc=null;
		byte[] temp= new byte[4];
		
		ByteArrayInputStream input=null; //입력용 스트림 객체변수
		ByteArrayOutputStream output =null; //출력용 스트림 객체변수
		
		input = new ByteArrayInputStream(inSrc); //입력용 스트립 객체 생성
		output = new ByteArrayOutputStream();
		try {
			// 읽어올 데이터가 있는 지 확인하는 부분
			while(input.available()>0) {
				//input.read(temp); //temp의 크기가 4이므로 4byte씩 읽음
				//output.write(temp);
				
				int len = input.read(temp); //배열(temp)를 이용한 read() 메소드는
											// 실제 읽어온 데이터 갯수를 반환한다.
				
				output.write(temp,0,len);//temp배열의 내용중 0번째에서 len개 만큼만 출력한다.
				System.out.println("실제 읽어온 갯수: "+len);
				System.out.println("반복문 안에 temp: "+Arrays.toString(temp));
			}
			outSrc=output.toByteArray();
			
			input.close();
			output.close();
			
			System.out.println("inSrc: "+Arrays.toString(inSrc));
			System.out.println("outSrc: "+Arrays.toString(outSrc));
			//inSrc: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			//outSrc: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
