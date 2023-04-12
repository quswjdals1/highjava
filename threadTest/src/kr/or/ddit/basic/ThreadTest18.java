package kr.or.ddit.basic;

/*
	wait(), notify() 메소드를 이용한 두 쓰레드가 번갈아 한번씩 실행되는 예제
	
	 wait(), notify(), notifyAll() 메소드는 동기화 영역에서만 사용이 가능하다.
*/

public class ThreadTest18 {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		Thread t1 = new ThreadA(workObject);
		Thread t2 = new ThreadB(workObject);
		t1.start();
		t2.start();
	}
}

//공통으로 사용할 객체
class WorkObject{
	public synchronized void testMethodA() {
		System.out.println("testMethodA()메소드 실행중...");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void testMethodB() {
		System.out.println("testMethodB()메소드 실행중...");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//workObject의 testMethodA() 메소드만 호출하는 쓰레드

class ThreadA extends Thread{
	private WorkObject workObj;
	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			workObj.testMethodA();
		}
		// 마지막에 waiting pool에 있는 쓰레드 깨워주기
		// wait, notify메소드는 동기화 영역에서만 사용가능
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
}

//workObject의 testMethodB() 메소드만 호출하는 쓰레드

class ThreadB extends Thread{
	private WorkObject workObj;
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.testMethodB();
		}
		// 마지막에 waiting pool에 있는 쓰레드 깨워주기
		// wait, notify메소드는 동기화 영역에서만 사용가능
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
}