package kr.or.ddit.member.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberController {
	private Scanner sc;
	private IMemberService service;
	
	public MemberController() {
		sc = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
	}
	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	public void startMember() {
		out:while(true) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("---------------------");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2");
			System.out.println("6. 자료 수정3");
			System.out.println("0. 작업 끝");
			System.out.println("---------------------");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				insertMember();			
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				getAllMember();
				break;
			case 5:
				updateMember2();
				break;
			case 6:
				updateMember3();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break out;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			
		}
	}
	
	
	private void updateMember3() {
		// TODO Auto-generated method stub
		String set="";
		MemberVO memberVO = new MemberVO();
		int cnt=0;
		int res=0;
		System.out.println("수정할 자료의 id 입력: ");
		String id = sc.nextLine();
		memberVO.setMem_id(id);
		System.out.println("mem_pass 수정값 입력: ");
		String pass = sc.nextLine();
		if(!pass.equals("")) {
			memberVO.setMem_pass(pass);
		}
		System.out.println("mem_name 수정값 입력: ");
		String name = sc.nextLine();
		if(!name.equals("")) {
			memberVO.setMem_name(name);
		}
		System.out.println("mem_tel 수정값 입력: ");
		String tel = sc.nextLine();
		if(!tel.equals("")) {
			memberVO.setMem_tel(tel);
		}
		System.out.println("mem_addr 수정값 입력: ");
		String addr = sc.nextLine();
		if(!addr.equals("")) {
			memberVO.setMem_addr(addr);
		}

	

		res = service.updateMember3(memberVO);

		
	}
	private void updateMember2() {
		// TODO Auto-generated method stub
		int res=0;
		String sel = "";
		System.out.println("수정할 아이디 입력: ");
		String id = sc.nextLine();
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 주소 수정");
		String val="";
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(id);
		switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			sel="mem_pass";
			System.out.println("수정할 비밀번호 입력: ");
			val=sc.nextLine();
			memberVO.setMem_pass(val);
			break;
		case 2:
			sel="mem_name";
			System.out.println("수정할 이름 입력: ");
			val=sc.nextLine();
			memberVO.setMem_name(val);
			break;
		case 3:
			sel="mem_tel";
			System.out.println("수정할 전화번호 입력: ");
			val=sc.nextLine();
			memberVO.setMem_tel(val);
			break;
		case 4:
			sel="mem_addr";
			System.out.println("수정할 주소 입력: ");
			val=sc.nextLine();
			memberVO.setMem_addr(val);
			break;
		default:
			System.out.println("잘못된 입력입니다. 메인으로 돌아갑니다.");
			return;
		}
	
		res=service.updateMember2(memberVO);
		
		
		
	}
	private void getAllMember() {
		// TODO Auto-generated method stub
		
		System.out.println("id\t pass\t name\t tel\t addr 순");
		System.out.println("-------------------------------");
		List<MemberVO> list = service.getAllMember();
		for (MemberVO memberVO : list) {
			System.out.println(memberVO.getMem_id()+"\t"+memberVO.getMem_pass()+"\t"+memberVO.getMem_name()+"\t"+memberVO.getMem_tel()+"\t"+memberVO.getMem_addr()+"\t");
		}
		System.out.println("-------------------------------");
	}
	private void updateMember() {
		// TODO Auto-generated method stub
		System.out.println("수정할 자료의 id 입력: ");
		String id = sc.nextLine();
		System.out.println("mem_pass 수정값 입력: ");
		String pass = sc.nextLine();
		System.out.println("mem_name 수정값 입력: ");
		String name = sc.nextLine();
		System.out.println("mem_tel 수정값 입력: ");
		String tel = sc.nextLine();
		System.out.println("mem_addr 수정값 입력: ");
		String addr = sc.nextLine();
		
		int res=service.updateMember(new MemberVO(id, pass, name, tel, addr));
		if(res==1) {
			System.out.println("자료 수정에 성공했습니다.");
		}else {
			System.out.println("자료 수정에 실패했습니다.");
		}
	}
	private void deleteMember() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 자료의 id 입력: ");
		String id = sc.nextLine();
		
		int res = service.deleteMember(id);
		if(res==1) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제에 실패했습니다.");
		}
		
	}
	private void insertMember() {
		// TODO Auto-generated method stub
		int res=1;
		String id=null;
		String pass=null;
		String name=null;
		String tel=null;
		String addr=null;
		String sql;
		while (res!=0) {
			System.out.print("id 입력: ");
			id = sc.nextLine();

			res =service.getMemberCount(id);
			if(res==1) {
				System.out.println("중복된 아이디가 있습니다. 다시입력하세요");
			}
		}
		System.out.println("비밀번호 입력: ");
		pass=sc.nextLine();
		System.out.println("이름 입력: ");
		name=sc.nextLine();
		System.out.println("전화번호 입력: ");
		tel=sc.nextLine();
		System.out.println("주소 입력: ");
		addr=sc.nextLine();
		
		//입력된 자료를 vo객체에 담는다.
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(id);
		memberVO.setMem_pass(pass);
		memberVO.setMem_name(name);
		memberVO.setMem_tel(tel);
		memberVO.setMem_addr(addr);
		
		//Service의 insertMember()메소드를 호출해서 실행
		
		res = service.insertMember(memberVO);
		
		if(res>0) {
			System.out.println(id+ " 등록 성공");
		}else {
			System.out.println(id+" 등록 실패");
		}
		
	}
	private int displayMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("---------------------");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("6. 자료 수정3");
		System.out.println("0. 작업 끝");
		System.out.println("---------------------");
		
		return Integer.parseInt(sc.nextLine());
	}
}
