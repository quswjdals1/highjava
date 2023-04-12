package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/*
	10마리의 말들이 경주하는 프로그램 작성하기
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
	이 클래스는 말이름, 등수, 현재위치를 멤버변수로 갖는다.
	그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준을 갖고있다.
	
	경기 구간은 1~50이고 경기가 끝나면 등수순으로 출력한다.
	
	경기 중간에 각 말들의 위치를 아레와 같이 출력한다.
	예시)
	말이름 : >---------------------------------------
	말이름 : ->--------------------------------------
	말이름 : -->-------------------------------------
	말이름 : --->-----------------------------------
*/
public class ThreadTest13 {
	public static void print(int len) {
		for(int i=0; i<50; i++) {
			if(i==len) {
				System.out.print(">");
			}else {
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Horse[] arr = new Horse[] {
			new Horse("1번말"),
			new Horse("2번말"),
			new Horse("3번말"),
			new Horse("4번말"),
			new Horse("5번말"),
			new Horse("6번말"),
			new Horse("7번말"),
			new Horse("8번말"),
			new Horse("9번말"),
			new Horse("10번말")
		};
		
		for (Horse thread : arr) {
			thread.start();
		}
		
		while(true) {
			boolean check=false;
			for (Horse thread : arr) {
				if(thread.getLen()<49) {
					check=true;
				}
			}
			System.out.println("====================================================");
			for (Horse thread : arr) {
				System.out.print(thread.getname()+": ");
				print(thread.getLen());
			}
			if(!check) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("----------------------------");
		for (Horse thread : arr) {
			
			System.out.print(thread.getname()+": ");
			System.out.println(thread.getRank());
		}
		System.out.println("----------------------------");
		System.out.println(" 순위오름차순 정렬 후");
		System.out.println("----------------------------");
		Arrays.sort(arr);
		
		for (Horse thread : arr) {
			System.out.print(thread.getname()+": ");
			System.out.println(thread.getRank());
		}
		
		
 	}
}

class Horse extends Thread implements Comparable<Horse>{
	private static int order=1;
	private String name;
	private int rank;
	private int len;

	
	public Horse(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		Random rnd = new Random();
		while(len<49) {
			
			try {
				Thread.sleep(rnd.nextInt(260));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			len++;
		}
		rank=order;
		order++;
		
	}
	
	public String getname() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}

	@Override
	public int compareTo(Horse o) {
		// TODO Auto-generated method stub
		return this.rank-o.rank;
	}
	
	
	
}