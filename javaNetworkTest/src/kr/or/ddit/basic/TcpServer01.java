package kr.or.ddit.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	//TCP소켓 방식의 통신 프로그램으로 서버 역할을 한다.
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(7777);
		System.out.println("접속을 기다립니다...");
		
		//accept()
		//클라이언트의 연결요청이 올 때까지 계속 기다린다.
		//클라이언트의 요청이 오면 새로운 socket객체를 생성해서 클라이언트socket객체와 연결한다.
		Socket socket = server.accept();
		//이 accept()명령을 기술한 이후의 내용은 클라이언트와 연결 후에
		//처리할 내용들을 작성하면 된다.
		System.out.println("클라이언트와 연결되었습니다.");
		System.out.println();
		System.out.println("접속한 상대방 정보");
		System.out.println("ip주소: "+socket.getInetAddress().getHostAddress());
		System.out.println("port번호: "+socket.getPort());
		System.out.println();
		System.out.println("상대방과 접속이 완료된 현재 컴퓨터 정보...");
		System.out.println("현재 컴의 ip주소: "+socket.getLocalAddress());
		System.out.println("현재 컴의 port번호: "+socket.getLocalPort());
		System.out.println();
		System.out.println("--------------------------------------------------");
		
		//상대방(클라이언트)에게 메시지 보내기
		//socket객체의 outputstream객체를 구해서 데이터를 전송한다.
		//socket객체의 getoutputstream메소드 이용
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		//메시지 전송하기 ==> 출력스트림 이용해서 출력
		dout.writeUTF("환영합니다. 어서오세요");
		System.out.println("메시지를 보냈습니다.");
		
		dout.close();
		socket.close();
		server.close();
	}

}
