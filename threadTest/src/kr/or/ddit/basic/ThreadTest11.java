package kr.or.ddit.basic;

/*
 	thread의 stop()메소드를 호출하면 쓰레드가 바로 멈춘다.
 	이때 사용하던 자원을 정리하지 못하고 쓰레드가 종료되어
 	다른 쓰레드에 영향을 줄 수 있다.
 	그래서 stop()메소드는 비추천으로 되어 있다.
 */

public class ThreadTest11 {
	public static void main(String[] args) {
	/*
		 1. 쓰레드에 stop변수 선언 후,setStop을 이용한 방법 
		 
		ThreadStopTest1 t1 = new ThreadStopTest1(false);
		t1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.setStop(true);;
	*/
		
	//	2. interrupt 메소드를 이용한 방법
		
		ThreadStopTest2 t2 = new ThreadStopTest2();
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.interrupt();
	}
}

// 1. 쓰레드에 stop변수 선언 후,setStop을 이용한 방법 
class ThreadStopTest1 extends Thread{
	private boolean stop;

	public ThreadStopTest1(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 실행중..");
		}
		System.out.println("자원정리");
		System.out.println("쓰레드 종료");
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
}

// 2. interrupt() 메소드를 이용하여 쓰레드를 멈추는 방법
class ThreadStopTest2 extends Thread{
	@Override
	public void run() {		
		//2-1
		/*
		try {
			while(true) {
				System.out.println("Thread 실행중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {

		}
		
		
		*/
		
		//2-2 가장많이 쓰는 방법
		while(true) {
			System.out.println("실행중....");
			//interrupt 메소드가 호출되었는지 검사한다.
			
			
			//검사방법1. thread의 인스턴스 메서드인 isInterrupted()메소드 사용하기
			//isInterrupted는 interrupt메소드가 호출되면 true를 반환한다.
			
//			if(this.isInterrupted()) {
//				break;
//			}
			
			//검사방법2. thread의 정적메소드인 interrupted 메소드 이용하기
			if(Thread.interrupted()) {
				break;
			}
		}
		
		
		System.out.println("자원정리");
		System.out.println("쓰레드 종료");
	}
	
}