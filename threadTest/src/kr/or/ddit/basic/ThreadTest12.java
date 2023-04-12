package kr.or.ddit.basic;

import java.util.Random;

/*
 
 	3개의 쓰레드가 각각 알파벳 a~z까지를 출력하는데 출력을 끝낸 순서대로
 	결과를 나타내는 프로그램 만들기.
 
 */

public class ThreadTest12 {
	public static void main(String[] args) {
		Thread[] arr=new AlphabetPrint[] {
				new AlphabetPrint("스레드1"),
				new AlphabetPrint("스레드2"),
				new AlphabetPrint("스레드3")
		};
		
		for (Thread thread : arr) {
			thread.start();
		}
		
		for (Thread thread : arr) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println(AlphabetPrint.ranking);
	}
}

class AlphabetPrint extends Thread{
	public static String ranking="";
	private String name;
	
	
	public AlphabetPrint(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		Random rnd = new Random();
		for (int i = 65; i < 91; i++) {
			System.out.println(name+"의 출력문자: "+(char)i);
			
			try {
				Thread.sleep(rnd.nextInt(400)); //일시정지 시간을 난수로
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+"의 출력 끝.........");
		AlphabetPrint.ranking+=name+" ";
	}
	
}