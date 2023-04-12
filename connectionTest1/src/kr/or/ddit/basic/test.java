package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Phone> map = new HashMap<String, Phone>();
		map.put("qwe",new Phone("asd", "qwe", "123"));
		map.put("asd",new Phone("asd", "qwe", "123"));
		map.put("123",new Phone("asd", "qwe", "123"));
		
			try {
				ObjectOutputStream oout = new ObjectOutputStream(
							new BufferedOutputStream(
									new FileOutputStream("./src/kr/or/ddit/basic/phoneData.bin")
									)
						);
				
				for (Map.Entry<String, Phone> entry : map.entrySet()) {
					oout.writeObject(entry.getValue());	
					System.out.println(entry.getValue());
				}
				oout.writeObject(null);
				//readObject는 데이터를 다 읽으면 eof exception을 발생한다.
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
