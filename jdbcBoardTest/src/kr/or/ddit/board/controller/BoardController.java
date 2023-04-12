package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	Scanner sc = new Scanner(System.in);
	BoardServiceImpl service = BoardServiceImpl.getInstance();
	static boolean searchflag=false;
	
	public static void main(String[] args) {
		new BoardController().start();
	}

	private void start() {
		
		int sel;
		out:while(true) {
			if(!searchflag) {
				display();
			}else {
				searchflag=false;
			}
			
			sel=Integer.parseInt(sc.nextLine());
			switch (sel) {
			case 1:
				createBoard();
				break;
			case 2:
				updateOrDeleteBoard();
				break;
			case 3:
				searchBoard();
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
	
	private void searchBoard() {
		System.out.println("검색작업");
		System.out.println("---------------------------------");
		System.out.print("검색할 제목 입력: ");
		String keyword = sc.nextLine();
		List<BoardVO> list = service.searchBoard(keyword);
		
		if(keyword=="") {
			
			searchflag=false;
			return;
		}
		display(list);
		searchflag=true;
	}

	private void deleteBoard(int sel) {
		// TODO Auto-generated method stub
		int res = service.deleteBoard(sel);
		
		if(res==1) {
			System.out.println(sel+"번 게시글이 삭제되었습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
		
	}

	private void updateBoard(int sel) {
		// TODO Auto-generated method stub
		
		System.out.println("");
		System.out.println("수정 작업하기");
		System.out.println("-------------------------------");
		System.out.print("제 목: ");
		String title = sc.nextLine();
		System.out.print("내 용: ");
		String content = sc.nextLine();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardNo(sel);
		boardVO.setBoardContent(content);
		boardVO.setBoardTitle(title);
		
		int res=service.updateBoard(boardVO);
		if(res==1) {
			System.out.println("수정이 완료되었습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}
	}

	private void updateOrDeleteBoard() {

		// TODO Auto-generated method stub
		System.out.print("보기를 원하는 게시물 번호 입력>>");
		int sel = Integer.parseInt(sc.nextLine());
		
		service.countIncre(sel);
		BoardVO selectBoard = service.selectBoard(sel);
		
		System.out.println();
		System.out.println(sel+"번 글의 내용");
		System.out.println("-------------------------------------");
		System.out.println("제 목:"+selectBoard.getBoardTitle());
		System.out.println("작성자:"+selectBoard.getBoardWriter());
		System.out.println("내 용:"+selectBoard.getBoardContent());
		System.out.println("작성일:"+selectBoard.getBoardDate());
		System.out.println("조회수:"+selectBoard.getBoardCnt());
		System.out.println("-------------------------------------");
		System.out.println("메뉴: 1. 수정 2. 삭제 3. 돌아가기");
		System.out.print("메뉴선택>>");
		int sel2 = Integer.parseInt(sc.nextLine());
		switch (sel2) {
		case 1:
			updateBoard(sel);
			break;
		case 2:
			deleteBoard(sel);
			break;
		case 3:
			return;
		default:
			System.out.println("잘못된 입력입니다.");
		}
		
	}

	private void createBoard() {
		System.out.println("-------------------------------------");
		System.out.print("제 목: ");
		String title=sc.nextLine();
		System.out.print("작성자: ");
		String writer=sc.nextLine();
		System.out.print("내 용: ");
		String content = sc.nextLine();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardContent(content);
		boardVO.setBoardTitle(title);
		boardVO.setBoardWriter(writer);
		
		int res = service.insertBoard(boardVO);
		if(res==1) {
			System.out.println("성공적으로 작성되었습니다.");
		}else {
			System.out.println("글작성에 실패하였습니다.");
		}
	}

	private void display() {
		System.out.println("-------------------------------------");
		System.out.println("no\t 제목\t 작성자\t 조회수");
		System.out.println("-------------------------------------");
		
		List<BoardVO> list = service.selectBoards();
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.getBoardNo()+"\t "+boardVO.getBoardTitle()+"\t "+boardVO.getBoardWriter()+"\t "+boardVO.getBoardCnt());			
		}
		System.out.println("-------------------------------------");
		System.out.println("메뉴: 1. 새글작성 2. 게시글보기 3. 검색 0. 작업끝");
		System.out.print("메뉴 선택>>");
	}
	private void display(List<BoardVO> list) {
		System.out.println("-------------------------------------");
		System.out.println("no\t 제목\t 작성자\t 조회수");
		System.out.println("-------------------------------------");
		
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.getBoardNo()+"\t "+boardVO.getBoardTitle()+"\t "+boardVO.getBoardWriter()+"\t "+boardVO.getBoardCnt());			
		}
		System.out.println("-------------------------------------");
		System.out.println("메뉴: 1. 새글작성 2. 게시글보기 3. 검색 0. 작업끝");
		System.out.print("메뉴 선택>>");
	}
}
