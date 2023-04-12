package kr.or.ddit.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//이 쓰레드 클래스는 소켓을 통해서 메시지를 보내는 역할을 한다.
public class Sender extends Thread {

	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner sc = new Scanner(System.in);
	public Sender(Socket socket) {
		this.socket = socket; //소켓 초기화
		System.out.println("이름입력 >>");
		this.name=sc.nextLine();
		
		//출력용 스트림객체 생성
		
		try {
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {

		while (dout!=null) {
			try {
				dout.writeUTF(name + ": " + sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	

}
