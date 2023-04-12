package kr.or.ddit.basic;

//쓰레드에서 객체를 공통으로 사용하는 예제

/*
	원주율을 계산하는 쓰레드와 
	계산된 원주율을 출력하는 쓰레드가 있다.
	
	원주율을 저장하는 객체가 필요하다.
	이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
*/

public class ThreadTest14 {
	public static void main(String[] args) {
		ShareData sd = new ShareData();
		CalcPI cp = new CalcPI();
		PrintPI pp = new PrintPI(sd);
		pp.start();
		cp.setSd(sd);
		cp.start();
		
		
	}
}

//원주율을 관리하는 클래스(공통으로 사용될 클래스)
class ShareData{
	public double result; //계산된 원주율이 저장될 변수
	public boolean isOk=false; //계산이 완료되었는지 여부를 나타내는 변수
	
}

//원주율을 계산하는 쓰레드 클래스
class CalcPI extends Thread{
	private ShareData sd;
	
	public void setSd(ShareData sd) {
		
		this.sd=sd;
	}
	
	@Override
	public void run() {
		double sum=0.0;
		for(int i=1; i<1000000000; i+=2) {
			if((i/2)%2==0) {
				sum+=1.0/(double)i;
			}else {
				sum-=1.0/(double)i;
			}
		}
		sd.result=sum*4;
		sd.isOk=true;
	}
	
}

//계산된 원주율을 출력하는 쓰레드
class PrintPI extends Thread{
	private ShareData sd;

	public PrintPI(ShareData sd) {
		this.sd = sd;
	}
	@Override
	public void run() {
		while(true) {
			if(sd.isOk==true) {
				break;
			}
			Thread.yield();
		}
		
		System.out.println(sd.result);
		System.out.println(Math.PI);
	}
	
}






