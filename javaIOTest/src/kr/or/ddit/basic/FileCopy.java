package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	
	문제) 'd:/d_other' 폴더에 있는 컴퓨터1.jpg 파일을
		 'd:/d_other/연습용' 폴더에 '복사본_컴퓨터1.jpg'파일로 복사하는 프로그램을
		 작성하시오.

*/
public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("d:/d_other/컴퓨터1.jpg");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fw = new FileOutputStream("d:/d_other/연습용/복사본_컴퓨터1.jpg");
			int c;
			while((c=fis.read())!=-1) {
				fw.write(c);
			}
			fis.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
