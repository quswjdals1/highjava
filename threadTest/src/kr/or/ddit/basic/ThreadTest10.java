package kr.or.ddit.basic;
//yield 메소드 연습용

public class ThreadTest10 {
	public static void main(String[] args) {
		YieldThread t1 = new YieldThread("1번쓰레드");
		YieldThread t2 = new YieldThread("2번쓰레드");
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("111111111111-------------------------------------------");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work=false;
		System.out.println("222222222222-------------------------------------------");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.work=true;
		System.out.println("333333333333-------------------------------------------");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.stop=true;
		t2.stop=true;
	}
}

//yield() 연습용 쓰레드
class YieldThread extends Thread{
	public boolean stop=false;
	public boolean work= true;
	
	public YieldThread(String name) {
		super(name);

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop) {
			if(work) {
				System.out.println(getName()+"작업중..");
			}else {
				System.out.println(getName()+"양보");
				Thread.yield();
			}
		}
		System.out.println(getName()+"종료");
	}
	
}