package kr.or.ddit.basic;

import java.util.Stack;

public class stackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser b = new Browser();
		
		b.history();
		b.goURL("1 네이버");
		b.history();
		b.goURL("2 구글");
		b.history();
		b.goURL("3 다음");
		b.goURL("4 네이트");
		b.history();
		
		System.out.println("뒤로가기");
		b.goBack();
		b.history();
		
		System.out.println("앞으로가기");
		b.goForward();
		b.history();
		
	}

}

class Browser{
	private Stack<String> back;
	private Stack<String> forward;
	private String currentURL;
	
	public Browser() {
		back = new Stack<>();
		forward = new Stack<>();
		currentURL= "";
	}
	
	public void goURL(String url) {
		System.out.println(url+"로 이동합니다.");
		
		if(currentURL!=null && !"".equals(currentURL)) {
			back.push(currentURL);
		}
		currentURL=url;
	}
	
	public void goBack() {
		if(!back.isEmpty()) {
			forward.push(currentURL);
			currentURL=back.pop();
		}
	}
	
	public void goForward() {
		if(!forward.isEmpty()) {
			back.push(currentURL);
			currentURL=forward.pop();
		}
	}
	
	public void history() {
		System.out.println();
		System.out.println(" 방 문 기 록");
		System.out.println("--------------------");
		System.out.println("back:  "+back);
		System.out.println("현재:   "+currentURL);
		System.out.println("forward: "+forward);
		System.out.println("--------------------");
		System.out.println();
	}
}