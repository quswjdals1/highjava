package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(200);
			dout.writeFloat(123.45f);
			dout.writeBoolean(false);
			dout.writeUTF("ABCDabcd");
		
			dout.close();
			//--------------------------------------------------
			//출력한 자료 읽어오기
			DataInputStream din = new DataInputStream(new FileInputStream("d:/d_other/test.dat"));
			
			//datainputstream으로 자료를 읽어올때는 출력할때의 순서와 구조가 같아야한다.
			System.out.println("정수형"+din.readInt());
			System.out.println("실수형"+din.readFloat());
			System.out.println("boolean"+din.readBoolean());
			System.out.println("utf" + din.readUTF());
			din.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
