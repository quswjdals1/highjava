package kr.or.ddit.basic;

public class ThreadTest02 {
	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램
		
		//Thread 를 사용하는 방법
		
		//방법1
		// Thread클래스를 상속한 클래스를 작성한 후 이 클래스의 인스턴스를 생성한 후
		//이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread2 t2= new MyThread2();
		MyThread1 t1= new MyThread1();
		t1.start();
		t2.start();

		//방법2
		//Runnable 인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성
		//한다. 그리고 그 인스턴스를 thread객체를 생성할떄 생성자의 인수값으로 넣어서
		//생성한다. 이때 생성된 thread객체의 start()메서드를 호출해서 실행한다.
		Thread t3= new Thread(new MyTread3());
		Thread t4= new Thread(new MyTread4());
		t3.start();
		t4.start();
		
		
		//방법2-2
		//Runnable 인터페이스를 익명 구현체로 작성하여 처리하기
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		
	}
}

//방법1. Thread를 상속한 클래스 작성

class MyThread1 extends Thread{
	@Override
	public void run() {
		//run()은 쓰레드가 처리할 내용을 기술하는 곳 이다.
		for (int i = 0; i <200; i++) {
			System.out.print("*");
		}
	}

	
}
class MyThread2 extends Thread{
	@Override
	public void run() {
		//run()은 쓰레드가 처리할 내용을 기술하는 곳 이다.
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
		}
		
	}
	
}

//방법2. Runnable을 구현한 클래스 작성

class MyTread3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <200; i++) {
			System.out.print("*");
		}
	}
	
}

class MyTread4 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <200; i++) {
			System.out.print("$");
		}
	}
	
}