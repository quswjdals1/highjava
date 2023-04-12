package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class MapTest2 {
/*
 * 1. 번호등록
 * 2. 수정
 * 3. 삭제
 * 4. 검색
 * 5. 전체출력
 * 0. 프로그램종료
 * map의 구조: key값은 이름, value는 phone객체
 * 
 * 
 * 추가조건)
 * 1) 6. '전화번호 저장' 메뉴를 추가하고 구현한다.
 * 저장 파일명: 'phoneData.bin'
 * 2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
 * 3) 프로그램을 종료할 때 Map의 데이터의 변화가 있으면
 *  (데이터의 추가, 수정, 삭제작업 후 ) 자료를 저장한 후 종료되도록 한다.
 * 
 * */
	
	public static Map<String,Phone> getsaveData(){
		try {
			Map<String,Phone> map = new HashMap<>();
			File file =new File("./src/kr/or/ddit/basic/phoneData.bin");
			if(!file.exists()) {
				return map;
			}
			ObjectInputStream oin = new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(file)
								)
					);
			
			Object obj;
			
			//readObject는 데이터를 다 읽으면 eof exception을 발생한다.
			while ((obj=oin.readObject())!=null) {
				//읽어온 데이터를 원래의 객체형으로 형변환 후 사용한다.
				Phone p = (Phone)obj;
				
				map.put(p.getName(), p);
			}	
			oin.close();
			return map;
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
		return null;
		
		
	}
	
	public static void saveData(Map<String,Phone> map){
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("./src/kr/or/ddit/basic/phoneData.bin")
								)
					);
			
			for (Map.Entry<String, Phone> entry : map.entrySet()) {
				oout.writeObject(entry.getValue());	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<String,Phone> map =getsaveData();
		Map<String,Phone> pm=null;
		if(map==null) {
			map=new HashMap<>();
		}
		
		int sel=-1;
		out:while(true) {
			
			String name; String add; String num;
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 전화번호 저장");
			System.out.println("0. 전화번호 종료");
			sel=Integer.parseInt(sc.nextLine());
			
			switch(sel) {
				case 1:
					System.out.println("새롭게 등록할 이름을 입력하세요");
					name=sc.nextLine();
					if(map.containsKey(name)) {
						System.out.println(name+"은 이미 등록된 사람입니다.");
						break;
					}
					System.out.println("새롭게 등록할 주소를 입력하세요");
					add=sc.nextLine();
					System.out.println("새롭게 등록할 번호를 입력하세요");
					num=sc.nextLine();
					map.put(name, new Phone(name, add, num));
					System.out.println("등록이 완료 되었습니다.");
					break;
				case 2:
					System.out.println("수정할 등록할 이름을 입력하세요");
					name=sc.nextLine();
					if(!map.containsKey(name)) {
						System.out.println(name+"은 없는 사람입니다.");
						break;
					}
					System.out.println("수정할 등록할 주소를 입력하세요");
					add=sc.nextLine();
					System.out.println("수정할 등록할 번호를 입력하세요");
					num=sc.nextLine();
					map.put(name, new Phone(name, add, num));
					System.out.println("수정이 완료 되었습니다.");
					break;
				case 3:
					System.out.println("삭제할 등록할 이름을 입력하세요");
					name=sc.nextLine();
					if(!map.containsKey(name)) {
						System.out.println(name+"은 없는 사람입니다.");
						break;
					}
					map.remove(name);
					System.out.println("삭제가 완료 되었습니다.");
					break;	
				case 4:
					System.out.println("검색할 등록할 이름을 입력하세요");
					name=sc.nextLine();
					if(!map.containsKey(name)) {
						System.out.println(name+"은 없는 사람입니다.");
						break;
					}
					Phone p1 = map.get(name);
					System.out.print("이름:");
					System.out.println(p1.getName());
					System.out.print("주소:");
					System.out.println(p1.getAddress());
					System.out.print("번호:");
					System.out.println(p1.getNum());
					break;
				case 5:
					System.out.println("모든 전화번호 출력");
					Set<Entry<String, Phone>> set = map.entrySet();
					for (Map.Entry<String, Phone> entry : map.entrySet()) {
						System.out.println(entry.getKey()+" "+entry.getValue().toString());						
					}
					break;
				case 6:
					pm = getsaveData();
					if(map.equals(pm)) {
						System.out.println("변경내용 없습니다.");
					}else {
						System.out.println("변경내용이 있습니다.");
						saveData(map);
						System.out.println("저장완료");
					}
					
					break;
				case 0:
					pm = getsaveData();
					if(map.equals(pm)) {
						System.out.println("변경내용 없습니다.");
					}else {
						System.out.println("변경내용이 있습니다.");
						saveData(map);
						System.out.println("저장완료");
					}
					System.out.println("프로그램 종료");
					break out;
			}
		}
		
		
	}
}

class Phone implements Serializable{
	private String name;
	private String address;
	private String num;
	public Phone(String name, String address, String num) {
		super();
		this.name = name;
		this.address = address;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, name, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name)
				&& Objects.equals(num, other.num);
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", address=" + address + ", num=" + num + "]";
	}
	
	
}