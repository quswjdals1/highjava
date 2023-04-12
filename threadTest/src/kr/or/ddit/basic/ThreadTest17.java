package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	vector, hashtable 등의 예전부터 존재하던 collection 객체들은
	내부에 동기화 처리가 되어있다.
	
	그런데 최근에 새로 구성된 collection 들은 동기화 처리가 되어있지 않다.
	그래서 동기화가 필요한 프로그램에서 이런 Collection객체들을 사용하려면
	동기화 처리를 한 후에 사용해야 한다.
	
*/

public class ThreadTest17 {
	//private static List<Integer> vec = new ArrayList<>();
	
	//동기화 처리로 바꾸면
	private static List<Integer> vec = Collections.synchronizedList(new ArrayList<>());
	
	
	public static void main(String[] args) {
		Runnable r =new Runnable() {
			public void run() {
				for(int i=0; i<10000; i++) {
					vec.add(i);
				}
			}
		};
	
		Thread[] arr = new Thread[] {
				new Thread(r),new Thread(r),new Thread(r),
				new Thread(r),new Thread(r)
		};
		
		for (Thread thread : arr) {
			thread.start();
		}
	
	
		for (Thread thread : arr) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(vec.size());
	
	}
	
}
