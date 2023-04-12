package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObject so = new ShareObject();
		
		TestThread t1 = new TestThread("1번쓰레드", so);
		TestThread t2 = new TestThread("2번쓰레드", so);
		
		t1.start();
		t2.start();
		
	}
}

//공통으로 사용할 클래스
class ShareObject{
	private int sum=0;
	//public synchronized void add() { //방법1. 메소드에 동기화 설정하기
	public void add() {
		
		synchronized (this) { //방법2. 동기화 블럭으로 설정하기
			int n=sum;
			n+=10;
			sum=n;
			System.out.println(Thread.currentThread().getName()+"합계: "+sum);
		}
	}
}

// 처리할 쓰레드 클래스
class TestThread extends Thread{
	private ShareObject sObj;
	
	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		
		for(int i=1; i<=10; i++) {
			sObj.add();
		}
		
	}
	
}




