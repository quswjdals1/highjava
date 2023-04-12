package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ListSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> memList = new ArrayList<>();
		memList.add(new Member(1,"홍길동","010-0101-0101"));
		memList.add(new Member(5,"이순신","010-2222-2222"));
		memList.add(new Member(9,"성춘향","010-3333-0101"));
		memList.add(new Member(3,"강감찬","010-4444-0101"));
		memList.add(new Member(6,"일지매","010-5555-0101"));
		memList.add(new Member(2,"변학도","010-6666-0101"));
		
		
		System.out.println("정렬전");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
		
		Collections.sort(memList,new sortNumDesc());
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
	}

}

class sortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		return o2.getNum()-o1.getNum();
	}
	
}



class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}
