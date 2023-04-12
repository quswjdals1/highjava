package kr.or.ddit.basic;

import java.sql.Time;

public class ThreadTest03 {
	public static void main(String[] args) {
	//Thread 실행시간 체크해보기
	
		Thread t = new Thread(new MyRunner());
		long start = System.currentTimeMillis();
		t.start();
		
		try {
			t.join(); //현재 위치에서 대상이 되는 쓰레드(t)가
					  //끝날때까지 기다린다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum=0L;
		for (long i = 1; i <=1000000000L; i++) {
			sum+=i;
		}
		System.out.println("합계: "+sum );
	}
}