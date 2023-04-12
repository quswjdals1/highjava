package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StudentTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"홍길동", 20, 95, 15));
		list.add(new Student(5,"이순신", 80, 90, 45));
		list.add(new Student(9,"성춘향", 50, 80, 55));
		list.add(new Student(3,"강감찬", 60, 5, 65));
		list.add(new Student(6,"일지매", 10, 10, 45));
		list.add(new Student(2,"변학도", 45, 35, 40));
		
		
		System.out.println("학번 정렬 후");
		System.out.println("-------------------------------");
		
		Collections.sort(list);
		for (Student student : list) {
			System.out.println(student.toString());
		}
		System.out.println("총점 정렬 후");
		System.out.println("-------------------------------");
		
		
		Collections.sort(list,new SortByTotal());
		for (Student student : list) {
			System.out.println(student.toString());
		}
		
		for (int i = 0; i <list.size(); i++) {
			list.get(i).setPre(i+1);
		}
		System.out.println("등수 적용");
		System.out.println("-------------------------------");
		
		for (Student student : list) {
			System.out.println(student.toString());
		}
		
		
	}

}


class SortByTotal implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.getTotal()-o2.getTotal()>0) {
			return -1;
		}else if(o1.getTotal()-o2.getTotal()<0) {
			return 1;
		}else {
			if(o1.getName().compareTo(o2.getName())>0) {
				return 1;
			}else if(o1.getName().compareTo(o2.getName())<0) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
}






class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int k;
	private int e;
	private int m;
	private int total;
	private int pre;
	
	public Student(int num, String name, int k, int e, int m) {
		this.num = num;
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;
		this.total=k+e+m;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getNum()-o.getNum();
	}

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

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", k=" + k + ", e=" + e + ", m=" + m + ", total=" + total
				+ ", pre=" + pre + "]";
	}
	
	
	
	
}