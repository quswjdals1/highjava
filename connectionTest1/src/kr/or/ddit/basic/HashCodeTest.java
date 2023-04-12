package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashCodeTest {
	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setName("홍길동");
		p1.setNum(1);
		
		Person p2 = new Person();
		p2.setName("홍길동");
		p2.setNum(1);
		
		System.out.println(p1.equals(p2));
		
		Set<Person> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());


	}
}


class Person{
	private int num;
	private String name;
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
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
	
	
}