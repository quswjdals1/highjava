package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member mem1 = new Member("홍길동",20,"대전");
		Member mem2 = new Member("홍길서",30,"서전");
		Member mem3 = new Member("홍길남",40,"부전");
		Member mem4 = new Member("홍길북",50,"울전");
	
		try {
			//객체를 파일에 저장하기
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			//쓰기(저장)작업
			
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			oout.writeObject(null); //마지막에 null값을 저장하여 eofexception을 예방
			System.out.println("저장 완료");
			
			oout.close();
			
			System.out.println("----------------------------");
			//저장된 객체 읽어서 출력하기
			ObjectInputStream oin = new ObjectInputStream(
						new BufferedInputStream(new FileInputStream("d:/d_other/memObj.bin"))
					);
			Object obj;
			
			//readObject는 데이터를 다 읽으면 eof exception을 발생한다.
			while ((obj=oin.readObject())!=null) {
				//읽어온 데이터를 원래의 객체형으로 형변환 후 사용한다.
				Member mem = (Member)obj;
				
				System.out.println(mem);
				
			}
			oin.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class Member implements Serializable{
	private String name;
	private int age;
	private String addr;
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
}
