package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
	public static void main(String[] args) {
		
		List<String> l = new ArrayList<>();
		l.add("가");
		l.add("마");
		l.add("다");
		l.add("라");
		l.add("나");
		
		Collections.sort(l, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub			
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(l.toString());
	}
}
