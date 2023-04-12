package kr.or.ddit.basic;

//은행의 입출금을 쓰레드로 처리하는 예제(동기화 처리 예제)

public class ThreadTest16 {
	
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance=balance;
	}
	//입금하는 메소드
	public void deosit(int money) {
		this.balance+=money;
	}
	
	//출금하는 메소드 성공:true 싫패:flase
	public synchronized boolean withdraw(int money) {
		int temp=0;
		
		if(this.balance>=money) {
			for(int i=1; i<=100000000; i++) {
				temp++; //시간지연용
			}
		
			balance-=money;
			System.out.println("메소드 안에서 balance: "+balance);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ThreadTest16 ac = new ThreadTest16();
		ac.setBalance(10000);
		
		Runnable r= new Runnable() {
			
			@Override
			public void run() {
				boolean result = ac.withdraw(6000);
				System.out.println("쓰레드에서 result="+result+", balance ="+ac.getBalance());
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}
