package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VectorTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new ArrayList<>();
		
		list.add("asdasdas");
		list.add("qweqweqweqwewqeqwr");
		list.add("gfdsgdfgfdg");
		list.add("gfhfghfggg");
		list.add("qasd");
		
		int max=0;
		int idx=0;
		for (int i = 0; i < list.size(); i++) {
			if(max<list.get(i).length()) {
				max=list.get(i).length();
				idx=i;
			}
		}

		System.out.println(list.get(idx));
		
		
	}
}
