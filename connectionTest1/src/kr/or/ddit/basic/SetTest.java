package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int a=0;
		
		
		while(set.size()<3) {
			a=(int) (Math.random() * (9-1+1)) + 1;
			set.add(a);
		}
		List<Object> list = new ArrayList<>(set);
		Object[] arr = set.toArray();
		Collections.shuffle(list);
		int cnt=0;
		while(true) {
			cnt++;
			int b=sc.nextInt();
			int c=sc.nextInt();
			int d=sc.nextInt();
			
			if(list.get(0).equals(b)&&list.get(1).equals(c)&&list.get(2).equals(d)) {
				System.out.println("3s0b");
				System.out.println("축하합니다."+cnt+"번째에 맞췄습니다.");
				break;
			}else if(list.get(0).equals(b)&&list.get(1).equals(c)&&!list.get(2).equals(d)
					||list.get(0).equals(b)&&!list.get(1).equals(c)&&list.get(2).equals(d)
					||!list.get(0).equals(b)&&list.get(1).equals(c)&&list.get(2).equals(d)) {
				System.out.println("2s1b");
			}else if(list.get(0).equals(b)&&!list.get(1).equals(c)&&!list.get(2).equals(d)
					||!list.get(0).equals(b)&&list.get(1).equals(c)&&!list.get(2).equals(d)
					||!list.get(0).equals(b)&&!list.get(1).equals(c)&&list.get(2).equals(d)) {
				System.out.println("1s2b");
			}else {
				System.out.println("0s3b");
			}
		}
	}
}
