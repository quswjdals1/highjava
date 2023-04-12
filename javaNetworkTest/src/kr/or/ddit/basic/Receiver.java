package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//이 쓰레드 클래스는 소켓을 통해서 메시지를 받아서 화면에 출력함
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream din;
	
	//생성자
	public Receiver(Socket socket) {
		this.socket=socket;
		try {
			din= new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(din!=null) {
			try {
				//메시지를 받아서 화면에 출력
				System.out.println(din.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
