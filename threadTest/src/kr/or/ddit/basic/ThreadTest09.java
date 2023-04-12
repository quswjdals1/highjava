package kr.or.ddit.basic;

//쓰레드의 상태를 출력하는 예제
public class ThreadTest09 {
	public static void main(String[] args) {
		StatePrintThread th=new StatePrintThread(new TargetThread());
		th.start();
	}
}

//쓰레드 상태 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double sum=0.0;
		for (long i = 1l; i <2000000000l; i++) {
			sum+=i;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		for (long i = 1l; i <2000000000l; i++) {
			sum+=i;
		}
	}
}

//TargetThread의 상태를 검사해서 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	
	
	public StatePrintThread(TargetThread target) {
		this.target = target;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Thread.State state = target.getState();
			System.out.println("taraget의 현재 상태값: "+state);
			
			if(state==Thread.State.NEW) {
				target.start();
			}
			if(state==Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}