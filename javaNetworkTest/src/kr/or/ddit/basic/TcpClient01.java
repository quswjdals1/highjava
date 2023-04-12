package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient01 {
	
	//TCP소켓 방식의 통신 프로그램으로 클라이언트 역할을 한다.
	//서버에 접속을 시도하고 접속이 완료되어 서버에서 보낸
	//환영매세지를 받아서 출력한다.

	public static void main(String[] args) throws IOException {
		/*
			현재의 컴퓨터를 나타내는 방법
			1. 원래의 ip주소: 예) 192.168.146.77
			2. 지정된 ip주소:	127.0.0.1
			3. 원래의 컴퓨터 이름: 예)DESKTOP-62TL3B4
			4. 지정된 컴퓨터 이름: localhost
			
		*/
		System.out.println("서버에 연결 중입니다...");
		System.out.println();
		//Socket socket = new Socket("상대방 ip주소",상대방 port번호);
		Socket socket = new Socket("localhost",7777);
		
		// 이부분 부터는 서버와 연결이 완료된 상태여야만 실행되는 코드다.
		System.out.println("서버에 연결되었습니다.");
		//상대방(서버)에서 보내온 메시지를 받아서 출력
		InputStream is = socket.getInputStream();
		DataInputStream din = new DataInputStream(is);
		
		System.out.println(din.readUTF());
		
		din.close();
		socket.close();
	}

}
