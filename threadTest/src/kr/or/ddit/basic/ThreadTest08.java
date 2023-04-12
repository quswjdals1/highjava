package kr.or.ddit.basic;

//데몬쓰레드 연습. 자동저장하는 쓰레드

public class ThreadTest08 {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		
		//데몬쓰레드로 설정하기. 반드시 start 호출 전에 설정
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("main쓰레드 종료");
	}
}

//3초에 한번 저장하는 쓰레드

class AutoSaveThread extends Thread{
	
	
	public void save() {
		System.out.println("작업내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
		while (true) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}