package kr.or.ddit.basic;

import java.sql.Time;

/*
 * 1~20억까지 합계를 구하는 프로그램을 하나의 쓰레드가 처리될떄와 여러개
 * 쓰레드가 처리할때의 시간을 비교해 보자
*/
public class ThreadTest04 {
	public static long sumAll=0l;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				long sum=0l;
				for (int i = 1; i <=2000000000l; i++) {
					sum+=i;
				}
				System.out.println("t1:"+sum);
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				long sum=0l;
				for (int i = 1; i <=500000000l; i++) {
					sum+=i;
				}
				System.out.println("t2:"+sum);
				ThreadTest04.sumAll+=sum;
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				long sum=0l;
				for (int i = 500000001; i <=1000000000l; i++) {
					sum+=i;
				}
				System.out.println("t3:"+sum);
				ThreadTest04.sumAll+=sum;
			}
		});
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				long sum=0l;
				for (int i = 1000000001; i <=1500000000l; i++) {
					sum+=i;
				}
				System.out.println("t4:"+sum);
				ThreadTest04.sumAll+=sum;
			}
		});
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				long sum=0l;
				for (int i = 1500000001; i <=2000000000l; i++) {
					sum+=i;
				}
				System.out.println("t5:"+sum);
				ThreadTest04.sumAll+=sum;
			}
		});
		
		long start = System.currentTimeMillis();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("쓰레드 1개 걸린시간: "+(end-start));
		

		start = System.currentTimeMillis();
		t2.start();t3.start();t4.start();t5.start();
		try {
			t2.join();t3.join();t4.join();t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println("쓰레드 4개 걸린시간: "+(end-start));
		System.out.println(sumAll);
		
		
	}
	
}