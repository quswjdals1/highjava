package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
 * 컴퓨터의 가위바위보는 난수를 이용해서 구하고. 사용자의 가위바위보는
 * showInputDialog()메소드를 이용하여 입력받는다.
 * 입력시간은 5초로 제한하고 카운트다운
 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 * 
 * 결과예시)
 * 1. 5초안에 입력못했을경우
 * 	--결과--
 * 	시간초과로 패배
 * 
 * 2. 5초안에 입력했을경우
 * 	--결과--
 * 컴퓨터:가위
 * 사용자:바위
 * 결과:당신이 이겼습니다.
 */


public class ThreadTest07 {

	public static void main(String[] args) {
		Thread t1 = new DataInput1();
		Thread t2 = new CountDown1();
		t1.start();
		t2.start();
		
	}

}

class DataInput1 extends Thread{
	static String str;
	@Override
	public void run() {
		str = JOptionPane.showInputDialog("가위바위보 입력:");
		int com= (int) Math.random() * 3+1;
		//1:가위, 2:바위, 3:보
		String c="";
		switch(com) {
			case 1:
				c="가위";
				break;
			case 2:
				c="바위";
				break;
			case 3:
				c="보";
				break;
			default:
				break;
		}

		String result="";
		if(str.equals("가위")&&com==1||str.equals("바위")&&com==2
				||str.equals("보")&&com==3) {
			result="무승부 입니다.";
		}else if(str.equals("가위")&&com==2||str.equals("바위")&&com==3
				||str.equals("보")&&com==1) {
			result="패배하셨습니다.";
		}else {
			result="승리하셨습니다.";
		}
		System.out.println("-----결과-----");
		System.out.println("사용자: "+str);
		System.out.println("컴퓨터: "+c);
		System.out.println(result);
		
	}
}

class CountDown1 extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			if(DataInput1.str!=null) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-----결과-----");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}