package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		
		Thread t1 = new DataInput();
		Thread t2 = new CountDown();
		
		t1.start();
		t2.start();
		
	}
}


//데이터를 입력하는 쓰레드
class DataInput extends Thread{
	
	//입력여부 확인 변수
	public static boolean input;
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		if(str!=null) {
			input=true;
		}
		System.out.println("입력한 값: "+str);
	}
	
}

//카운트다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			if(DataInput.input) {
				return;	//run 메소드가 종료되면 해당 쓰레드도 종료된다.
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("시간이 초과되었습니다. 프로그램을 멈춥니다.");
		System.exit(0);

	}
}