package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//로또 전체번호 중복확인 set
		Set<String> lottoSet = new HashSet<>();
		while(true) {
			
			System.out.println("로또 프로그램");
			System.out.println("---------------------");
			System.out.println("1. 로또 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("---------------------");
			System.out.print("매뉴 선택: ");
			int sel = sc.nextInt();
			if(sel==2) {
				System.out.println("프로그램 종료");
				break;
			}else if(sel==1) {
				System.out.println("로또 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력: ");
				int money=sc.nextInt();
				if(money<1000) {
					System.out.println("입력급액이 너무 적습니다");
					System.out.println("로또번호 구입 실패!!");
					continue;
				}
				if(money>100000) {
					System.out.println("입력급액이 너무 많습니다");
					System.out.println("로또번호 구입 실패!!");
					continue;
				}
				int cnt = money/1000;
				int rest= money%1000;
				for (int i = 0; i < cnt; i++) {
					Set<Integer> set = new HashSet<>();
					int a;
					List<Object> list;
					StringBuilder sb = new StringBuilder();
					
					//로또번호 전체 중복제거
					do {
						set.clear();
						while(set.size()<6) {//각각 중복제거
							a=(int) (Math.random() * (45-1+1)) + 1;
							set.add(a);
						}
						list=new ArrayList<>(set);
						for (int j = 0; j < list.size(); j++) {
							System.out.println(list.get(j));
						}
						sb.delete(0, sb.length());
						for (int j = 0; j < list.size(); j++) {
							sb.append(list.get(j) + " ");
								
						} 
					} while (lottoSet.contains(sb.toString()));
					
					lottoSet.add(sb.toString()); //중복 아닌 로또번호6개 set에 넣음
					
					System.out.println("행운의 로또번호는 다음과 같습니다.");
					System.out.println("로또번호"+(i+1)+": "+sb.toString());
					System.out.println();
				}
				System.out.println();
				System.out.println("받은 금액은 "+money+"이고 거스름돈은 "+rest+"입니다.");
			}
			
		
		
		}		
	}

}
