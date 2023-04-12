package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class tsee {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			//객체를 파일에 저장하기
			FileOutputStream fout = new FileOutputStream("./src/kr/or/ddit/basic/phoneData.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			//쓰기(저장)작업
			
			oout.writeObject(null); //마지막에 null값을 저장하여 eofexception을 예방
			System.out.println("저장 완료");
			
			oout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
