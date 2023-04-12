package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class alt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Object[]> set2= new HashSet<>();
		for (int i = 0; i < 3; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(3);
			set.add(2);
			set.add(1);
			set.add(0);
			
			set2.add(set.toArray());
		}
		Set<String> set3 = new HashSet<>();
		Set<String> set4 = new HashSet<>();
		set3.add("asdasd");
		set3.add("asdasd");
		System.out.println(set3.toString());
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("123 ");
		sb1.append("123 ");
		set4.add(sb.toString());
		set4.add(sb1.toString());
		System.out.println(set4.toString());
	}
}
